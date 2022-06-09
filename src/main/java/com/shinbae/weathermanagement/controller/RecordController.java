package com.shinbae.weathermanagement.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shinbae.weathermanagement.dto.RecordDto;
import com.shinbae.weathermanagement.entity.*;
import com.shinbae.weathermanagement.service.city.impl.CityServiceImpl;
import com.shinbae.weathermanagement.service.clouds.impl.CloudsServiceImpl;
import com.shinbae.weathermanagement.service.coord.impl.CoordServiceImpl;
import com.shinbae.weathermanagement.service.main.impl.MainServiceImpl;
import com.shinbae.weathermanagement.service.record.impl.RecordServiceImpl;
import com.shinbae.weathermanagement.service.sys.impl.SysServiceImpl;
import com.shinbae.weathermanagement.service.weather.impl.WeatherServiceImpl;
import com.shinbae.weathermanagement.service.wind.impl.WindServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CityServiceImpl cityService;

    @Autowired
    private CloudsServiceImpl cloudsService;

    @Autowired
    private CoordServiceImpl coordService;

    @Autowired
    private MainServiceImpl mainService;

    @Autowired
    private RecordServiceImpl recordService;

    @Autowired
    private SysServiceImpl sysService;

    @Autowired
    private WeatherServiceImpl weatherService;

    @Autowired
    private WindServiceImpl windService;

    @GetMapping("/{cityName}")
    @Transactional
    public ResponseEntity<RecordDto> createRecord(@PathVariable String cityName) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=87cdd7f5bbfec3051219cb2cf72ef799&units=metric";
        String result = restTemplate.getForObject(url, String.class);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            RecordDto recordDto = objectMapper.readValue(result, RecordDto.class);
            System.out.println("Record Dto: " + recordDto);
            CityEntity cityEntity = new CityEntity(recordDto.getId(), recordDto.getCod(), recordDto.getName(), recordDto.getTimezone());
            RecordEntity recordEntity = new RecordEntity(recordDto.getDt(), recordDto.getVisibility(), recordDto.getBase());
            CloudsEntity cloudsEntity = modelMapper.map(recordDto.getClouds(),CloudsEntity.class);
            cloudsEntity.setRecord(recordEntity);
            System.out.println("Clouds Entity: " + cloudsEntity);
            CoordEntity coordEntity = modelMapper.map(recordDto.getCoord(),CoordEntity.class);
            coordEntity.setRecord(recordEntity);
            System.out.println("Coord Entity: " + coordEntity);
            MainEntity mainEntity = modelMapper.map(recordDto.getMain(),MainEntity.class);
            mainEntity.setRecord(recordEntity);
            System.out.println("Main Entity: " + mainEntity);
            SysEntity sysEntity = modelMapper.map(recordDto.getSys(),SysEntity.class);
            sysEntity.setRecord(recordEntity);
            System.out.println("Sys Entity: " + sysEntity);
            WindEntity windEntity = modelMapper.map(recordDto.getWind(),WindEntity.class);
            windEntity.setRecord(recordEntity);
            Set<WeatherEntity> weatherEntities= recordDto.getWeather().stream().map(weatherDto -> modelMapper.map(weatherDto,WeatherEntity.class)).collect(Collectors.toSet());
            recordEntity.setCity(cityEntity);
            recordEntity.setClouds(cloudsEntity);
            recordEntity.setCoordinate(coordEntity);
            recordEntity.setMain(mainEntity);
            recordEntity.setSysDetail(sysEntity);
            recordEntity.setWind(windEntity);
            System.out.println("Weather Entities: " + weatherEntities);
            System.out.println("Record Entity: " + recordEntity);
            for (WeatherEntity weatherEntity : weatherEntities) {
                weatherService.createWeather(weatherEntity);
            }
            cityService.createCity(cityEntity);
            recordEntity.setWeathers(weatherEntities);
            recordService.createRecord(recordEntity);
            coordService.createCoord(coordEntity);
            cloudsService.createClouds(cloudsEntity);
            mainService.createMain(mainEntity);
            sysService.createSys(sysEntity);
            windService.createWind(windEntity);
            return ResponseEntity.ok(recordDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}

package com.shinbae.weathermanagement.repository;

import com.shinbae.weathermanagement.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
}

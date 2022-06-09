package com.shinbae.weathermanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "main")
public class MainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "temperature")
    private double temp;

    @Column(name = "feels_like")
    private double feelsLike;

    @Column(name = "temp_min")
    private double tempMin;

    @Column(name = "temp_max")
    private double tempMax;

    @Column(name = "pressure")
    private int pressure;

    @Column(name = "humidity")
    private int humidity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id", referencedColumnName = "id")
    private RecordEntity record;

    public MainEntity(double temp, double feelsLike, double tempMin, double tempMax, int pressure, int humidity) {
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
    }
}

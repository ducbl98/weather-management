package com.shinbae.weathermanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "wind")
public class WindEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "speed")
    private double speed;

    @Column(name = "deg")
    private int deg;

    @Column(name = "gust")
    private double gust;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id", referencedColumnName = "id")
    private RecordEntity record;

    public WindEntity(double speed, int deg, double gust) {
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }
}

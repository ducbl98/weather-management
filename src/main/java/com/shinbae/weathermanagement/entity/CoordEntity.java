package com.shinbae.weathermanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "coordinate")
public class CoordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "longitude")
    private double lon;

    @Column(name = "latitude")
    private double lat;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id", referencedColumnName = "id")
    private RecordEntity record;

    public CoordEntity(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
}

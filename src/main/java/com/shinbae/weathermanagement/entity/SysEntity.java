package com.shinbae.weathermanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sys_detail")
public class SysEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "sys_id")
    private long sysId;

    @Column(name = "country")
    private String country;

    @Column(name = "sunrise")
    private int sunrise;

    @Column(name = "sunset")
    private int sunset;

    @Column(name = "type")
    private int type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id", referencedColumnName = "id")
    private RecordEntity record;

    public SysEntity(int sysId, String country, int sunrise, int sunset, int type) {
        this.sysId = sysId;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.type = type;
    }
}

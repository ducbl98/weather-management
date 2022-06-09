package com.shinbae.weathermanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "record")
public class RecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "dt")
    private long dt;

    @Column(name = "visibility")
    private long visibility;

    @Column(name = "base")
    private String base;

    @Temporal(TemporalType.DATE)
    @Column(name = "measure_date")
    Date measureDate;

    @Temporal(TemporalType.TIME)
    @Column(name = "measure_time")
    Date measureTime;

    @OneToOne(mappedBy = "record", cascade = CascadeType.ALL)
    private CloudsEntity clouds;

    @OneToOne(mappedBy = "record", cascade = CascadeType.ALL)
    private CoordEntity coordinate;

    @OneToOne(mappedBy = "record", cascade = CascadeType.ALL)
    private MainEntity main;

    @OneToOne(mappedBy = "record", cascade = CascadeType.ALL)
    private SysEntity sysDetail;

    @ManyToMany(mappedBy = "records")
    private Set<WeatherEntity> weathers;

    @OneToOne(mappedBy = "record", cascade = CascadeType.ALL)
    private WindEntity wind;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id",nullable = false)
    private CityEntity city;

    public RecordEntity(long dt, long visibility, String base) {
        this.dt = dt;
        this.visibility = visibility;
        this.base = base;
        this.clouds = new CloudsEntity();
        this.coordinate = new CoordEntity();
        this.main = new MainEntity();
        this.sysDetail = new SysEntity();
        this.weathers = new HashSet<>();
        this.wind = new WindEntity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordEntity that = (RecordEntity) o;
        return id == that.id && dt == that.dt && visibility == that.visibility && base.equals(that.base) &&
                measureDate.equals(that.measureDate) && measureTime.equals(that.measureTime) &&
                Objects.equals(clouds, that.clouds) && Objects.equals(coordinate, that.coordinate) &&
                Objects.equals(main, that.main) && Objects.equals(sysDetail, that.sysDetail) &&
                Objects.equals(weathers, that.weathers) && Objects.equals(wind, that.wind) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dt, visibility, base, measureDate, measureTime, clouds, coordinate, main, sysDetail, weathers, wind, city);
    }
}

package com.shinbae.weathermanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "weather")
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "weather_id")
    private long weatherId;

    @Column(name = "main")
    private String main;

    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private String icon;

    @ManyToMany
    @JoinTable(name = "record_weather",
            joinColumns = {@JoinColumn(name = "weather_id")},
            inverseJoinColumns = @JoinColumn(name = "record_id"))
    private Set<RecordEntity> records;

    public WeatherEntity(int weatherId, String icon, String description, String main) {
        this.weatherId = weatherId;
        this.icon = icon;
        this.description = description;
        this.main = main;
        this.records = new HashSet<>();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherEntity that = (WeatherEntity) o;
        return id == that.id && weatherId == that.weatherId && main.equals(that.main) &&
                description.equals(that.description) && icon.equals(that.icon) &&
                Objects.equals(records, that.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weatherId, main, description, icon, records);
    }
}

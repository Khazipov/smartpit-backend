package com.kvpr.smartpit.model;

import javax.persistence.*;

@Entity
@Table
public class Pit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double latitude;
    Double longitude;
    Integer category = 0;

    public Pit() {
    }

    public Pit(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Pit(Double latitude, Double longitude, Integer category) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}

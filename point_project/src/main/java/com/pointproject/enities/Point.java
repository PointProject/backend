package com.pointproject.enities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Point implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_seq_gen")
    @SequenceGenerator(name = "point_seq_gen", sequenceName = "point_id_seq", allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "zone")
    @JsonIgnore
    private Zone zone;

    private double latitude;

    private double longitude;

    private int numberInSequence;

    public Point() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public int getNumberInSequence() {
        return numberInSequence;
    }

    public void setNumberInSequence(int numberInSequence) {
        this.numberInSequence = numberInSequence;
    }
}

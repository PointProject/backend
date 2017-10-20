package com.pointproject.enities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Point implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "zone")
    private Zone zone;

    private double latitude;

    private double longitude;

    public Point() {
    }
}

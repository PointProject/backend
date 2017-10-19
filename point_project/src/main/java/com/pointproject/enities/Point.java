package com.pointproject.enities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "zone")
    private Zone zone;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;


}

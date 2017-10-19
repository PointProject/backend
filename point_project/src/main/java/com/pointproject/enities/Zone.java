package com.pointproject.enities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Zone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="city", nullable=false)
    private City city;

    private String title;

    private String fillColor;

    private String strokeColor;

    @OneToMany(mappedBy = "zone")
    private Set<Point> points;

    @OneToMany(mappedBy = "zone")
    private Set<MoneyPoint> moneyPoints;

    public Zone() {
    }
}

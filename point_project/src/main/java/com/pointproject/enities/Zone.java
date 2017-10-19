package com.pointproject.enities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="city", nullable=false)
    private City city;

    private String title;

    private String fillColor;

    private String strokeColor;

    @ManyToOne
    @JoinColumn(name="zone", nullable=false)
    private Set<Point> points;

    @ManyToOne
    @JoinColumn(name="zone", nullable=false)
    private Set<MoneyPoint> moneyPoints;

}

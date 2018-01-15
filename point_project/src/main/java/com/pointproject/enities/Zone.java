package com.pointproject.enities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Zone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="city")
    private City city;

    private String title;

    private String fillColor;

    private String strokeColor;

    @OneToMany(mappedBy = "zone")
    private Set<Point> points;

    @OneToMany(mappedBy = "zone")
    @JsonIgnore
    private Set<MoneyPoint> moneyPoints;

    public Zone() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<MoneyPoint> getMoneyPoints() {
        return moneyPoints;
    }

    public void setMoneyPoints(Set<MoneyPoint> moneyPoints) {
        this.moneyPoints = moneyPoints;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

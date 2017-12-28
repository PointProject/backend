package com.pointproject.enities;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class City implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    @ManyToOne
    @JoinColumn(name="country")
    private Country country;

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private List<Zone> zones;

    public City() {
    }

    public City(String title) {
        this.title = title;
    }

    public City(Country country, String title) {
        this.country = country;
        this.title = title;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Zone> getZones() {
        return zones;
    }

    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    @Override
    public String toString() {
        return "City{" +
                "country=" + country +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", zones=" + zones +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equal(id, city.id) &&
                Objects.equal(title, city.title) &&
                Objects.equal(country, city.country) &&
                Objects.equal(zones, city.zones);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, title, country, zones);
    }
}

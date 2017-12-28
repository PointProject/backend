package com.pointproject.enities;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<City> cities = new ArrayList<>();

    public Country(String title) {
        this.title = title;
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

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return Objects.equal(id, country.id) &&
                Objects.equal(title, country.title) &&
                Objects.equal(cities, country.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, title, cities);
    }

    @Override
    public String toString() {
        return "Country{" +
                "title='" + title + '\'' +
                ", cities=" + this.getCities() +
                '}';
    }

    public Country() {
    }

}
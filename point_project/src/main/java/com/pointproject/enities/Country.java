package com.pointproject.enities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    @OneToMany(mappedBy = "country",fetch = FetchType.EAGER)
    private Set<City> cities;

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

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id &&
                com.google.common.base.Objects.equal(title, country.title) &&
                com.google.common.base.Objects.equal(cities, country.cities);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(id, title, cities);
    }

    @Override
    public String toString() {
        return "Country{" +
                "title='" + title + '\'' +
                ", cities=" + cities +
                '}';
    }

    public Country() {
    }
}
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

    @OneToMany(mappedBy = "country")
    private Set<City> cities;

    public Country(String title) {
        this.title = title;
    }

    public Country() {
    }
}
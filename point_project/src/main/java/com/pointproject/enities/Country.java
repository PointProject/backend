package com.pointproject.enities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    @OneToMany(mappedBy = "country")
    private Set<City> cities;


}
package com.pointproject.enities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class City implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="country", nullable=false)
    private Country country;

    @OneToMany(mappedBy = "city")
    private Set<Zone> zones;

    public City() {
    }
}

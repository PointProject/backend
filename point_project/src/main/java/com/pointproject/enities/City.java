package com.pointproject.enities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class City implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String title;

    @ManyToOne
    @JoinColumn(name="country", nullable=false)
    private Country country;

    @OneToMany(mappedBy = "city")
    private Set<Zone> zones;

    public City() {
    }
}

package com.pointproject.enities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String title;

    @ManyToOne
    @JoinColumn(name="country", nullable=false)
    private Country country;
}

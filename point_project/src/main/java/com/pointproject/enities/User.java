package com.pointproject.enities;

import com.sun.istack.internal.NotNull;
import javafx.beans.DefaultProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private int money;

    @NotNull
    private int phone;

    @NotNull
    private int age;

    @ManyToOne
    @JoinColumn(name="city", nullable=false)
    private City city;

    @ManyToOne
    @JoinColumn(name="level", nullable=false)
    private Level level;

    @OneToMany(mappedBy = "user")
    private Set<MoneyPoint> moneyPoints;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "users")
    private Set<Race> races;

    @NotNull
    private int expNum;

    public User() {
    }
}

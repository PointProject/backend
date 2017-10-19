package com.pointproject.enities;

import com.sun.istack.internal.NotNull;
import javafx.beans.DefaultProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class User implements Serializable {

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

    public User(String login, String password, String firstName, String lastName, int money, int phone, int age, City city, Level level, int expNum) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
        this.phone = phone;
        this.age = age;
        this.city = city;
        this.level = level;
        this.expNum = expNum;
    }
}

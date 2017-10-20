package com.pointproject.enities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class GameUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private int money;

    private int phone;

    private int age;

    @ManyToOne
    @JoinColumn(name="city")
    private City city;

    @ManyToOne
    @JoinColumn(name="level")
    private Level level;

    @OneToMany(mappedBy = "gameUser")
    private Set<MoneyPoint> moneyPoints;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "gameUsers")
    private Set<Race> races;

    private int expNum;

    public GameUser() {
    }

    public GameUser(String login, String password, String firstName, String lastName, int money, int phone, int age, City city, Level level, int expNum) {
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

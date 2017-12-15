package com.pointproject.enities;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

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

    public GameUser(String login, String password, String firstName, String lastName, int age) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Set<MoneyPoint> getMoneyPoints() {
        return moneyPoints;
    }

    public void setMoneyPoints(Set<MoneyPoint> moneyPoints) {
        this.moneyPoints = moneyPoints;
    }

    public Set<Race> getRaces() {
        return races;
    }

    public void setRaces(Set<Race> races) {
        this.races = races;
    }

    public int getExpNum() {
        return expNum;
    }

    public void setExpNum(int expNum) {
        this.expNum = expNum;
    }

    @Override
    public String toString() {
        return "GameUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", money=" + money +
                ", phone=" + phone +
                ", age=" + age +
                ", city=" + city +
                ", level=" + level +
                ", moneyPoints=" + moneyPoints +
                ", races=" + races +
                ", expNum=" + expNum +
                '}';
    }
}

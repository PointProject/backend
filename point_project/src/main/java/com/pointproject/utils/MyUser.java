package com.pointproject.utils;

import com.pointproject.enities.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public final class MyUser extends GameUser {
    public MyUser() {
    }

    public MyUser(String login, String password, String firstName, String lastName, int money, int phone, int age, City city, Level level, int expNum) {
        super(login, password, firstName, lastName, money, phone, age, city, level, expNum);
    }

    public MyUser(String login, String password, String firstName, String lastName, int age) {
        super(login, password, firstName, lastName, age);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    public void setLogin(String login) {
        super.setLogin(login);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public int getMoney() {
        return super.getMoney();
    }

    @Override
    public void setMoney(int money) {
        super.setMoney(money);
    }

    @Override
    public int getPhone() {
        return super.getPhone();
    }

    @Override
    public void setPhone(int phone) {
        super.setPhone(phone);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public City getCity() {
        return super.getCity();
    }

    @Override
    public void setCity(City city) {
        super.setCity(city);
    }

    @Override
    public Level getLevel() {
        return super.getLevel();
    }

    @Override
    public void setLevel(Level level) {
        super.setLevel(level);
    }

    @Override
    public Set<MoneyPoint> getMoneyPoints() {
        return super.getMoneyPoints();
    }

    @Override
    public void setMoneyPoints(Set<MoneyPoint> moneyPoints) {
        super.setMoneyPoints(moneyPoints);
    }

    @Override
    public Set<Race> getRaces() {
        return super.getRaces();
    }

    @Override
    public void setRaces(Set<Race> races) {
        super.setRaces(races);
    }

    @Override
    public int getExpNum() {
        return super.getExpNum();
    }

    @Override
    public void setExpNum(int expNum) {
        super.setExpNum(expNum);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
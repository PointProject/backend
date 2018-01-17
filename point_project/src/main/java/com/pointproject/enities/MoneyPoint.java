package com.pointproject.enities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MoneyPoint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moneypoint_seq_gen")
    @SequenceGenerator(name = "moneypoint_seq_gen", sequenceName = "moneypoint_id_seq", allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name="gameUser")
    private GameUser gameUser;

    private int value;

    private double latitude;

    private double longitude;

    private int isActivated;

    @ManyToOne
    @JoinColumn(name="zone")
    private Zone zone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race")
    private Race race;

    public MoneyPoint() {
    }

    public GameUser getGameUser() {
        return gameUser;
    }

    public void setGameUser(GameUser gameUser) {
        this.gameUser = gameUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(int isActivated) {
        this.isActivated = isActivated;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}

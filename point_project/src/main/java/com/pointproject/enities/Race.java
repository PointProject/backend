package com.pointproject.enities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Race implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "race_seq_gen")
    @SequenceGenerator(name = "race_seq_gen", sequenceName = "race_id_seq", allocationSize = 1)
    private int id;

    private String title;

    @ManyToMany
    @JoinTable(name="race_user")
    private Set<GameUser> gameUsers;

    @OneToOne(mappedBy = "race", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private MoneyPoint moneyPoint;

    private String startTime;

    private String duration;

    public Race() {
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Set<GameUser> getGameUsers() {
        return gameUsers;
    }

    public void setGameUsers(Set<GameUser> gameUsers) {
        this.gameUsers = gameUsers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MoneyPoint getMoneyPoint() {
        return moneyPoint;
    }

    public void setMoneyPoint(MoneyPoint moneyPoint) {
        this.moneyPoint = moneyPoint;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

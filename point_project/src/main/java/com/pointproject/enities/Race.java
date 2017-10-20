package com.pointproject.enities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Race implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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
}

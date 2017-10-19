package com.pointproject.enities;

import com.sun.istack.internal.NotNull;

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
    private Set<User> users;

    @OneToOne(mappedBy = "race", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private MoneyPoint moneyPoint;

    @NotNull
    private String startTime;

    @NotNull
    private String duration;

    public Race() {
    }
}

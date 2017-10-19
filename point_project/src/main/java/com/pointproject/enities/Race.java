package com.pointproject.enities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany
    @JoinTable(name="race_user")
    private Set<User> users;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moneyPoint")
    private MoneyPoint moneyPoint;

    @NotNull
    private String startTime;

    @NotNull
    private String duration;

}

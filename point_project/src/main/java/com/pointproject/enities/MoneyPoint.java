package com.pointproject.enities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MoneyPoint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="user", nullable=false)
    private User user;

    private int value;

    private double latitude;

    private double longitude;

    private boolean isActivated;

    @ManyToOne
    @JoinColumn(name="zone", nullable=false)
    private Zone zone;

    @OneToOne(mappedBy = "moneyPoint", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Race race;

    public MoneyPoint() {
    }
}

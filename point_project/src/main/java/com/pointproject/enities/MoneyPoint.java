package com.pointproject.enities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MoneyPoint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

/*    @ManyToOne
    @JoinColumn(name="user")
    private User user;*/

    private int value;

    private double latitude;

    private double longitude;

    private boolean isActivated;

    @ManyToOne
    @JoinColumn(name="zone")
    private Zone zone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race")
    private Race race;

    public MoneyPoint() {
    }
}

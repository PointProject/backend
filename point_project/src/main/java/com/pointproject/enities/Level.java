package com.pointproject.enities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Level implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int levelNum;

    private int expNum;

    @OneToMany(mappedBy = "level")
    private Set<GameUser> gameUsers;

    public Level() {
    }
}

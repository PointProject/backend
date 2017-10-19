package com.pointproject.enities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Level implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private int levelNum;

    @NotNull
    private int expNum;

    @OneToMany(mappedBy = "level")
    private Set<User> users;

    public Level() {
    }
}

package com.pointproject.utils;

import com.pointproject.enities.GameUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public final class UserHandler {

    private GameUser gameUser;

    public UserHandler(GameUser gameUser) {
        this.gameUser = gameUser;
    }

    public GameUser getGameUser() {
        return gameUser;
    }

    public void setGameUser(GameUser gameUser) {
        this.gameUser = gameUser;
    }
}

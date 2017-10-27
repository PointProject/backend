package com.pointproject.controllers;

import com.google.common.collect.Lists;
import com.pointproject.enities.GameUser;
import com.pointproject.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/secure")
public class SecureController {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/user/users")
    public String loginSuccess() {
        return "Login Successful!";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public GameUser findByEmail(@RequestBody String login) {
        List<GameUser> gameUsers = userRepo.findAll();
        for (GameUser gameUser: gameUsers){
            if (gameUser.getLogin().equals(login)){
                return gameUser;
            }
        }
        return null;
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public GameUser updateUser(@RequestBody GameUser user) {
        return userRepo.save(user);
    }
}

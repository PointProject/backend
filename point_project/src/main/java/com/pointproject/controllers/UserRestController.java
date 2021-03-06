package com.pointproject.controllers;

import java.util.Date;

import javax.servlet.ServletException;

import com.pointproject.enities.GameUser;
import com.pointproject.repositories.UserRepo;
import com.pointproject.utils.MyToken;
import com.pointproject.utils.MyUser;
import com.pointproject.utils.UserHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost", maxAge = 3600)
public class UserRestController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserHandler userHandler;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<MyToken> registerUser(@RequestBody GameUser user) throws ServletException {
        for (GameUser gameUser : userRepo.findAll()){
            if (user.getLogin()
                .equals(gameUser.getLogin())) {
                throw new ServletException("Login '" + user.getLogin() + "' is exist.");
            }
            if (user.getPhone()
                .equals(gameUser.getPhone())) {
                throw new ServletException("Phone '" + user.getPhone() + "' is exist.");
            }
        }
        userRepo.save(user);
        String jwtToken = Jwts.builder().setSubject(user.getLogin()).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "pr!vet9vov@n").compact();
        return new ResponseEntity<>(new MyToken(jwtToken),HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<MyToken> login(@RequestBody GameUser userLogin) throws ServletException {

        String jwtToken;

        if (userLogin.getLogin() == null || userLogin.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String login = userLogin.getLogin();
        String password = userLogin.getPassword();

        GameUser user = null;

        for (GameUser gameUser: userRepo.findAll()){
            if (gameUser.getLogin().equals(login)){
                user = gameUser;
                break;
            }
        }

        if (user == null) {
            throw new ServletException("User login not found.");
        }

        String pwd = user.getPassword();

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your login and password.");
        }

        jwtToken = Jwts.builder().setSubject(login).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "pr!vet9vov@n").compact();

        userHandler.setGameUser(new MyUser(user.getLogin(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getMoney(),user.getPhone(),user.getAge(),user.getCity(),user.getLevel(),user.getExpNum()));

        return new ResponseEntity<>(new MyToken(jwtToken),HttpStatus.OK);
    }
}

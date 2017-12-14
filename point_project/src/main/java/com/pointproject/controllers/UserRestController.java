package com.pointproject.controllers;

import com.pointproject.enities.GameUser;
import com.pointproject.repositories.UserRepo;
import com.pointproject.utils.MyToken;
import com.pointproject.utils.MyUser;
import com.pointproject.utils.UserHandler;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost", maxAge = 3600)
public class UserRestController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserHandler userHandler;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public GameUser registerUser(@RequestBody GameUser user) {
        return userRepo.save(user);
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
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

        userHandler.setGameUser((MyUser) user);

        return new ResponseEntity<>(new MyToken(jwtToken),HttpStatus.OK);
    }
}

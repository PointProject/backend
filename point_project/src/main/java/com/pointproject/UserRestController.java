package com.pointproject;

import com.pointproject.enities.User;
import com.pointproject.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class UserRestController {

   @Autowired
   private UserRepo userRepo;

    @GetMapping("userList")
    public List<User> customersList() {
        return userRepo.findAll();
    }
}

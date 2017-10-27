package com.pointproject.controllers;

import com.pointproject.enities.Country;
import com.pointproject.repositories.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost", maxAge = 3600)
public class CountryRestController {

    @Autowired
    private CountryRepo countryRepo;

    @GetMapping("countryList")
    public List<Country> customersList() {
        return countryRepo.findAll();
    }
}
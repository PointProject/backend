package com.pointproject.controllers;

import com.pointproject.enities.*;
import com.pointproject.repositories.*;
import com.pointproject.utils.UserHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/secure")
public class SecureController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private LevelRepo levelRepo;

    @Autowired
    private MoneyPointRepo moneyPointRepo;

    @Autowired
    private PointRepo pointRepo;

    @Autowired
    private RaceRepo raceRepo;

    @Autowired
    private ZoneRepo zoneRepo;

    @Autowired
    private UserHandler userHandler;

    private static final Logger log = Logger.getLogger(SecureController.class);


    //---------------------USER--------------------------

    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    public ResponseEntity<GameUser> getUserFromHandler(){
        if (userHandler.getGameUser() != null) {
            return new ResponseEntity<>(userHandler.getGameUser(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public GameUser findByLogin(@RequestBody String login) {
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

    //---------------------USER--------------------------

    //---------------------Country--------------------------
    @RequestMapping(value = "/country/list", method = RequestMethod.GET)
    public List<Country> countryList (){
        return countryRepo.findAll();
    }

    @RequestMapping(value = "/country/update", method = RequestMethod.POST)
    public Country updateCountry(@RequestBody Country country) {
        return countryRepo.save(country);
    }
    //---------------------Country--------------------------


    //---------------------City--------------------------

    @RequestMapping(value = "/city/list", method = RequestMethod.GET)
    public List<City> cityList (){
        return cityRepo.findAll();
    }

    @RequestMapping(value = "/city/update", method = RequestMethod.POST)
    public City updateCity(@RequestBody City city) {
        return cityRepo.save(city);
    }
    //---------------------City--------------------------


    //---------------------Level--------------------------
    @RequestMapping(value = "/level/list", method = RequestMethod.GET)
    public List<Level> levelList (){
        return levelRepo.findAll();
    }
    //---------------------Level--------------------------

    @RequestMapping(value = "/level/update", method = RequestMethod.POST)
    public Level updateLevel(@RequestBody Level level) {
        return levelRepo.save(level);
    }

    //---------------------MoneyPoint--------------------------
    @RequestMapping(value = "/moneypoint/list", method = RequestMethod.GET)
    public List<MoneyPoint> moneyPointList (){
        return moneyPointRepo.findAll();
    }

    @RequestMapping(value = "/moneypoint/update", method = RequestMethod.POST)
    public MoneyPoint updateMoneyPoint(@RequestBody MoneyPoint moneyPoint) {
        return moneyPointRepo.save(moneyPoint);
    }

    //---------------------MoneyPoint--------------------------


    //---------------------Point--------------------------

    @RequestMapping(value = "/point/list", method = RequestMethod.GET)
    public List<Point> pointList (){
        return pointRepo.findAll();
    }

    @RequestMapping(value = "/point/update", method = RequestMethod.POST)
    public Point updatePoint(@RequestBody Point point) {
        return pointRepo.save(point);
    }
    //---------------------Point--------------------------


    //---------------------Race--------------------------
    @RequestMapping(value = "/race/list", method = RequestMethod.GET)
    public List<Race> raceList (){
        return raceRepo.findAll();
    }

    @RequestMapping(value = "/race/update", method = RequestMethod.POST)
    public Race updateRace(@RequestBody Race race) {
        return raceRepo.save(race);
    }

    //---------------------Race--------------------------


    //---------------------Zone--------------------------

    @RequestMapping(value = "/zone/list", method = RequestMethod.GET)
    public List<Zone> zoneList (){
        return zoneRepo.findAll();
    }

    @RequestMapping(value = "/zone/update", method = RequestMethod.POST)
    public Zone updateZone(@RequestBody Zone zone) {
        if (zone.getPoints() != null && zone.getPoints().size() > 0){
            List<Point> zonePoints = new ArrayList<>(zone.getPoints());
            zone = zoneRepo.save(zone);
            for (Point point : zonePoints){
                point.setZone(zone);
            }
            zonePoints = pointRepo.save(zonePoints);
            zone.setPoints(zonePoints);
            return zone;
        }
        return zoneRepo.save(zone);
    }
    //---------------------Zone--------------------------


}

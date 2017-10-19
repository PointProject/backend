package com.pointproject.repositories;

import com.pointproject.enities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CityRepo extends JpaRepository<City,Integer>{
}

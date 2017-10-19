package com.pointproject.repositories;

import com.pointproject.enities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CountryRepo extends JpaRepository<Country,Integer>{
}

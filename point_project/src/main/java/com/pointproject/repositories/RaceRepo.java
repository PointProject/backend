package com.pointproject.repositories;

import com.pointproject.enities.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RaceRepo extends JpaRepository<Race,Integer>{
}

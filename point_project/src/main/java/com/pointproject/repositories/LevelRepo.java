package com.pointproject.repositories;

import com.pointproject.enities.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LevelRepo extends JpaRepository<Level,Integer>{
}
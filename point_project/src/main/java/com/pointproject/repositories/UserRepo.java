package com.pointproject.repositories;

import com.pointproject.enities.GameUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<GameUser,Integer>{
}
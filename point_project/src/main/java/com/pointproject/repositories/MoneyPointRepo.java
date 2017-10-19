package com.pointproject.repositories;

import com.pointproject.enities.MoneyPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MoneyPointRepo extends JpaRepository<MoneyPoint,Integer>{

}
package com.pointproject.repositories;

import com.pointproject.enities.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PointRepo extends JpaRepository<Point,Integer>{
}
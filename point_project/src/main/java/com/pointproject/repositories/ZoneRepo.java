package com.pointproject.repositories;

import com.pointproject.enities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ZoneRepo extends JpaRepository<Zone,Integer>{
}

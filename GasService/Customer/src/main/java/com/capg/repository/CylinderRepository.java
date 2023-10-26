package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entities.Cylinder;
import java.util.List;


@Repository
public interface CylinderRepository extends JpaRepository<Cylinder,Integer>{

	List<Cylinder> findByType(String type);
}

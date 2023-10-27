package com.capg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entity.Ambulance;

@Repository
public interface AmbulanceRepository extends JpaRepository<Ambulance, String>{
	
	public Ambulance findByAmbulanceId(String ambulanceId);
	
	public List<Ambulance> findByambDriverLocation(String location);
	
	public Ambulance findByAmbDriverEmailId(String ambDriverEmailId);
	public Ambulance findByAmbDriverEmailIdAndAmbDriverPassword(String ambDriverEmailId, String ambDriverPassword);
}

package com.capg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entity.Hospital;


@Repository
public interface HospitalRepository extends JpaRepository<Hospital, String>{
	
	List<Hospital> findByHospitalLocation(String hospitalLocation);
	Hospital findByHospitalEmailIdAndHospitalPassword(String hospitalEmailId, String hospitalPassword);
	Optional<Hospital> getHospitalByHospitalEmailId(String hospitalEmailId);
	
}

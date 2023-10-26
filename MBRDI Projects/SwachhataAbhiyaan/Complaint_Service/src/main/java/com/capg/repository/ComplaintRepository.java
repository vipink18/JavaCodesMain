package com.capg.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entities.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, UUID>{

}

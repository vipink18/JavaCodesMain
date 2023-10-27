package com.capg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Ambulance")
public class Ambulance {
	
	@Id
	private String ambulanceId;
	private String ambDriverName;
	private String ambDriverEmailId;
	private String ambDriverContactNumber;
	private String ambDriverPassword;
	private String ambDriverLocation;
	private String ambStatus;
	private String ambType; 
	
}

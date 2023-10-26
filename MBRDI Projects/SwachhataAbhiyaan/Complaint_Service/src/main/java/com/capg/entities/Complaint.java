package com.capg.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Complaint {
	
	@Id
	@GeneratedValue
	private UUID complaintUuid;
	private String description;
	private String image;
	private String type;
 
}

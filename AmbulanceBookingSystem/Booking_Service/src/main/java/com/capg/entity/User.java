package com.capg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
	
	// private String userId;

	
	private String userName;

	private String userContactNumber;

	private String userEmailId;

	// private String userPassword;

	private String userLocation;

}

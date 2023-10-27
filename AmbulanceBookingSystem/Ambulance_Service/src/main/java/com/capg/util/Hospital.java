package com.capg.util;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
	
	@Id
	private String hospitalId;
	private String hospitalName;
	private String hospitalContactNumber;
	private String hospitalAddress;
	private String hospitalEmail;
	private String hospitalLocation;
	private String hospitalPassword;
}

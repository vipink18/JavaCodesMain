package com.capg.util;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ambulance {
	@Id
	private String ambulanceId;
	private String ambDriverName;
	private String ambDriverEmailId;
	private String ambDriverContactNumber;
	private String ambDriverPassword;
	private String ambDriverLocation;
	private boolean ambStatus;
	private String ambType;
}

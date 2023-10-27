package com.capg.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Hospital {

	// private String hospitalId;
	private String hospitalName;
	private String hospitalContactNumber;
	private String hospitalAddress;
	private String hospitalEmailId;
	// private String hospitalPassword;
}

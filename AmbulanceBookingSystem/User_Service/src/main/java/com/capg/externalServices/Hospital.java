package com.capg.externalServices;

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

	private String hospitalName;
	private String hospitalContactNumber;
	private String hospitalAddress;
	private String hospitalEmailId;
}

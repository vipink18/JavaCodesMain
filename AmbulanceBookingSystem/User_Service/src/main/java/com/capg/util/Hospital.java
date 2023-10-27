package com.capg.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
	
	private String hospitalId;
    private String hospitalName;
    private String hospitalContactNumber;
    private String hospitalAddress;
    private String hospitalLocation;
    private String hospitalEmailId;
    private String hospitalPassword;
}

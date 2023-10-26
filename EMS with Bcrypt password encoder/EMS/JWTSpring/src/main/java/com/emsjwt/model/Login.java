package com.emsjwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document(collection = "users")
public class Login {
	
	private String username;
	private String password;
	private String role;
	

}

package com.emsjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filtered")
public class GodController {
	
	@GetMapping("/test")
	public String test() {
		return "Success";
	}

}

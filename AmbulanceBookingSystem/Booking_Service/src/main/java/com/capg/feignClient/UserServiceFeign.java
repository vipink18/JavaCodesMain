package com.capg.feignClient;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.entity.User;

@FeignClient(name = "USER-SERVICE",url = "localhost:2021/api/v1/user")
public interface UserServiceFeign {

	@GetMapping("/getUserById/{userId}")
	public Optional<User> getUserById(@PathVariable String userId);
	
}

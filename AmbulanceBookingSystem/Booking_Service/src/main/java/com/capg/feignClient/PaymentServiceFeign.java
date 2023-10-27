package com.capg.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.capg.entity.Payment;

@FeignClient(name = "PAYMENT-SERVICE",url = "localhost:2026/api/v1/payment")
public interface PaymentServiceFeign {

	@GetMapping("/getByTransaction/{transactionId}")
	Payment findByTransactionId(@PathVariable String transactionId);
	
	@PostMapping("/doPayment/{userId}/{ambulanceType}")
    public Payment doPayment(@PathVariable String userId,@PathVariable String ambulanceType);
}

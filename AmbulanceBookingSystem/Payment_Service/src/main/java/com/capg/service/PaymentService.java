package com.capg.service;

import com.capg.entity.Payment;

public interface PaymentService {
	
	
	public String paymentProcessing();	
	public Payment addPayment(Payment payment);
	//public Optional<Orders> findPaymentById(int orderId);
	//public Optional<Payment> getByPaymentId(int paymentId);
	Payment findByPaymentId(String paymentId);
	Payment doPayment(String userId, String ambulanceType);
	public Payment findByTransactiontId(String transactionId);


}

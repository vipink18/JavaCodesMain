package com.capg.service;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Payment;
import com.capg.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment doPayment(String userId, String ambulanceType) {
        log.info("Processing payment for userId: {} and ambulanceType: {}", userId, ambulanceType);
        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setPaymentId(UUID.randomUUID().toString());
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentStatus(paymentProcessing());

        Random random = new Random();
        int min, max;
        if (ambulanceType.equals("General")) {
            min = 800;
            max = 1000;
        } else if (ambulanceType.equals("Cardiac")) {
            min = 1500;
            max = 2000;

        } else if (ambulanceType.equals("Express")) {
            min = 2500;
            max = 3000;
        } else if (ambulanceType.equals("Life_Support")) {
            min = 3500;
            max = 4000;
        } else {
            min = 1;
            max = 1;
        }
        int randomNumber1 = min + random.nextInt(max);
        payment.setAmount(randomNumber1);

        log.info("Payment details created and saved: {}", payment);
        return paymentRepository.save(payment);
    }

    @Override
    public String paymentProcessing() {
        String status = "Success";
        log.info("Payment processing status: {}", status);
        return status;
    }

    @Override
    public Payment addPayment(Payment payment) {
        log.info("Adding payment: {}", payment);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findByPaymentId(String paymentId) {
        log.info("Finding payment by paymentId: {}", paymentId);
        return paymentRepository.findByPaymentId(paymentId);
    }

    @Override
    public Payment findByTransactiontId(String transactionId) {
        log.info("Finding payment by transactionId: {}", transactionId);
        return paymentRepository.findByTransactionId(transactionId);
    }

}
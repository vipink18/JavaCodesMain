package com.capg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Payment;
import com.capg.service.PaymentService;
@RequestMapping("/api/v1/payment")
@RestController
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getByPaymentId/{paymentId}")
    public ResponseEntity<Payment> findByPaymentId(@PathVariable String paymentId) {
        log.info("Request received to find payment by paymentId: {}", paymentId);
        return new ResponseEntity<Payment>(paymentService.findByPaymentId(paymentId), HttpStatus.OK);
    }

    @GetMapping("/getByTransactionId/{transactionId}")
    public ResponseEntity<Payment> getByTransactionId(@PathVariable String transactionId) {
        log.info("Request received to find payment by transactionId: {}", transactionId);
        return new ResponseEntity<Payment>(paymentService.findByTransactiontId(transactionId), HttpStatus.OK);
    }

    @PostMapping("/doPayment/{userId}/{ambulanceType}")
    public Payment doPayment(@PathVariable String userId, @PathVariable String ambulanceType) {
        log.info("Request received to make payment for userId: {} and ambulanceType: {}", userId, ambulanceType);
        return paymentService.doPayment(userId, ambulanceType);
    }

}
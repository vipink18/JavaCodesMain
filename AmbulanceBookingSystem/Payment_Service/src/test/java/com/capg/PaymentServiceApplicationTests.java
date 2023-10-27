package com.capg;

import static org.mockito.Mockito.when;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capg.controller.PaymentController;
import com.capg.entity.Payment;
import com.capg.service.PaymentService;

@SpringBootTest
class PaymentServiceApplicationTests {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentController paymentController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByPaymentId() {
        String paymentId = UUID.randomUUID().toString();
        Payment payment = new Payment();
        payment.setPaymentId(paymentId);
        when(paymentService.findByPaymentId(paymentId)).thenReturn(payment);

        ResponseEntity<Payment> responseEntity = paymentController.findByPaymentId(paymentId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(payment, responseEntity.getBody());
    }

    @Test
    public void testGetByTransactionId() {
        String transactionId = UUID.randomUUID().toString();
        Payment payment = new Payment();
        payment.setTransactionId(transactionId);
        when(paymentService.findByTransactiontId(transactionId)).thenReturn(payment);

        ResponseEntity<Payment> responseEntity = paymentController.getByTransactionId(transactionId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(payment, responseEntity.getBody());
    }

    @Test
    public void testDoPayment() {
        String userId = "user123";
        String ambulanceType = "General";
        Payment payment = new Payment();
        when(paymentService.doPayment(userId, ambulanceType)).thenReturn(payment);

        Payment result = paymentController.doPayment(userId, ambulanceType);

        assertNotNull(result);
        assertEquals(payment, result);
    }

}
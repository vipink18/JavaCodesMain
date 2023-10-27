package com.capg.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Booking_table")
public class Booking {

	
    @Id
    @NotBlank(message = "Booking ID is required")
    private String bookingId;
    
    @NotBlank(message = "User ID is required")
    private String userId;
    
    @NotBlank(message = "Hospital ID is required")
    private String hospitalId;
    
    @NotBlank(message = "Ambulance ID is required")
    private String ambulanceId;
    
    @NotBlank(message = "Transaction ID is required")
    private String transactionId;
    
    @NotNull(message = "Booking Time is required")
    private LocalDateTime bookingTime;
}
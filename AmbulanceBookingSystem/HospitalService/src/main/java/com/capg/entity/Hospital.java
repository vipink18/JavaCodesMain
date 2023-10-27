package com.capg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital")
public class Hospital {
    
    @Id
    @NotBlank(message = "Hospital ID is required")
    private String hospitalId;
    
    @NotBlank(message = "Hospital Name is required")
    private String hospitalName;
    
    @NotBlank(message = "Hospital Contact Number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Hospital Contact Number should be a 10-digit number")
    private String hospitalContactNumber;
    
    @NotBlank(message = "Hospital Address is required")
    private String hospitalAddress;
    
    @NotBlank(message = "Hospital Location is required")
    private String hospitalLocation;
    
    @NotBlank(message = "Hospital Email ID is required")
    @Email(message = "Hospital Email ID should be a valid email address")
    private String hospitalEmailId;
    
    @NotBlank(message = "Hospital Password is required")
    @Size(min = 8, message = "Hospital Password should have at least 8 characters")
    private String hospitalPassword;    
    
}
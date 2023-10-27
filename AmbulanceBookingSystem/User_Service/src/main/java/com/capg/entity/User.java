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

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Entity
@Table(name = "UserTable")
public class User {
    @Id
    @NotBlank(message = "User Id is required")
    private String userId;
    
    @NotBlank(message = "User Name is required")
    private String userName;
    
    @NotBlank(message = "User Contact Number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "User Contact Number should be a 10-digit number")
    private String userContactNumber;
    
    @NotBlank(message = "User Email ID is required")
    @Email(message = "User Email ID should be a valid email address")
    private String userEmailId;
    
    @NotBlank(message = "User Location is required")
    private String userLocation;
    
    @NotBlank(message = "User Password is required")
    @Size(min = 8, message = "User Password should have at least 8 characters")
    private String userPassword;
    
}
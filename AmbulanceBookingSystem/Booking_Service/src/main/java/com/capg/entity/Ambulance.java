package com.capg.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Ambulance {
    private String ambDriverName;
    private String ambDriverEmailId;
    private String ambDriverContactNumber;
    private String ambDriverLocation;
    //private String ambStatus;
    private String ambType; 
    
}

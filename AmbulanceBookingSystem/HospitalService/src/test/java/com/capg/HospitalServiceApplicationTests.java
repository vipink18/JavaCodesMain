package com.capg;

import static org.mockito.Mockito.when;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.entity.Hospital;
import com.capg.exception.IdNotFoundException;
import com.capg.repository.HospitalRepository;
import com.capg.service.HospitalService;

@SpringBootTest
class HospitalServiceApplicationTests {

    @MockBean
    private HospitalRepository hospitalRepository;
    
    
    
    @Autowired
    private HospitalService hospitalService;

    
    @Test
    public void testSaveHospital() {
        Hospital hospital = new Hospital();
        hospital.setHospitalName("Test Hospital");
        hospital.setHospitalLocation("Test Location");
        hospital.setHospitalEmailId("test@example.com");

        when(hospitalRepository.save(hospital)).thenReturn(hospital);

        Hospital savedHospital = hospitalService.addHospital(hospital);

        assertNotNull(savedHospital.getHospitalId());
        assertEquals("Test Hospital", savedHospital.getHospitalName());
        assertEquals("Test Location", savedHospital.getHospitalLocation());
        assertEquals("test@example.com", savedHospital.getHospitalEmailId());
    }


    @Test
    public void testFindHospitalByIdValidId() {
        Hospital hospital = new Hospital();
        hospital.setHospitalId("testId");
        hospital.setHospitalName("Test Hospital");

        when(hospitalRepository.findById("testId")).thenReturn(Optional.of(hospital));

        Hospital foundHospital = hospitalService.findHospitalById("testId");

        assertNotNull(foundHospital);
        assertEquals("Test Hospital", foundHospital.getHospitalName());
    }

    @Test
    public void testFindHospitalByIdInvalidId() {
        when(hospitalRepository.findById("invalidId")).thenReturn(Optional.empty());

        assertThrows(IdNotFoundException.class, () -> hospitalService.findHospitalById("invalidId"));
    }
}
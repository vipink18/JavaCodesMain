//package com.capg.serviceTestCases;
//
// 
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
// 
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
// 
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
// 
//
//import com.capg.entity.Ambulance;
//import com.capg.repository.AmbulanceRepository;
//import com.capg.service.AmbulanceService;
//
// 
//
//@SpringBootTest
//public class AmbulanceServiceTest {
//
// 
//
//    @Autowired
//    AmbulanceService ambulanceService;
//
// 
//
//    @MockBean
//    AmbulanceRepository ambulanceRepository;
//
// 
//
//    private Ambulance ambulance1;
//
// 
//
//    private Ambulance ambulance2;
//
// 
//
//    @BeforeEach
//    public void ambulanceServiceTestSetup() {
//        ambulance1 = new Ambulance("1234", "Kshitiz", "Kshitiz@gmail.com", "8989898989", "Password@123", "Indore","Available",
//                "General");
//        ambulance2 = new Ambulance("12345", "Kshitiz", "Kshitiz@gmail.com", "8989898989", "Password@123", "Dehradun","Unavailable", "Cadiac");
//    }
//
// 
//
//    @Test
//    public void ambDriverRegisterTest() {
//        Mockito.when(ambulanceRepository.save(ambulance1)).thenReturn(ambulance1);
//
// 
//
//        assertThat(ambulanceService.ambDriverRegister(ambulance1)).isEqualTo(ambulance1);
//    }
//
// 
//
//    @Test
//    public void updateAmbualanceTest() {
//        Mockito.when(ambulanceRepository.save(ambulance1)).thenReturn(ambulance1);
//
// 
//
//        Mockito.when(ambulanceRepository.findById("1234")).thenReturn(Optional.of(ambulance1));
//
// 
//
//        ambulance1.setAmbDriverName("Kshitiz");
//
// 
//
//       // Ambulance result = ambulanceService.updateAmbulanceDriverById(ambulance1);
//
//// 
////
////        assertEquals("Kshitiz", result.getAmbDriverName());
////        assertEquals("Kshitiz@gmail.com", result.getAmbDriverEmailId());
////        assertEquals("8989898989", result.getAmbDriverContactNumber());
////        assertEquals("Password@123", result.getAmbDriverPassword());
//    }
//
// 
//
//    @Test
//    public void deleteAmbulanceByIdTest() {
//        Mockito.when(ambulanceRepository.findById("1234")).thenReturn(Optional.of(ambulance1));
//
// 
//
//        Mockito.doNothing().when(ambulanceRepository).deleteById("1234");
//
// 
//
//        ambulanceService.deleteAmbulanceDriver("1234");
//
// 
//
//        verify(ambulanceRepository, times(1)).deleteById("1234");
//
// 
//
//    }
//
// 
//
//    @Test
//    public void getAmbulanceByIdTest() {
//
// 
//
//        Mockito.when(ambulanceRepository.findById("1234")).thenReturn(Optional.of(ambulance1));
//
// 
//
//        assertThat(ambulanceService.getAmbulanceById("1234")).isEqualTo(Optional.of(ambulance1));
//    }
//
// 
//
//    @Test
//    public void getAllAmbulancesTest() {
//        List<Ambulance> ambulances = new ArrayList<>();
//
// 
//
//        ambulances.add(ambulance1);
//        ambulances.add(ambulance2);
//
// 
//
//        Mockito.when(ambulanceRepository.findAll()).thenReturn(ambulances);
//
// 
//
//        assertThat(ambulanceService.getAllAmbulances()).isEqualTo(ambulances);
//    }
//
// 
//
//}
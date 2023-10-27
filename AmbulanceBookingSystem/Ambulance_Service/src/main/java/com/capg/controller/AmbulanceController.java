package com.capg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Ambulance;
import com.capg.exrternalServices.AmbulanceBookingDetails;
import com.capg.service.AmbulanceService;
import com.capg.util.AmbulanceLogin;
import com.capg.util.Hospital;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api/v1/ambulance")
@CrossOrigin(origins = "http://localhost:4200")
public class AmbulanceController {

private static final Logger log = LoggerFactory.getLogger(AmbulanceController.class);
    
    @Autowired
    private AmbulanceService ambulanceService;

    // register an ambulance driver
    @PostMapping("/addAmbulance")
    public ResponseEntity<Ambulance> addDriver(@RequestBody Ambulance driver) {
        log.info("Adding new ambulance driver");
        return new ResponseEntity<Ambulance>(ambulanceService.ambDriverRegister(driver), HttpStatus.OK);
    }

    // update ambulance driver details
    @PutMapping("/updateDriver/{ambulanceId}")
    public ResponseEntity<Ambulance> updateDriver(@PathVariable String ambulanceId,
            @RequestBody Map<String, String> update) {
        log.info("Updating ambulance driver with ID: {}", ambulanceId);
        Ambulance fetchUpdatedDriver = ambulanceService.updateAmbulanceDriverById(ambulanceId, update);
        return new ResponseEntity<Ambulance>(fetchUpdatedDriver, HttpStatus.OK);
    }

    // change password
    @PutMapping("/changePassword/{driverEmailId}/{currentPassword}/{newPassword}")
    public ResponseEntity<Ambulance> updatePassword(@PathVariable String driverEmailId,
            @PathVariable String currentPassword, @PathVariable String newPassword) {
        log.info("Changing password for ambulance driver with email: {}", driverEmailId);
        return new ResponseEntity<Ambulance>(
                ambulanceService.changePassword(driverEmailId, currentPassword, newPassword), HttpStatus.OK);
    }

    // delete an existing ambulance driver
    @DeleteMapping("/deleteDriver/{driverId}")
    public void deleteDriverById(@PathVariable String driverId) {
        log.info("Deleting ambulance driver with ID: {}", driverId);
        ambulanceService.deleteAmbulanceDriver(driverId);
    }

    // find ambulance by ambulanceId
    @GetMapping("/findAmbulanceById/{ambulanceId}")
    public ResponseEntity<Ambulance> findAmbulanceById(@PathVariable String ambulanceId) {
        log.info("Fetching ambulance driver with ID: {}", ambulanceId);
        return new ResponseEntity<Ambulance>(ambulanceService.getAmbulanceById(ambulanceId), HttpStatus.OK);
    }

    // fetch all ambulances
    @GetMapping("/getAllAmbulances")
    public ResponseEntity<List<Ambulance>> getAllAmbulances() {
        log.info("Fetching all ambulance drivers");
        return new ResponseEntity<List<Ambulance>>(ambulanceService.getAllAmbulances(), HttpStatus.OK);
    }

    // fetch all ambulances by location
    @GetMapping("/getAllAmbulanceByLocation/{ambulanceLocation}")
    public ResponseEntity<List<Ambulance>> getAllAmbulanceByLocation(@PathVariable String ambulanceLocation) {
        log.info("Fetching ambulance drivers by location: {}", ambulanceLocation);
        return new ResponseEntity<List<Ambulance>>(ambulanceService.getAllAmbulanceByLocation(ambulanceLocation),
                HttpStatus.OK);
    }

    // fetch all hospitals by location
    @GetMapping("/getHospitalByHospitalLocation/{hospitalLocation}")
    public ResponseEntity<List<Hospital>> viewNearbyHospitals(@PathVariable String hospitalLocation) {
        log.info("Fetching nearby hospitals for location: {}", hospitalLocation);
        return new ResponseEntity<List<Hospital>>(ambulanceService.viewNearbyHospitals(hospitalLocation),
                HttpStatus.OK);
    }

    // view previous driver bookings
    @GetMapping("/ambulanceBookingHistory/{ambulanceId}")
    public ResponseEntity<List<AmbulanceBookingDetails>> AmbulanceBookingHistory(@PathVariable String ambulanceId) {
        log.info("Fetching booking history for ambulance with ID: {}", ambulanceId);
        return new ResponseEntity<List<AmbulanceBookingDetails>>(ambulanceService.AmbulanceBookingHistory(ambulanceId),
                HttpStatus.OK);
    }

    // ambulance login api
    @PostMapping("/ambulanceLogin")
    public ResponseEntity<Ambulance> ambulanceLogin(@RequestBody AmbulanceLogin ambulanceLogin) {
        log.info("Ambulance driver login for email: {}", ambulanceLogin.getEmailId());
        return new ResponseEntity<Ambulance>(ambulanceService.ambulanceLogin(ambulanceLogin), HttpStatus.OK);
    }
}
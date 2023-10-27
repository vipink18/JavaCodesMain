package com.capg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Hospital;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.InvalidPasswordException;
import com.capg.externalServices.HospitalBookingDetails;
import com.capg.feignClient.BookingServiceFeign;
import com.capg.repository.HospitalRepository;
import com.capg.util.HospitalLogin;
 
@Service
public class HospitalServiceImpl implements HospitalService{
    
	private static final Logger log = LoggerFactory.getLogger(HospitalServiceImpl.class);
	
    @Autowired
    public HospitalRepository hospitalRepository;
    
    @Autowired
    public BookingServiceFeign bookingServiceFeign;

    @Override
    public Hospital addHospital(Hospital hospital) {
        String idString = UUID.randomUUID().toString();
        hospital.setHospitalId(idString);
        return hospitalRepository.save(hospital);
    }

    @Override
    public Hospital findHospitalById(String hospitalId) {       
        return hospitalRepository.findById(hospitalId).orElseThrow(() -> new IdNotFoundException("Invalid Id"));
    }

    @Override
    public List<Hospital> getAllHospitalInfo() {
    	log.info("Fetching all hospital information");
    	List<Hospital> hospitalList = hospitalRepository.findAll();
        return hospitalList;
    }

    @Override
    public void deleteHospitalById(String hospitalId) {
    	log.info("Deleting hospital with id: {}", hospitalId);
    	Optional<Hospital> id = hospitalRepository.findById(hospitalId);
        if(id.isPresent()) {
            hospitalRepository.deleteById(hospitalId);
        }
        else {
            throw new IdNotFoundException("Hospital with given id not found!");
        }
    }

    @Override
    public List<Hospital> getHospitalByHospitalLocation(String hospitalLocation) {      
    	log.info("Fetching hospitals by location: {}", hospitalLocation);
    	return hospitalRepository.findByHospitalLocation(hospitalLocation);
    }

    @Override
    public Hospital getHospitalById(String hospitalId) {
    	log.info("Fetching hospital by id: {}", hospitalId);
        return hospitalRepository.findById(hospitalId).orElseThrow(() -> new IdNotFoundException("Invalid Id"));        
    }
    
    @Override
    public List<String> getAllHospitalLocations(){
    	log.info("Fetching all hospital locations");
        List<Hospital> hospitals = hospitalRepository.findAll();
        List<String> locations = hospitals.stream().map(p->p.getHospitalLocation()).collect(Collectors.toList());
        return locations.stream().distinct().collect(Collectors.toList());
    }
    
    @Override
    public List<String> getAllHospitalIds(){
    	log.info("Fetching all hospital IDs");
        List<Hospital> hospitalObj = hospitalRepository.findAll();
        return hospitalObj.stream().map(p-> p.getHospitalId()).collect(Collectors.toList());    
    }

    public Hospital hospitalLogin(HospitalLogin hospitalLogin) {
    	log.info("Hospital login for email: {}", hospitalLogin.getEmailId());
    	return hospitalRepository.findByHospitalEmailIdAndHospitalPassword(hospitalLogin.getEmailId(), hospitalLogin.getPassword());
	}

    @Override
    public Optional<Hospital> getHospitalByEmailId(String hospitalEmailId) {
    	log.info("Fetching hospital by email: {}", hospitalEmailId);
    	return hospitalRepository.getHospitalByHospitalEmailId(hospitalEmailId);
    }

    @Override
    public Hospital changePassword(String hospitalEmailId, String currentPassword, String newPassword) {
    	log.info("Changing password for hospital with email: {}", hospitalEmailId);
    	Optional<Hospital> hospitalObj = getHospitalByEmailId(hospitalEmailId);
        if(hospitalObj.get().getHospitalPassword().equals(currentPassword)) {
            if(Objects.nonNull(hospitalObj.get().getHospitalPassword()) && !"".equalsIgnoreCase(hospitalObj.get().getHospitalPassword())) {
                hospitalObj.get().setHospitalPassword(newPassword);
                hospitalRepository.save(hospitalObj.get());                
            }
        }
        else {
            throw new InvalidPasswordException("Wrong current password.");
        }
        return hospitalObj.get();
    }

	@Override
	public List<HospitalBookingDetails> getAllHospitalBooking(String hospitalId) {
		log.info("Fetching booking history for hospital with ID: {}", hospitalId);
		return bookingServiceFeign.getAllHospitalBooking(hospitalId);
	}

	@Override
    public Hospital updateHospitalById(String hospitalId, Map<String, String> update) {
        Optional<Hospital> hospitalDb = hospitalRepository.findById(hospitalId);
        if (hospitalDb.isPresent()) {
            if (update.containsKey("hospitalName")) {
                hospitalDb.get().setHospitalName(update.get("hospitalName"));
            }
            if (update.containsKey("hospitalContactNumber")) {
                hospitalDb.get().setHospitalContactNumber(update.get("hospitalContactNumber"));
            }
            if (update.containsKey("hospitalAddress")) {
                hospitalDb.get().setHospitalAddress(update.get("hospitalAddress"));
            }
            if (update.containsKey("hospitalLocation")) {
                hospitalDb.get().setHospitalLocation(update.get("hospitalLocation"));
            }
        } else {
            throw new IdNotFoundException("No Hospital found!");
        }

        return hospitalRepository.save(hospitalDb.get());
    }
}
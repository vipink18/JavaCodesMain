package com.capg.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Ambulance;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.InvalidPasswordException;
import com.capg.exrternalServices.AmbulanceBookingDetails;
import com.capg.feignClient.BookingServiceFeign;
import com.capg.feignClient.HospitalServiceFeign;
import com.capg.repository.AmbulanceRepository;
import com.capg.util.AmbulanceLogin;
import com.capg.util.Hospital;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class AmbulanceServiceImpl implements AmbulanceService {

private static final Logger log = LoggerFactory.getLogger(AmbulanceServiceImpl.class);
    
    @Autowired
    private AmbulanceRepository ambulanceRepository;

    @Autowired
    private BookingServiceFeign bookingServiceFeign;
    
    @Autowired
    private HospitalServiceFeign hospitalServiceFeign;

    /*
     * @Author : Kshitiz Zamindar
     * 
     * @Description : This method is used to add an ambulance driver in the database
     * 
     * @Param : It takes ambulance driver as a parameter
     * 
     * @Return : It returns the saved ambulance driver object
     * 
     * @Date Created : 3 August 2023
     */
    @Override
    public Ambulance ambDriverRegister(Ambulance driver) {
        log.info("Registering a new ambulance driver");
        String idString = UUID.randomUUID().toString();
        driver.setAmbulanceId(idString);
        return ambulanceRepository.save(driver);
    }

    /*
     * @Author : Kshitiz Zamindar
     * 
     * @Description : This method is used to update ambulance driver in the database
     * 
     * @Param : It takes ambulance driver as a parameter
     * 
     * @Return : It returns the updated ambulance driver object
     * 
     * @Date Created : 3 August 2023
     */
    @Override
    public Ambulance updateAmbulanceDriverById(String ambulanceId, Map<String, String> update) {
        log.info("Updating ambulance driver with ID: {}", ambulanceId);
        Optional<Ambulance> ambDb = ambulanceRepository.findById(ambulanceId);
        if (ambDb.isPresent()) {
            if (update.containsKey("ambDriverName")) {
                ambDb.get().setAmbDriverName(update.get("ambDriverName"));
            }
            if (update.containsKey("ambDriverContactNumber")) {
                ambDb.get().setAmbDriverContactNumber(update.get("ambDriverContactNumber"));
            }
            if (update.containsKey("ambDriverLocation")) {
                ambDb.get().setAmbDriverLocation(update.get("ambDriverLocation"));
            }
            if (update.containsKey("ambStatus")) {
                ambDb.get().setAmbStatus(update.get("ambStatus"));
            }
            if (update.containsKey("ambType")) {
                ambDb.get().setAmbType(update.get("ambType"));
            }
        } else {
            throw new IdNotFoundException("No Ambulance Driver found!");
        }

        return ambulanceRepository.save(ambDb.get());
    }

    /*
     * @Author : Kshitiz Zamindar
     * 
     * @Description : This method is used to change password in the database
     * 
     * @Param : It takes driverId and newPassword as a parameter
     * 
     * @Return : It returns the saved ambulance driver object
     * 
     * @Date Created : 3 August 2023
     */
    @Override
    public Ambulance changePassword(String driverEmailId, String currentPassword, String newPassword) {
        log.info("Changing password for ambulance driver with email: {}", driverEmailId);
        Ambulance amb = getAmbulanceByEmailId(driverEmailId);
        if (amb.getAmbDriverPassword().equals(currentPassword)) {
            if (Objects.nonNull(amb.getAmbDriverPassword()) && !"".equalsIgnoreCase(amb.getAmbDriverPassword())) {
                amb.setAmbDriverPassword(newPassword);
                ambulanceRepository.save(amb);
            }
        } else {
            throw new InvalidPasswordException("Wrong current password.");
        }
        return amb;

    }

    /*
     * @Author : Kshitiz Zamindar
     * 
     * @Description : This method is used to delete an ambulance driver from the
     * database
     * 
     * @Param : It takes ambulance driverId as a parameter
     * 
     * @Return : It returns nothing
     * 
     * @Date Created : 3 August 2023
     */
    @Override
    public void deleteAmbulanceDriver(String driverId) {
        log.info("Deleting ambulance driver with ID: {}", driverId);
        Optional<Ambulance> id = ambulanceRepository.findById(driverId);
        if (id.isPresent()) {
            ambulanceRepository.deleteById(driverId);
        } else {
            throw new IdNotFoundException(driverId);
        }
    }

    /*
     * @Author : Kshitiz Zamindar
     * 
     * @Description : This method is used to get ambulance objects by id
     * 
     * @Param : It takes ambulance driverId as a parameter
     * 
     * @Return : It returns the ambulance driver object of the given id
     * 
     * @Date Created : 3 August 2023
     */
    @Override
    public Ambulance getAmbulanceById(String ambulanceId) {
        log.info("Fetching ambulance driver with ID: {}", ambulanceId);
        Optional<Ambulance> getId = ambulanceRepository.findById(ambulanceId);
        if (getId.isPresent()) {
            return ambulanceRepository.findByAmbulanceId(ambulanceId);
        } else {
            throw new IdNotFoundException("No driver with the given id found!");
        }
    }

    @Override
    public Ambulance getAmbulanceByEmailId(String driverEmailId) {
        log.info("Fetching ambulance driver with email: {}", driverEmailId);
        return ambulanceRepository.findByAmbDriverEmailId(driverEmailId);
    }

    @Override
    public List<Ambulance> getAllAmbulances() {
        log.info("Fetching all ambulance drivers");
        List<Ambulance> ambList = ambulanceRepository.findAll();
        return ambList;
    }

    @Override
    public List<Ambulance> getAllAmbulanceByLocation(String ambulanceLocation) {
        log.info("Fetching ambulance drivers by location: {}", ambulanceLocation);
        return ambulanceRepository.findByambDriverLocation(ambulanceLocation);
    }

    @Override
    public Ambulance ambulanceLogin(AmbulanceLogin ambulanceLogin) {
        log.info("Ambulance driver login for email: {}", ambulanceLogin.getEmailId());
        return ambulanceRepository.findByAmbDriverEmailIdAndAmbDriverPassword(ambulanceLogin.getEmailId(),
                ambulanceLogin.getPassword());
    }

    @Override
    public List<AmbulanceBookingDetails> AmbulanceBookingHistory(String ambulanceId) {
        log.info("Fetching booking history for ambulance with ID: {}", ambulanceId);
        return bookingServiceFeign.getAllAmbulanceBooking(ambulanceId);
    }

    @Override
    public List<Hospital> viewNearbyHospitals(String hospitalLocation) {
        log.info("Fetching nearby hospitals for location: {}", hospitalLocation);
        return hospitalServiceFeign.getHospitalByHospitalLocation(hospitalLocation);
    }

}
package com.capg.service;

import java.util.List;
import java.util.Map;

import com.capg.entity.Ambulance;
import com.capg.exrternalServices.AmbulanceBookingDetails;
import com.capg.util.AmbulanceLogin;
import com.capg.util.Hospital;

public interface AmbulanceService {

	public Ambulance ambDriverRegister(Ambulance driver);

	public Ambulance updateAmbulanceDriverById(String ambulanceId, Map<String, String> update);

	public Ambulance changePassword(String driverEmailId, String currentPassword, String newPassword);

	public void deleteAmbulanceDriver(String driverId);

	public Ambulance getAmbulanceById(String ambulanceId);

	public Ambulance getAmbulanceByEmailId(String driverEmailId);

	public List<Ambulance> getAllAmbulances();

	public List<Ambulance> getAllAmbulanceByLocation(String ambulanceLocation);

	public Ambulance ambulanceLogin(AmbulanceLogin ambulanceLogin);

	public List<AmbulanceBookingDetails> AmbulanceBookingHistory(String ambulanceId);

	public List<Hospital> viewNearbyHospitals(String hospitalLocation);

}

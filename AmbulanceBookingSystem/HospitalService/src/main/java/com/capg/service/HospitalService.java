package com.capg.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.capg.entity.Hospital;
import com.capg.externalServices.HospitalBookingDetails;
import com.capg.util.HospitalLogin;

public interface HospitalService {

    public Hospital addHospital(Hospital hospital);

    public Hospital findHospitalById(String hospitalId);

    public List<Hospital> getAllHospitalInfo();

    public Hospital getHospitalById(String hospitalId);

    public void deleteHospitalById(String hospitalId);

    public List<Hospital> getHospitalByHospitalLocation(String hospitalLocation);

    public List<String> getAllHospitalLocations();

    public List<String> getAllHospitalIds();

    public Optional<Hospital> getHospitalByEmailId(String hospitalEmailId);

    public Hospital changePassword(String hospitalEmailId, String currentPassword, String newPassword);

    public Hospital hospitalLogin(HospitalLogin hospitalLogin);

    public List<HospitalBookingDetails> getAllHospitalBooking(String hospitalId);

    public Hospital updateHospitalById(String hospitalId, Map<String, String> update);

}
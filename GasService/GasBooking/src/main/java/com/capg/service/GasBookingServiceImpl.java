package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entities.GasBooking;
import com.capg.exception.IdNotFoundException;
import com.capg.repository.GasBookingRepository;

@Service
public class GasBookingServiceImpl implements GasBookingService{

	@Autowired
	private GasBookingRepository gasBookingRepository;
	
	
	@Override
	public GasBooking insertGasBooking(GasBooking gasBooking) {
		return gasBookingRepository.save(gasBooking);
	}

	@Override
	public GasBooking updateGasBooking(GasBooking gasBooking) {

		Optional<GasBooking> existingBooking = gasBookingRepository.findById(gasBooking.getCustomerId()); 
		if(existingBooking.isPresent()) {
			return gasBookingRepository.save(gasBooking);
		}
		else
			throw new IdNotFoundException("invalid id: "+ gasBooking.getGasBookingId());
		
	}

	@Override
	public String deleteGasBooking(int gasBookingId) {
		Optional<GasBooking> existingBooking = gasBookingRepository.findById(gasBookingId); 
		if(existingBooking.isPresent()) {
			gasBookingRepository.deleteById(gasBookingId);
			return "Deleted id: "+gasBookingId;
		}
		else
			throw new IdNotFoundException("Invalid Id: "+gasBookingId);
	}

	@Override
	public List<GasBooking> viewGasBooking() {
		return gasBookingRepository.findAll();
	}

//	@Override
//	public GasBooking getBill(int gasBookingId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

}

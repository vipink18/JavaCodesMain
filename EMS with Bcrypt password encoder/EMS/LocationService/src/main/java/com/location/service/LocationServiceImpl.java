package com.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.exceptions.LocationException;
import com.location.model.Location;
import com.location.repository.LocationRepository;
@Service
public class LocationServiceImpl implements LocationService {

	
	@Autowired
	LocationRepository lRepository;
	@Override
	public Location addLocation(Location l) {
		// TODO Auto-generated method stub
		return lRepository.save(l);
	}

	@Override
	public Location getLocationById(int id) throws LocationException {
		// TODO Auto-generated method stub
		Location location = lRepository.findById(id).get();
		if(location == null) {
			throw new LocationException("sorry");
			
		}
		return location;
	}

	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		List<Location> ssList =lRepository.findAll();
		return ssList;
	}

}

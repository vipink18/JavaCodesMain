package com.location.service;

import java.util.List;

import com.location.exceptions.LocationException;
import com.location.model.Location;

public interface LocationService {
	
	Location addLocation(Location l);
	Location getLocationById(int id) throws LocationException;
	List<Location> getAllLocations();

}

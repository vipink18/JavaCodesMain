package com.capg.service;

import java.util.Map;
import java.util.UUID;

import com.capg.entities.Address;

public interface AddressService {

	public Address addAddress(Address address);
	
	public Address getAddressById(UUID addressUuid);	
	
	public Address updateAddress(UUID addressUuid, Map<String, String> update);
	
	public String deleteAddress(UUID addressUuid);
	
}

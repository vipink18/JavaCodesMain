package com.capg.service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.entities.Address;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.InvalidPincodeException;
import com.capg.repository.AddressRepository;

public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address getAddressById(UUID addressUuid) {
		Optional<Address> address = addressRepository.findById(addressUuid);
		if (address.isPresent()) {
            return addressRepository.findByAddressUuid(addressUuid);
        } else {
            throw new IdNotFoundException("Id Not found");
        }
	}

	@Override
	public Address updateAddress(UUID addressUuid, Map<String, String> update) {
		Optional<Address> address = addressRepository.findById(addressUuid);
		if (address.isPresent()) 
		{
			Address existingAddress = addressRepository.findByAddressUuid(addressUuid);

            // Update the fields based on the provided Map
            String updatedArea = update.get("area");
            String updatedHouseNo = update.get("houseNo");
            String updatedPincode = update.get("pincode");

            if (updatedArea != null) {
                existingAddress.setArea(updatedArea);
            }
            if (updatedHouseNo != null) {
                existingAddress.setHouseNo(updatedHouseNo);
            }
            if (updatedPincode != null) {
                try {
                    int updatedPincodeValue = Integer.parseInt(updatedPincode);
                    existingAddress.setPincode(updatedPincodeValue);
                } catch (NumberFormatException e) {
                   throw new InvalidPincodeException("Invalid pincode value: "+ updatedPincode);
                	
                }
            }
        
        
            // Save the updated Address object
            addressRepository.save(existingAddress);

            return existingAddress;
        }
		throw new IdNotFoundException("Invalid Id");

        
    }
		


	@Override
	public String deleteAddress(UUID addressUuid) {
		return null;
	}

}

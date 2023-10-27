package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Advertisement;
import com.example.demo.exception.AdvertisementNotFoundException;

public interface IAdvertisementService {
	Advertisement addAdvertisement(Advertisement advt);
	Advertisement updateAdvertisement(int id,Advertisement advt) throws AdvertisementNotFoundException;
	void deleteAdvertisement(int id) throws AdvertisementNotFoundException; 
	List<Advertisement> getAllAdvertisement();
}
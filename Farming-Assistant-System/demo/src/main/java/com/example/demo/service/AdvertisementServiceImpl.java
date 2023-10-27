package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Advertisement;
import com.example.demo.exception.AdvertisementNotFoundException;
import com.example.demo.repository.IAdvertisementRepository;

public class AdvertisementServiceImpl implements IAdvertisementService {

		@Autowired
		IAdvertisementRepository advtRepo;
		
		@Override
		public Advertisement addAdvertisement(Advertisement advt) {
			return advtRepo.save(advt);
		}

		@Override
		public Advertisement updateAdvertisement(int id, Advertisement advt)throws AdvertisementNotFoundException {
			Optional<Advertisement> advtOpt = advtRepo.findById(id);
			if (advtOpt.isPresent()) {
				
			    return advtRepo.save(advt);
			} else {
				throw new AdvertisementNotFoundException("Advertisement not found with given id: " + id);
			}
		}

		@Override
		public void deleteAdvertisement(int id)throws AdvertisementNotFoundException {
			Optional<Advertisement> advtOpt = advtRepo.findById(id);
			if (advtOpt.isPresent()) {
				advtRepo.deleteById(id);
			} else {
				throw new AdvertisementNotFoundException("Advertisement not found with given id: " + id);
			}

		}

		@Override
		public List<Advertisement> getAllAdvertisement() {
			List<Advertisement> advertisements = advtRepo.findAll();
			return advertisements;
		}

	}



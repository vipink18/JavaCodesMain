package com.example.demo.service;
//import org.springframework.data.repository.query.Param;

import java.util.List;

import com.example.demo.entity.Crop;

public interface ICropService {


	Crop addCrop(Crop C1);
	Crop updateCrop(int cropId,Crop C1);
	void deleteCrop(int cropId);
	List<Crop> getAllCrop();
}

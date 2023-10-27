package com.example.demo.repository;



	import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Advertisement;

	public interface IAdvertisementRepository extends JpaRepository<Advertisement,Integer>{

	}



package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Advertisement;
import com.example.demo.entity.Supplier;
import com.example.demo.exception.SupplierNotFoundException;
import com.example.demo.service.IAdvertisementService;
import com.example.demo.service.SupplierServiceImpl;
@RestController
public class SupplierController {
	
	@Autowired
	SupplierServiceImpl suppService;
	
	

	@GetMapping("/test")
	ResponseEntity<List<Supplier>> getAllSupplier() {
		List<Supplier> suppliers= suppService.getAllSupplier();
		return new ResponseEntity<>(suppliers, HttpStatus.OK); // 200 ok
	}
	
	@PostMapping("/S1/add")
	ResponseEntity<Supplier> addSupplier(@RequestBody Supplier S1) {
		Supplier newsupp = suppService.addSupplier(S1);
		return new ResponseEntity<>(newsupp, HttpStatus.CREATED); // 201 created 
	}
	
	@DeleteMapping("/S1/delete/{supplierId}")
	ResponseEntity<Supplier> deleteSupplier(@PathVariable("supplierId") int supplierId) throws SupplierNotFoundException{
		Supplier S1 = suppService.deleteSupplier(supplierId);
		return new ResponseEntity<>(S1, HttpStatus.OK); //200 ok
	}
	
	@Autowired 
	IAdvertisementService advService;
	

	@GetMapping("/test")
	ResponseEntity<List<Advertisement>> getAllAdvertisement() {
		List<Advertisement> advertisements= advService.getAllAdvertisement();
		return new ResponseEntity<>(advertisements, HttpStatus.OK); // 200 ok
	}
	
	@PostMapping("/adv/add")
	ResponseEntity<Advertisement> addAdvertisement(@RequestBody Advertisement advt) {
		Advertisement newAdvt = advService.addAdvertisement(advt);
		return new ResponseEntity<>(newAdvt, HttpStatus.CREATED); // 201 created 
	}
	

}

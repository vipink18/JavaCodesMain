/*@Author Vipin Dane

This is Controller layer for ProductWebsite module 
In this class client request is mapped  to the method and sends back the response to the client 

In this controller all the request related to ProductWebsite are handled

*/

package com.sastabasta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sastabasta.entities.Product;
import com.sastabasta.entities.ProductWebsite;
import com.sastabasta.inputdto.ProductWebsiteInputDto;
import com.sastabasta.service.ProductService;
import com.sastabasta.service.ProductWebsiteService;

@RestController
@RequestMapping("productWebsite")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductWebsiteController {
	@Autowired
	ProductWebsiteService productWebsiteService;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/addProductWebsite")
	public ResponseEntity<ProductWebsite> addCustomer(@RequestBody ProductWebsiteInputDto productWebsiteInputDto)  {

		return new ResponseEntity<ProductWebsite>(productWebsiteService.addProductWebsite(productWebsiteInputDto) , HttpStatus.OK);
	}
	
	@PutMapping("/editProductWebsite/{productId}")
	public ResponseEntity<Product> editProductWebsite(@RequestBody ProductWebsite productWebsite,@PathVariable int productId) {
		return new ResponseEntity<Product>(productWebsiteService.editProduct(productWebsite,productId) , HttpStatus.OK);
	}
	
	@DeleteMapping("deleteById/{id}")
	public void deleteProductWebsiteById(@PathVariable int id){
		productWebsiteService.deleteProductWebsiteById(id);
	}
	
	@GetMapping("/getProductWebite/{webId}")
	public ResponseEntity<Optional<ProductWebsite>> getByCustId(@PathVariable int webId) {
		return new ResponseEntity<Optional<ProductWebsite>>(productWebsiteService.findProductWebsiteById(webId) ,HttpStatus.FOUND);
	}
	

	
	@GetMapping("getAll")
	public ResponseEntity<List<ProductWebsite>> getAllProductWebsite(){
		return new ResponseEntity<List<ProductWebsite>>(productWebsiteService.findAllProduct(),HttpStatus.OK);
		
	}
	
	
	

}

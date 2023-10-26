/*@Author Ashutosh Tripathi

This is Controller layer for Wishlist module 
In this class client request is mapped  to the method and sends back the response to the client 

In this controller all the request related to Wishlist are handled.

*/

package com.sastabasta.controller;

import java.util.List;
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


import com.sastabasta.entities.Customer;
import com.sastabasta.entities.Product;
import com.sastabasta.entities.Wishlist;

import com.sastabasta.service.CustomerService;
import com.sastabasta.service.ProductService;
import com.sastabasta.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "http://localhost:3000")
public class WishlistController {
	@Autowired
	WishlistService wishlistService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/addWishlist")
	public ResponseEntity<Wishlist> addWishlist( @RequestBody Wishlist wishlist) { 
			return new ResponseEntity<Wishlist>(wishlistService.addWishlist(wishlist) , HttpStatus.OK);
	}
	
	@DeleteMapping("deleteById/{id}")
	public void deleteWishlistById(@PathVariable int id){
		wishlistService.deleteWishlist(id);
	}
	
	
	@PutMapping("/{wishlistId}/setCustomer/{customerId}")
	public ResponseEntity<Wishlist> addWishListToCustomer(@PathVariable int wishlistId, @PathVariable int customerId) {
		
		Wishlist wishlist =wishlistService.getWishlistById(wishlistId).get();
		Customer customer =customerService.getCustomerById(customerId).get();
		wishlist.setCustomer(customer);
    	return new ResponseEntity<Wishlist>(wishlistService.addWishlist(wishlist),HttpStatus.OK);
	}
	
	@GetMapping("getWishlist/{customerId}")
	public ResponseEntity<Wishlist> getWishlist (@PathVariable int customerId){
		Customer customer=customerService.getCustomerById(customerId).get();
	
	return new ResponseEntity<Wishlist>(customer.getWishlist(),HttpStatus.OK);
	}
	
	@GetMapping("getAllProducts/{customerId}")
	public ResponseEntity<List<Product>> getAllProducts (@PathVariable int customerId){
		Customer customer=customerService.getCustomerById(customerId).get();
		Wishlist wishlist =	customer.getWishlist();
		return new ResponseEntity<List<Product>>(wishlist.getProduct(),HttpStatus.OK);
	}
	

}

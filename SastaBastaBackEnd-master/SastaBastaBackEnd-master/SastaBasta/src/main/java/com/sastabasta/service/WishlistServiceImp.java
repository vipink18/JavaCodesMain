/*@Author Ashutosh Tripathi

This the service implements class for Wishlist module
in which all the business logic is written for Wishlist module

*/

package com.sastabasta.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sastabasta.entities.Wishlist;
import com.sastabasta.repository.WishlistRepository;

@Service
public class WishlistServiceImp implements WishlistService {

	@Autowired
	WishlistRepository wishlistRepository;
	@Autowired
	ProductService productService;

	@Override
	public Wishlist addWishlist(Wishlist wishlist) {

		return wishlistRepository.save(wishlist);
	}

	@Override
	public void deleteWishlist(int wishlistId) {
		wishlistRepository.deleteById(wishlistId);

	}

	@Override
	public Optional<Wishlist> getWishlistById(int wishlistId) {

		return wishlistRepository.findById(wishlistId);
	}

	

}

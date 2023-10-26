package com.sastabasta.ServiceTestcases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sastabasta.entities.Wishlist;
import com.sastabasta.repository.WishlistRepository;
import com.sastabasta.service.WishlistService;

@SpringBootTest
public class WishlistServiceTest {


	@Autowired
	private WishlistService wishlistService;

	@MockBean
	private WishlistRepository wishlistRepository;

	private Wishlist wishlist;

	@BeforeEach
	public void wishListTestSetup() {
		wishlist = new Wishlist();

		wishlist.setWishlistId(1);

	}

	@Test
	public void addWishlistTest() {
		Mockito.when(wishlistRepository.save(wishlist)).thenReturn(wishlist);

		assertThat(wishlistService.addWishlist(wishlist)).isEqualTo(wishlist);
	}

	@Test
	public void deleteWishListByIdTest() {
		Mockito.when(wishlistRepository.findById(1)).thenReturn(Optional.of(wishlist));

		Mockito.doNothing().when(wishlistRepository).deleteById(1);

		wishlistService.deleteWishlist(1);

	}

	@Test
	public void getWishListByIdTest() {

		Mockito.when(wishlistRepository.findById(1)).thenReturn(Optional.of(wishlist));

		assertThat(wishlistService.getWishlistById(1)).isEqualTo(Optional.of(wishlist));
	}
}

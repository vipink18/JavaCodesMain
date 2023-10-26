package com.sastabasta.ServiceTestcases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sastabasta.entities.Customer;
import com.sastabasta.entities.Product;
import com.sastabasta.entities.ProductWebsite;
import com.sastabasta.inputdto.ProductWebsiteInputDto;
import com.sastabasta.repository.ProductRepository;
import com.sastabasta.repository.ProductWebsiteRepository;
import com.sastabasta.service.ProductWebsiteService;

@SpringBootTest
public class ProductWebsiteServiceTest {

	@Autowired
	private ProductWebsiteService productService;

	@MockBean
	private ProductWebsiteRepository productWebsiteRepository;
	
	@MockBean
	private ProductRepository productRepository;

	

	private ProductWebsiteInputDto productWebsiteInputDto;

	private ProductWebsite productWebsite;
	
	private Product product;

	@BeforeEach
	public void ProductWebsiteTestSetup() {
		productWebsiteInputDto = new ProductWebsiteInputDto();
		
		
		
		productWebsiteInputDto.setProductName("Travel bag");
		productWebsiteInputDto.setProductBrand("Wildcraft");
		
		productWebsiteInputDto.setAmazonLink("amazon.com");
		productWebsiteInputDto.setAmazonRating(4);
		productWebsiteInputDto.setAmazonPrice(4000);
		productWebsiteInputDto.setAmazonDiscount(400);
		
		productWebsiteInputDto.setFlipcartLink("flipkart.com");
		productWebsiteInputDto.setFlipcartRating(3);
		productWebsiteInputDto.setFlipcartPrice(3900);
		productWebsiteInputDto.setFlipcartDiscount(500);
		
		productWebsiteInputDto.setMyntraLink("myntra.com");
		productWebsiteInputDto.setMyntraRating(3);
		productWebsiteInputDto.setMyntraPrice(3900);
		productWebsiteInputDto.setMyntraDiscount(500);
		
		productWebsite=new ProductWebsite(
				productWebsiteInputDto.getAmazonLink(),productWebsiteInputDto.getAmazonRating(),productWebsiteInputDto.getAmazonPrice(),productWebsiteInputDto.getAmazonDiscount(),
				productWebsiteInputDto.getFlipcartLink(),productWebsiteInputDto.getFlipcartRating(),productWebsiteInputDto.getFlipcartPrice(),productWebsiteInputDto.getFlipcartDiscount(),
				productWebsiteInputDto.getMyntraLink(),productWebsiteInputDto.getMyntraRating(),productWebsiteInputDto.getMyntraPrice(),productWebsiteInputDto.getMyntraDiscount()
				);
		
		
		
	}

//	@Test
//	public void addProductWebsiteTest() {
//		
//		Product product=new Product(productWebsiteInputDto.getProductName(),productWebsiteInputDto.getProductBrand(),productWebsiteInputDto.getType(),productWebsiteInputDto.getColour(),productWebsiteInputDto.getImage(),null,null);		
//		
//		ProductWebsite productWebsite=new ProductWebsite(
//				productWebsiteInputDto.getAmazonLink(),productWebsiteInputDto.getAmazonRating(),productWebsiteInputDto.getAmazonPrice(),productWebsiteInputDto.getAmazonDiscount(),
//				productWebsiteInputDto.getFlipcartLink(),productWebsiteInputDto.getFlipcartRating(),productWebsiteInputDto.getFlipcartPrice(),productWebsiteInputDto.getFlipcartDiscount(),
//				productWebsiteInputDto.getMyntraLink(),productWebsiteInputDto.getMyntraRating(),productWebsiteInputDto.getMyntraPrice(),productWebsiteInputDto.getMyntraDiscount()
//				);
//		Mockito.when(productRepository.save(product)).thenReturn(product);
//		
//		Mockito.when(productWebsiteRepository.save(productWebsite)).thenReturn(productWebsite);
//
//		assertThat(productService.addProductWebsite(productWebsiteInputDto)).isEqualTo(productWebsite);
//	}

	@Test
	public void getAllProductWebsiteTest() {
		List<ProductWebsite> productWebsiteList = new ArrayList<>();

		productWebsiteList.add(productWebsite);
		

		Mockito.when(productWebsiteRepository.findAll()).thenReturn(productWebsiteList);

		assertThat(productService.findAllProduct()).isEqualTo(productWebsiteList);
	}



	@Test
	public void getProductWebsiteByIdTest() {

		Mockito.when(productWebsiteRepository.findById(1)).thenReturn(Optional.of(productWebsite));

		assertThat(productService.findProductWebsiteById(1)).isEqualTo(Optional.of(productWebsite));
	}

	@Test
	public void deleteProductWebsiteByIdTest() {
		Mockito.when(productWebsiteRepository.findById(1)).thenReturn(Optional.of(productWebsite));

		Mockito.doNothing().when(productWebsiteRepository).deleteById(1);

		productService.deleteProductWebsiteById(1);

		verify(productWebsiteRepository, times(1)).deleteById(1);

	}

}

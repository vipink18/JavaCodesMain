package com.sastabasta.ServiceTestcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sastabasta.entities.Product;
import com.sastabasta.service.ProductService;

@SpringBootTest
class ProductServiceTest {
	
	@Autowired
	ProductService productService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	void updateProduct()  {
		Product pro = new Product();
		pro.setProductId(0);
		pro.setProductName("Gym Bag");
		pro.setProductBrand("Skybags");
		pro.setType("test");
		pro.setColour("Green");
		Product updatedProduct =productService.editProduct(pro);
		
		assertEquals("Gym Bag", updatedProduct.getProductName());
		assertEquals("Skybags",updatedProduct.getProductBrand());
		assertEquals("Green",updatedProduct.getColour());
	}
	


}

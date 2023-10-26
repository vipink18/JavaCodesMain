/*@Author Vipin Dane

This the service implements class for ProductWebiste module
in which all the business logic is written for productWebsite module

*/

package com.sastabasta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sastabasta.entities.Product;
import com.sastabasta.entities.ProductWebsite;

import com.sastabasta.inputdto.ProductWebsiteInputDto;
import com.sastabasta.repository.ProductRepository;
import com.sastabasta.repository.ProductWebsiteRepository;

@Service
public class ProductWebsiteServiceImp implements ProductWebsiteService {
	@Autowired
	ProductWebsiteRepository productWebsiteRepository;
	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductWebsite addProductWebsite(ProductWebsiteInputDto productWebsiteInputDto) {

		Product product = new Product(productWebsiteInputDto.getProductName(), productWebsiteInputDto.getProductBrand(),
				productWebsiteInputDto.getType(), productWebsiteInputDto.getColour(), productWebsiteInputDto.getImage(),
				null, null);
		productRepository.save(product);

		ProductWebsite productWebsite = new ProductWebsite(productWebsiteInputDto.getAmazonLink(),
				productWebsiteInputDto.getAmazonRating(), productWebsiteInputDto.getAmazonPrice(),
				productWebsiteInputDto.getAmazonDiscount(), productWebsiteInputDto.getFlipcartLink(),
				productWebsiteInputDto.getFlipcartRating(), productWebsiteInputDto.getFlipcartPrice(),
				productWebsiteInputDto.getFlipcartDiscount(), productWebsiteInputDto.getMyntraLink(),
				productWebsiteInputDto.getMyntraRating(), productWebsiteInputDto.getMyntraPrice(),
				productWebsiteInputDto.getMyntraDiscount());

		productWebsite.setProduct(product);

		return productWebsiteRepository.save(productWebsite);
	}

	@Override
	public ProductWebsite updateProductWebsite(ProductWebsite productWebsite) {

		return productWebsiteRepository.save(productWebsite);
	}

	@Override
	public Optional<ProductWebsite> findProductWebsiteById(int webId) {

		return productWebsiteRepository.findById(webId);
	}

	@Override
	public void deleteProductWebsiteById(int webId) {
		productWebsiteRepository.deleteById(webId);

	}

	@Override
	public List<ProductWebsite> findAllProduct() {
		return (List<ProductWebsite>) productWebsiteRepository.findAll();
	}

	@Override
	public Product editProduct(ProductWebsite productWebsite, int productId) {
		Product product = productRepository.findById(productId).get();

		product.setProductWebsite(productWebsite);
		productWebsite.setProduct(product);
		productWebsiteRepository.save(productWebsite);

		return product;

	}

}

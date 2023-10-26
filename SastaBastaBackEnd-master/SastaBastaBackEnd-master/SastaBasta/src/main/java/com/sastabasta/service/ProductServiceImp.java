/*@Author Dev Singh Parihar , Sourabh Khanna

This the service implements class for Product and filter module
in which all the business logic is written for product and filter module

*/

package com.sastabasta.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sastabasta.entities.Product;
import com.sastabasta.exceptions.ProductAlreadyExistsException;
import com.sastabasta.inputdto.ProductInputDto;
import com.sastabasta.repository.ProductRepository;
import com.sastabasta.repository.WishlistRepository;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	WishlistRepository wishlistRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product editProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public Optional<Product> getProductById(int productId) {
		return productRepository.findById(productId);
	}

	@Override
	public List<Product> filterProduct(Map<String, String> map) {
		// TreeMap<String, String> sorted = new TreeMap<>();
		// sorted.putAll(map);
		List<Product> products = (List<Product>) productRepository.findAll();
		return products.stream()
				.filter(product -> map.get("colour") == null || product.getColour().equalsIgnoreCase(map.get("colour")))
				.filter(product -> map.get("productBrand") == null
						|| product.getProductBrand().equalsIgnoreCase(map.get("productBrand")))
				.filter(product -> map.get("productName") == null
						|| product.getProductName().equalsIgnoreCase(map.get("productName")))
				.filter(product -> map.get("type") == null || product.getType().equalsIgnoreCase(map.get("type")))

				.collect(Collectors.toList());

	}

	@Override
	public List<Product> getAllProduct() {

		return (List<Product>) productRepository.findAll();
	}

	@Override
	public List<Product> findProductsByBrand(String productBrand) {
		return productRepository.findAllByProductBrand(productBrand);
	}

	@Override
	public List<Product> findProductsByType(String type) {
		return productRepository.findAllByType(type);
	}

	@Override
	public List<Product> findProductsByColour(String colour) {
		return productRepository.findAllByColour(colour);
	}

	@Override
	public Product addProductDto(ProductInputDto productDto) throws ProductAlreadyExistsException {

		Product productInputDto = new Product();

		if (productRepository.findByProductAttribute(productDto.getProductName(), productDto.getColour(),
				productDto.getProductBrand(), productDto.getType()).isPresent()) {
			throw new ProductAlreadyExistsException("Product is already existing with these details");
		}
		productInputDto.setProductName(productDto.getProductName());
		productInputDto.setProductBrand(productDto.getProductBrand());
		productInputDto.setType(productDto.getType());
		productInputDto.setColour(productDto.getColour());
		productInputDto.setImage(productDto.getImage());

		return productRepository.save(productInputDto);

	}

}

/*@Author Dev Singh Parihar , Sourabh Khanna

This the service interface for Product and filter module
in which all the methods are declared according 
the to the requirements for product and filter  module

*/

package com.sastabasta.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sastabasta.entities.Product;
import com.sastabasta.exceptions.ProductAlreadyExistsException;
import com.sastabasta.inputdto.ProductInputDto;

public interface ProductService {

	public Product addProduct(Product product);

	public Product addProductDto(ProductInputDto productInputDto) throws ProductAlreadyExistsException;

	public Product editProduct(Product product);

	public void deleteProduct(int productId);

	public Optional<Product> getProductById(int productId);

	public List<Product> filterProduct(Map<String, String> map);

	public List<Product> getAllProduct();

	public List<Product> findProductsByBrand(String productBrand);

	public List<Product> findProductsByType(String type);

	public List<Product> findProductsByColour(String colour);
	

}

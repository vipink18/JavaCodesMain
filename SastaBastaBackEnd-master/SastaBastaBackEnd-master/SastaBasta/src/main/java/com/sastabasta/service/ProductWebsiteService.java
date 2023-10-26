/*@Author Vipin Dane

This the service interface for ProductWebsite module
in which all the methods are declared according 
the to the requirements for productWebsite module

*/

package com.sastabasta.service;

import java.util.List;
import java.util.Optional;

import com.sastabasta.entities.Product;
import com.sastabasta.entities.ProductWebsite;
import com.sastabasta.inputdto.ProductWebsiteInputDto;

public interface ProductWebsiteService {

	public ProductWebsite addProductWebsite(ProductWebsiteInputDto productWebsiteInputDto);

	public ProductWebsite updateProductWebsite(ProductWebsite productWebsite);

	public Optional<ProductWebsite> findProductWebsiteById(int webId);

	public void deleteProductWebsiteById(int webId);

	public List<ProductWebsite> findAllProduct();

	// public ProductWebsite editProductWebsite(ProductWebsiteInputDto
	// productWebsiteInputDto,int webId,int productId);
	public Product editProduct(ProductWebsite productWebsite, int productId);

}

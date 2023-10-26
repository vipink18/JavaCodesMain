/*@author Vipin Dane

This the repository layer for productWebsite module in which
one custom method is written to find the productWebsite by product


*/


package com.sastabasta.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sastabasta.entities.Product;
import com.sastabasta.entities.ProductWebsite;
@Repository
public interface ProductWebsiteRepository extends CrudRepository<ProductWebsite, Integer> {
//	public ProductWebsite findByWebName(String webName);
//	public ProductWebsite findByproductLink(String productLink );
//	public ProductWebsite findByProductRating(String productRating);
//	public ProductWebsite findProductPrice(String productPrice);
//	public ProductWebsite findProductDiscount(String productDiscount);
	
	public ProductWebsite findByProduct (Product product);
	
	

}

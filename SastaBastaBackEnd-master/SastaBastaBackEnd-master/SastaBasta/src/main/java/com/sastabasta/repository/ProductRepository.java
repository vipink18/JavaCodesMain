/*@author Dev Singh Parihar , Sourabh Khanna

This the repository layer for product module in which
one custom method is written to find the product by brand, type, colour

One custom query is also written which is used to write testCases
*/



package com.sastabasta.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sastabasta.entities.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	public List<Product> findAllByProductBrand(String productBrand);
	public List<Product> findAllByType(String type);
	public List<Product> findAllByColour(String colour);
	

	@Query("SELECT p FROM Product p WHERE p.productName = :productName AND p.type = :type AND p.productBrand = :productBrand AND p.colour = :colour")
    Optional<Product> findByProductAttribute(@Param("productName") String name, @Param("colour") String colour, @Param("productBrand") String brand, @Param("type") String type);


}

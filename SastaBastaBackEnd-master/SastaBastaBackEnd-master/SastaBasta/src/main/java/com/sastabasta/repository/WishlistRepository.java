/*@Author Ashutosh Tripathi

This is the repository layer for wishlist module

*/

package com.sastabasta.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.sastabasta.entities.Wishlist;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, Integer>{
	
	
	
	

}

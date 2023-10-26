/*@author Shuvam Jyoti Shah

This the repository layer for admin module in which
one custom method is written to find the admin for Email and password
*/

package com.sastabasta.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sastabasta.entities.Admin;
@Repository
public interface AdminRespository extends CrudRepository<Admin, Integer>{
	public Admin findByEmailAndPassword(String email,String password);

}

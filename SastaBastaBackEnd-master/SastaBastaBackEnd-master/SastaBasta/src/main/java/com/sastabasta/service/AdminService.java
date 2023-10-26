/*@Author Shuvam Jyoti Shaha

This is the service layer interface for admin module
in which two methods are declared to add the admin and to login the admin

*/
package com.sastabasta.service;

import com.sastabasta.entities.Admin;
import com.sastabasta.exceptions.EmailOrPasswordException;

public interface AdminService {
	
	public Admin findByEmailAndPassword(String email,String password) throws EmailOrPasswordException;
	public Admin addAdmin(Admin admin);

}
 
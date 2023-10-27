package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Supplier;
import com.example.demo.exception.SupplierNotFoundException;

public interface ISupplierService {
	Supplier addSupplier(Supplier S1);
	Supplier updateSupplier(int supplierId,Supplier S1) throws SupplierNotFoundException;
	void deleteSupplier(int supplierId) throws SupplierNotFoundException;
	List<Supplier> getAllSupplier();
	
}


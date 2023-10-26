package com.capg.service;

import java.util.List;

import com.capg.entities.Cylinder;

public interface CylinderService {
	
	public Cylinder insterCylinder(Cylinder cylinder);
	public Cylinder updateCylinder(Cylinder cylinder);
	public String deleteCylinder(int cylinderId);
	public List<Cylinder> viewCylindersByType(String type);
	

}

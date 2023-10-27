package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Advertisement {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "cropType",nullable=false)
	private String cropType;
	
	@Column(name = "quantity",nullable=false)
	private int quantity;

	@Column(name = "weight",nullable=false)
	private String weight;
	
	@Column(name = "price",nullable=false)
	private String price;
	private boolean status=false;
	

	
	public Advertisement(int id, String cropType, int quantity, String weight, String price) {
		
		this.id = id;
		this.cropType = cropType;
		this.quantity = quantity;
		this.weight = weight;
		this.price = price;
		
	}
	
	public String findById(int id) {
		// TODO Auto-generated method stub
		return "Advertisement [id=" + id + ", cropType=" + cropType + ", quantity=" + quantity + ", weight=" + weight
				+ ", price=" + price + ", status=" + status + "]";

	}
	
	
}

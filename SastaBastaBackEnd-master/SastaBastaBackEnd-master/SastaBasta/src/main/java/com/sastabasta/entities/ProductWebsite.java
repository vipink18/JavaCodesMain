/**@author Vipin Dane

This is an Entity class for ProductWebsite
where the details of product present
on amazon, flipcart and myntra is taken the details are like:
->link
->rating
->discount 
->price

In this class one to one relation is also established 
between product and productWebsite

*/


package com.sastabasta.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class ProductWebsite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int webId;
	@Column(name = "amazon_link", length = 2048)
	private String amazonLink;
	private int amazonRating;
	private double amazonPrice;
	private double amazonDiscount;
	@Column(name = "flipcart_link", length = 2048)
	private String flipcartLink;
	private int flipcartRating;
	private double flipcartPrice;
	private double flipcartDiscount;
	@Column(name = "myntra_link", length = 2048)
	private String myntraLink;
	private int myntraRating;
	private double myntraPrice;
	private double myntraDiscount;
	
	@OneToOne()
	@JoinColumn(name = "product_id")
	private Product product;
	
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getWebId() {
		return webId;
	}
	public void setWebId(int webId) {
		this.webId = webId;
	}
	public String getAmazonLink() {
		return amazonLink;
	}
	public void setAmazonLink(String amazonLink) {
		this.amazonLink = amazonLink;
	}
	public int getAmazonRating() {
		return amazonRating;
	}
	public void setAmazonRating(int amazonRating) {
		this.amazonRating = amazonRating;
	}
	public double getAmazonPrice() {
		return amazonPrice;
	}
	public void setAmazonPrice(double amazonPrice) {
		this.amazonPrice = amazonPrice;
	}
	public double getAmazonDiscount() {
		return amazonDiscount;
	}
	public void setAmazonDiscount(double amazonDiscount) {
		this.amazonDiscount = amazonDiscount;
	}
	public String getFlipcartLink() {
		return flipcartLink;
	}
	public void setFlipcartLink(String flipcartLink) {
		this.flipcartLink = flipcartLink;
	}
	public int getFlipcartRating() {
		return flipcartRating;
	}
	public void setFlipcartRating(int flipcartRating) {
		this.flipcartRating = flipcartRating;
	}
	public double getFlipcartPrice() {
		return flipcartPrice;
	}
	public void setFlipcartPrice(double flipcartPrice) {
		this.flipcartPrice = flipcartPrice;
	}
	public double getFlipcartDiscount() {
		return flipcartDiscount;
	}
	public void setFlipcartDiscount(double flipcartDiscount) {
		this.flipcartDiscount = flipcartDiscount;
	}
	public String getMyntraLink() {
		return myntraLink;
	}
	public void setMyntraLink(String myntraLink) {
		this.myntraLink = myntraLink;
	}
	public int getMyntraRating() {
		return myntraRating;
	}
	public void setMyntraRating(int myntraRating) {
		this.myntraRating = myntraRating;
	}
	public double getMyntraPrice() {
		return myntraPrice;
	}
	public void setMyntraPrice(double myntraPrice) {
		this.myntraPrice = myntraPrice;
	}
	public double getMyntraDiscount() {
		return myntraDiscount;
	}
	public void setMyntraDiscount(double myntraDiscount) {
		this.myntraDiscount = myntraDiscount;
	}
	public ProductWebsite( String amazonLink, int amazonRating, double amazonPrice, double amazonDiscount,
			String flipcartLink, int flipcartRating, double flipcartPrice, double flipcartDiscount, String myntraLink,
			int myntraRating, double myntraPrice, double myntraDiscount) {
		super();
		this.amazonLink = amazonLink;
		this.amazonRating = amazonRating;
		this.amazonPrice = amazonPrice;
		this.amazonDiscount = amazonDiscount;
		this.flipcartLink = flipcartLink;
		this.flipcartRating = flipcartRating;
		this.flipcartPrice = flipcartPrice;
		this.flipcartDiscount = flipcartDiscount;
		this.myntraLink = myntraLink;
		this.myntraRating = myntraRating;
		this.myntraPrice = myntraPrice;
		this.myntraDiscount = myntraDiscount;
	}
	public ProductWebsite() {
		
	}
	
	
	
	
	
	
	
	
	

}

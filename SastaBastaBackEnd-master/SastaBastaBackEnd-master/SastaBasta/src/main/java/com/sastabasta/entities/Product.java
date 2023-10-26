package com.sastabasta.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private String productBrand;
	private String type;
	private String colour;
	private String image;

	@ManyToMany()
	@JoinTable(name = "product_wishlist", joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "productId"), inverseJoinColumns = @JoinColumn(name = "wishlist_id", referencedColumnName = "wishlistId"))
	private List<Wishlist> wishlist;

	
	@JsonIgnore
	@OneToOne(mappedBy = "product",cascade = CascadeType.ALL )
	private ProductWebsite productWebsite;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Wishlist> getWishlist() {
		return wishlist;
	}

	public void setWishlist(List<Wishlist> wishlist) {
		this.wishlist = wishlist;
	}

	public ProductWebsite getProductWebsite() {
		return productWebsite;
	}

	public void setProductWebsite(ProductWebsite productWebsite) {
		this.productWebsite = productWebsite;
	}

	public Product(String productName, String productBrand, String type, String colour, String image,
			List<Wishlist> wishlist, ProductWebsite productWebsite) {
		super();
		this.productName = productName;
		this.productBrand = productBrand;
		this.type = type;
		this.colour = colour;
		this.image = image;
		this.wishlist = wishlist;
		this.productWebsite = productWebsite;
	}

	public Product() {
		
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productBrand=" + productBrand
				+ ", type=" + type + ", colour=" + colour + ", image=" + image + ", wishlist=" + wishlist
				+ ", productWebsite=" + productWebsite + "]";
	}
	
	
	
	

}

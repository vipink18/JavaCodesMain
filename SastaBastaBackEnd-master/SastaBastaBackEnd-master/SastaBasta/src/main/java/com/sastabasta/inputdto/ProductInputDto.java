/*@author Shuvam jyoti shah

This the the input dto class for product 
this can be used when user want to add only product details 
without the mapping details of the mapped object
*/
package com.sastabasta.inputdto;

public class ProductInputDto {
	
	private int productId;
	private String productName;
	private String productBrand;
	private String type;
	private String colour;
	private String image;
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
	
	

}

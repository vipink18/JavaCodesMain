/*@author Vipin Dane

This is the Input dto class for both product and productWebsite 
this class will be used when we add product and productWebsite
details on two different form on frontend
*/

package com.sastabasta.inputdto;

public class ProductWebsiteInputDto {

	
	private String productName;
	private String productBrand;
	private String type;
	private String colour;
	private String image;
	private String amazonLink;
	private int amazonRating;
	private double amazonPrice;
	private double amazonDiscount;
	private String flipcartLink;
	private int flipcartRating;
	private double flipcartPrice;
	private double flipcartDiscount;
	private String myntraLink;
	private int myntraRating;
	private double myntraPrice;
	private double myntraDiscount;
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
	public ProductWebsiteInputDto(String productName, String productBrand, String type, String colour, String image) {
		super();
		this.productName = productName;
		this.productBrand = productBrand;
		this.type = type;
		this.colour = colour;
		this.image = image;
	}
	public ProductWebsiteInputDto() {
		super();
	}
	public ProductWebsiteInputDto(String amazonLink, int amazonRating, double amazonPrice, double amazonDiscount,
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
	
	
	
}

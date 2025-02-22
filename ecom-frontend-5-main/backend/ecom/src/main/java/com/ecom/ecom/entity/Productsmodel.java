package com.ecom.ecom.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity

public class Productsmodel {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String brand;
	private BigDecimal price;
	private String category;
	private Date releaseDate;
	private boolean productAvailable;
	private int stockQutity;
	private String imagename;
	private String imagetype;
	@Lob
	private byte[] imageData;
	
	
	
	public Productsmodel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Productsmodel(int id, String name, String description, String brand, BigDecimal price, String category,
			Date releaseDate, boolean productAvailable, int stockQutity, String imagename, String imagetype,
			byte[] imageData) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.category = category;
		this.releaseDate = releaseDate;
		this.productAvailable = productAvailable;
		this.stockQutity = stockQutity;
		this.imagename = imagename;
		this.imagetype = imagetype;
		this.imageData = imageData;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public boolean isProductAvailable() {
		return productAvailable;
	}
	public void setProductAvailable(boolean productAvailable) {
		this.productAvailable = productAvailable;
	}
	public int getStockQutity() {
		return stockQutity;
	}
	public void setStockQutity(int stockQutity) {
		this.stockQutity = stockQutity;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getImagetype() {
		return imagetype;
	}
	public void setImagetype(String imagetype) {
		this.imagetype = imagetype;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	@Override
	public String toString() {
		return "Productsmodel [id=" + id + ", name=" + name + ", description=" + description + ", brand=" + brand
				+ ", price=" + price + ", category=" + category + ", releaseDate=" + releaseDate + ", productAvailable="
				+ productAvailable + ", stockQutity=" + stockQutity + ", imagename=" + imagename + ", imagetype="
				+ imagetype + ", imageData=" + Arrays.toString(imageData) + "]";
	}
	
	
	
}

package com.conan.vo;

public class ProductsVO {
	private String proId;
	private String proName;
	private String description;
	private String manufacturer;
	private String category;
	private String fileName;
	private Integer unitPrice;
	private Integer noOfStock;
	private Integer quantity;
	

	public ProductsVO() {
		// TODO Auto-generated constructor stub
	}
	public ProductsVO(String proId,String proName, String description,String manufacturer,String category,String fileName,Integer unitPrice,Integer noOfStock) {
		setProId(proId);
		setCategory(category);
		setDescription(description);
		setFileName(fileName);
		setManufacturer(manufacturer);
		setNoOfStock(noOfStock);
		setProId(proId);
		setProName(proName);
		setUnitPrice(unitPrice);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Products [proId=" + proId + ", proName=" + proName + ", description=" + description + ", manufacturer="
				+ manufacturer + ", category=" + category + ", fileName=" + fileName + ", unitPrice=" + unitPrice
				+ ", noOfStock=" + noOfStock + "]";
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getNoOfStock() {
		return noOfStock;
	}
	public void setNoOfStock(Integer noOfStock) {
		this.noOfStock = noOfStock;
	}
	
	
}

package model;

import app.Style;

public abstract class Product {

	private String id;
	private float price;
	private String title;
	private String[] imgURLs;
	private String desc;
	private Style style;
	private float height;
	private float length;
	private float width;
	private int qty;
	private boolean variation;
	
	public Product() {}
	
	public Product(String id) {
		this.id = id;
	}
	
	public String getId(String id) {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String[] getImgURLs() {
		return imgURLs;
	}
	public void setImgURLs(String[] imgURLs) {
		this.imgURLs = imgURLs;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}
	public boolean hasVariation() {
		return variation;
	}
	public void setVariation(boolean varies) {
		this.variation = varies;
	}
}

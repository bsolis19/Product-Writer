package model;

import app.Style;

public class Frame extends Product{

	private double frameWidth;
	private double frameDepth;
	private double rabbetDepth;
	private int openingWidth;
	private int openingHeight;
	private boolean hasGlass;
	
	
	
	protected Frame(double price, String title, String[] imgURLs, String desc, Style style, double height,
			double length, double width, int qty, double frameWidth, double frameDepth, double rabbetDepth,
			int openingWidth, int openingHeight, boolean hasGlass) {
		super(price, title, imgURLs, desc, style, height, length, width, qty);
		this.frameWidth = frameWidth;
		this.frameDepth = frameDepth;
		this.rabbetDepth = rabbetDepth;
		this.openingWidth = openingWidth;
		this.openingHeight = openingHeight;
		this.hasGlass = hasGlass;
	}


	public double getFrameWidth() {
		return frameWidth;
	}


	public void setFrameWidth(double frameWidth) {
		this.frameWidth = frameWidth;
	}


	public double getFrameDepth() {
		return frameDepth;
	}


	public void setFrameDepth(double frameDepth) {
		this.frameDepth = frameDepth;
	}


	public double getRabbetDepth() {
		return rabbetDepth;
	}


	public void setRabbetDepth(double rabbetDepth) {
		this.rabbetDepth = rabbetDepth;
	}


	public int getOpeningWidth() {
		return openingWidth;
	}


	public void setOpeningWidth(int openingWidth) {
		this.openingWidth = openingWidth;
	}


	public int getOpeningHeight() {
		return openingHeight;
	}


	public void setOpeningHeight(int openingHeight) {
		this.openingHeight = openingHeight;
	}


	public boolean isHasGlass() {
		return hasGlass;
	}


	public void setHasGlass(boolean hasGlass) {
		this.hasGlass = hasGlass;
	}

}

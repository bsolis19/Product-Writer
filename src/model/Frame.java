package model;

public class Frame extends Product{

	private double frameWidth;
	private double frameDepth;
	private double rabbetDepth;
	private int openingWidth;
	private int openingHeight;
	private boolean hasGlass;
	
	
	
	protected Frame(String id) {
		super(id);
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

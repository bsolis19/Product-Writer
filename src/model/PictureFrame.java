package model;

public class PictureFrame extends Product {

	private final String styleNum;
	private final float backWidth;
	private final float frameWidth;
	private final float frameHeight;
	private final float frameRabbet;
	private final boolean wooden;
	private final short photoLength;
	private final short photoHeight;	
	private final AddOn[] addOns;
	
	public PictureFrame(String styleNum, float backWidth, float frameWidth, float frameHeight, float frameRabbet,
			boolean wooden, short photoLength, short photoHeight, AddOn[] addOns) {
		super();
		this.styleNum = styleNum;
		this.backWidth = backWidth;
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.frameRabbet = frameRabbet;
		this.wooden = wooden;
		this.photoLength = photoLength;
		this.photoHeight = photoHeight;
		this.addOns = addOns;
	}
}

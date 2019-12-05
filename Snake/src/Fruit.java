import java.awt.Image;
import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

public class Fruit {
	protected Point position;
	protected  int value=1;
	protected Image image;
	protected boolean empty = true;
	protected int idFruit = 1;
	protected final int fruit_image_width=10;
	protected final int fruit_image_height=10;
	
	Fruit() {
		position = new Point();
		loadImage();
		generatePosition();
		
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
	public void loadImage() {
		ImageIcon ii = new ImageIcon("src/Images/obelixo.png");
		image = ii.getImage();
		}
	
	public void generatePosition() {
		Random randomInt = new Random();
		int X,Y;
    	do {
    		X = randomInt.nextInt((int)(300/10))*fruit_image_width;
    		Y = randomInt.nextInt((int)((300)/10))*fruit_image_height;
    	}while(X==150);
    	position.setLocation(X,Y);

	}
	
}

import javax.swing.ImageIcon;

public class FruitBig extends Fruit{
	
	
	FruitBig(){
		super();
		value=2;
		idFruit=3;
	}
	@Override
	public void loadImage() {
		ImageIcon ii = new ImageIcon("src/Images/FruitBig.png");
		image = ii.getImage();
	}

}

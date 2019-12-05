import javax.swing.ImageIcon;

public class FruitDecrease extends Fruit {
	
	public FruitDecrease() {
		super();
		idFruit = 4;
	}
	
	@Override
	public void loadImage() {
		ImageIcon ii = new ImageIcon("src/Images/Minus.png");
		image = ii.getImage();
	}

}

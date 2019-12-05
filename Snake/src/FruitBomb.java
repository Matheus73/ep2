import javax.swing.ImageIcon;

public class FruitBomb extends Fruit{
	
	FruitBomb(){
		super();
		idFruit = 2;
	}
	
	@Override
	public void loadImage() {
		ImageIcon ii = new ImageIcon("src/Images/BombFruit.png");
		image = ii.getImage();
	}
}

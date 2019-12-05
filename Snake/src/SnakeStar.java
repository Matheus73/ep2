import java.awt.Point;
import javax.swing.ImageIcon;

public class SnakeStar extends Snakes{
	
	SnakeStar(){
		super();
		pontuation = 2;
	}
	
	
	@Override
	public void loadImage() {
		ImageIcon iconSnake = new ImageIcon("src/Images/SnakeStar.png");
		snake = iconSnake.getImage();
		bodyImage = iconSnake.getImage();		
		w = snake.getWidth(null);
		h = snake.getHeight(null);
	}
	
	@Override
	public void incrementBody() {
		body.addLast(new Point((int)body.getLast().getX(), (int)body.getLast().getY()));
		body.addLast(new Point((int)body.getLast().getX(), (int)body.getLast().getY()));
		
	}

}

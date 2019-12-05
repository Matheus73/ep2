import java.awt.Point;

import javax.swing.ImageIcon;

public class SnakeKitty extends Snakes {
	
	SnakeKitty(){
		super();
	}

	@Override
	public void loadImage() {
		ImageIcon iconSnake = new ImageIcon("src/Images/SnakeKitty.png");
		snake = iconSnake.getImage();
		bodyImage = iconSnake.getImage();		
		w = snake.getWidth(null);
		h = snake.getHeight(null);
	}
	
	@Override 
	public boolean checkColision() {
		if (positionSnake.getY() >= 300) {
        	setPositionSnake(new Point((int)positionSnake.getLocation().getX(),0));
        	return true;
        }
        else if (positionSnake.getY() < 0) {
        	setPositionSnake(new Point((int)positionSnake.getLocation().getX(),290));
        	return true;
        }
        else if (positionSnake.getX() >= 300) {
        	setPositionSnake(new Point(0,(int)positionSnake.getLocation().getY()));
        	return true;
        }
        else if (positionSnake.getX() < 0) {
        	setPositionSnake(new Point(300,(int)positionSnake.getLocation().getY()));
        	return true;
        }
		for(int i=0;i<(int)body.size();i++)
			if(positionSnake.equals(body.get(i))){
					return false;
			}
		return true;

	}
}

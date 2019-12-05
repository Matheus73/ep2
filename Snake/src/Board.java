
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Board extends JPanel {
	
	
	private Snakes snake;
	private LinkedList<Point> wall;
	private Image wallImage;
	
	
	public void setWall(LinkedList<Point> wall) {
		this.wall = wall;
	}

	//	public void setSnakeStar(SnakeStar snakeStar) {
//		this.snakeStar = snakeStar;
//	}
//	
	public void setSnake(Snakes snake) {
		this.snake = snake;
	}
	private Fruit fruit;
	private Fruit especialFruit;
	
	public void setEspecialFruit(Fruit especialFruit) {
		this.especialFruit = especialFruit;
	}
	
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}

		
	public Board() {
		setBackground(Color.BLACK);
		setFocusable(true);
		loadImages();
	}
	
	public void loadImages() {
		ImageIcon ii = new ImageIcon("src/Images/Wall.png");
		wallImage = ii.getImage();
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//SIMPE FRUIT
			g.drawImage(fruit.getImage(),(int)fruit.getPosition().getX(),(int)fruit.getPosition().getY(),10,10,null);
			//ESPECIAL FRUITS
			if(!(especialFruit.isEmpty())) {
				g.drawImage(especialFruit.getImage(),(int)especialFruit.getPosition().getX(),(int)especialFruit.getPosition().getY(),10,10,null);
			}
			
			//HEAD SNAKE
			g.drawImage(snake.getSnake(),(int)snake.getPositionSnake().getX(),(int)snake.getPositionSnake().getY(),10,10,null);
			//BODY SNAKE
			for(int i=0;i<snake.body.size();i++)
				g.drawImage(snake.getSnake(),(int)snake.body.get(i).getX(),(int)snake.body.get(i).getY(),10,10,null);
			
			//WALL
			for(int i =0;i<wall.size();i++)
				g.drawImage(wallImage,(int)wall.get(i).getX() , (int)wall.get(i).getY(),10, 10, null);
			
			
			Toolkit.getDefaultToolkit().sync();
	}
}



	
	


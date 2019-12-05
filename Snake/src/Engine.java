import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JLabel;

public class Engine implements Runnable,KeyListener{
	private static boolean running;
	private GameOver gameOver;
	private JLabel logo;
	private int points=0;
	private Fruit simpleFruit;
	private Fruit especialFruit;
	private Snakes snake;
	private Board board;
	private LinkedList <Point> wall;
	private Frame mainFrame;
	private Thread gameLoop;
	private FruitController fruitsController;
	private int id;
	
	
	public Engine(int id){
		this.id = id;
		fruitsController = new FruitController();
		wall = new LinkedList<Point>();
		for(int i=110;i<200;i+=10)
			wall.add(new Point(150,i));
		
		mainFrame = new Frame();
		logo = new JLabel();
		logo.setText("Score: 0");
		logo.setForeground(Color.WHITE);
		gameOver = new GameOver(mainFrame);
		mainFrame.setVisible(true);
		simpleFruit = new Fruit();
		board = new Board();
		switch(id) {
		case 1:
			snake = new Snakes();
			board.setSnake(snake);
			
			break;
		case 2:
			snake= new SnakeStar();
			board.setSnake(snake);
			
			break;
		case 3:
			snake=new SnakeKitty();
			board.setSnake(snake);
			break;
		}
		
		board.add(logo);
		board.setWall(wall);
		board.setFruit(simpleFruit);
		mainFrame.add(board);
		gameLoop = new Thread(this);
		board.addKeyListener(this);
		board.requestFocus();
		new Thread(fruitsController).start(); 
		gameLoop.start();
	}
	
	@Override
	public void run() {
		running=true;
		
		while(running) {
				this.especialFruit = fruitsController.getEspecialFruit();
				board.setEspecialFruit(especialFruit);
				snake.setLastPosition(new Point((int)snake.positionSnake.getLocation().getX(),(int)snake.positionSnake.getLocation().getY()));
				snake.getPositionSnake().translate(snake.getVX(),snake.getVY());
				snake.moveBody();
				running = snake.checkColision();
				checkEspecialFruit(especialFruit.getPosition(), snake.getPositionSnake());
				checkFruit(simpleFruit.getPosition(), snake.getPositionSnake());
				checkWall();
				board.repaint();
			
				try {
					Thread.sleep(75);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
			}
		
		
		board.setVisible(false);
		mainFrame.add(gameOver);
		
		
		
	}
		
	

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
	
	    if (((key == KeyEvent.VK_LEFT)||(key == KeyEvent.VK_A)) && (!snake.getRightDirection())) {
	    	snake.setLeftDirection(true);
	    	snake.setUpDirection(false);
	    	snake.setDownDirection(false);
	    	snake.setVX(-10);
	    	snake.setVY(0);
	    }
	
	    if (((key == KeyEvent.VK_RIGHT)||(key == KeyEvent.VK_D)) && (!snake.getLeftDirection())) {
	        snake.setRightDirection(true);
	        snake.setUpDirection(false);
	        snake.setDownDirection(false);
	        snake.setVX(10);
	        snake.setVY(0);
	    }
	
	   if (((key == KeyEvent.VK_UP)||(key == KeyEvent.VK_W)) && (!snake.getDownDirection())) {
	    	snake.setUpDirection(true);
	    	snake.setRightDirection(false);
	    	snake.setLeftDirection(false);
	    	snake.setVX(0);
	    	snake.setVY(-10);
	    }
	
	    if (((key == KeyEvent.VK_DOWN)||(key == KeyEvent.VK_S)) && (!snake.getUpDirection())) {
	    	snake.setDownDirection(true);
	    	snake.setRightDirection(false);
	    	snake.setLeftDirection(false);
	    	snake.setVX(0);
	    	snake.setVY(10);
	    }
		
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void checkFruit(Point positionFruit, Point positionHead) {
		if(positionHead.equals(simpleFruit.getPosition())) {
			simpleFruit = new Fruit();
			board.setFruit(simpleFruit);
			points+=snake.getPontuation();
			logo.setText("Score: "+points);
			snake.incrementBody();
			
		}
		
	}
	public void checkWall() {
		if(id!=3) {
			for(int i=0;i<9;i++)
				if(snake.getPositionSnake().equals(wall.get(i))) {
					running=false;
			}
		}
	}
	
	public void checkEspecialFruit(Point positionFruit, Point positionHead) {
		if(positionHead.equals(especialFruit.getPosition())) {
			switch(especialFruit.idFruit) {
			case 2:
				running=false;
				break;
			case 3:
				points+=snake.getPontuation()*especialFruit.value;
				logo.setText("Score: "+points);
				snake.incrementBody();
				snake.incrementBody();
				especialFruit.setPosition(new Point(500,500));
				break;
			case 4:
				snake.body.clear();
				if(snake.downDirection) {       
					snake.body.addFirst(new Point((int)snake.getPositionSnake().getX(),(int)snake.getPositionSnake().getY()-10));
					snake.body.addFirst(new Point((int)snake.getPositionSnake().getX(),(int)snake.getPositionSnake().getY()-20));
				}
				else if(snake.leftDirection) {  //ok
					snake.body.addFirst(new Point((int)snake.getPositionSnake().getX()+10,(int)snake.getPositionSnake().getY()));
					snake.body.addFirst(new Point((int)snake.getPositionSnake().getX()+20,(int)snake.getPositionSnake().getY()));
				}
				else if(snake.rightDirection) { //ok
					snake.body.addFirst(new Point((int)snake.getPositionSnake().getX()-10,(int)snake.getPositionSnake().getY()));
					snake.body.addFirst(new Point((int)snake.getPositionSnake().getX()-20,(int)snake.getPositionSnake().getY()));
				}
				else if(snake.upDirection) {
					snake.body.addFirst(new Point((int)snake.getPositionSnake().getX(),(int)snake.getPositionSnake().getY()+10));
					snake.body.addFirst(new Point((int)snake.getPositionSnake().getX(),(int)snake.getPositionSnake().getY()+20));
				}
				
				especialFruit.setPosition(new Point(500,500));

				
				
				break;
			}
			
		}
	}
	
	public static boolean isRunning() {
		return running;
	}


}

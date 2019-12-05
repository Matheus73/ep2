import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;

import javax.swing.ImageIcon;


public class Snakes {
	protected boolean leftDirection = false;
    protected boolean rightDirection = true;
    protected boolean upDirection = false;
    protected boolean downDirection = false;
    protected Image snake;
    protected Image bodyImage;
    protected LinkedList<Point> body;
	protected Point positionSnake;
	protected Point lastPosition;
	protected int VX=10;
    protected int VY=0;
    protected int w;
    protected int h;
    protected int pontuation = 1;
    
    public int getPontuation() {
    	return pontuation;
    }
    
	public Point getPositionSnake() {
		return positionSnake;
	}
	public void setPositionSnake(Point positionSnake) {
		this.positionSnake = positionSnake;
	}
	public void setVX(int vX) {
		VX = vX;
	}
	public int getVX() {
		return VX;
	}
	public int getVY() {
		return VY;
	}
	public void setVY(int vY) {
		VY = vY;
	}

	public Image getSnake() {
		return snake;
	}
	public void setSnake(Image snake) {
		this.snake = snake;
	}

    
    
    
   //getters and setters 
    
    public boolean getLeftDirection() {
		return leftDirection;
	}
	public void setLeftDirection(boolean leftDirection) {
		this.leftDirection = leftDirection;
	}
	public boolean getRightDirection() {
		return rightDirection;
	}
	public void setRightDirection(boolean rightDirection) {
		this.rightDirection = rightDirection;
	}
	public boolean getUpDirection() {
		return upDirection;
	}
	public void setUpDirection(boolean upDirection) {
		this.upDirection = upDirection;
	}
	public boolean getDownDirection() {
		return downDirection;
	}
	public void setDownDirection(boolean downDirection) {
		this.downDirection = downDirection;
	}
	public Image getsnake() {
		return snake;
	}
	
	
	// methods 
	Snakes() {
		body = new LinkedList<>();
		positionSnake = new Point(30,30);
		body.add(new Point(20,30));
		body.addLast(new Point(10,30));
		loadImage();
	}
	
	
	public void loadImage() {
		ImageIcon iconSnake = new ImageIcon("src/Images/Snake.png");
		snake = iconSnake.getImage();
		bodyImage = iconSnake.getImage();		
		w = snake.getWidth(null);
		h = snake.getHeight(null);
	}
	
	public boolean checkColision() {
		if(positionSnake.getX()>299 || positionSnake.getX()<0) {
			return false;
		}
		if(positionSnake.getY()>299 || positionSnake.getY()<0) {
			return false;
		}
		for(int i=0;i<(int)body.size();i++)
			if(positionSnake.equals(body.get(i))){
					return false;
			}
		return true;
		
	}
	public void moveBody() {
		body.addFirst(lastPosition);
		body.removeLast();
		
	}
	public void setLastPosition(Point heads){
		this.lastPosition = heads;
	}
	
	public void incrementBody() {
		body.addLast(new Point((int)body.getLast().getX(), (int)body.getLast().getY()));
		
	}
   
    
    	
}

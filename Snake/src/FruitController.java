import java.awt.Point;
import java.util.Random;


public class FruitController implements Runnable{
	
	private final int FRUIT_TIME = 5000;
	//private LinkedList<Fruit> fruits;
	//private Timer timer;
	private Random randomFruit;
	private Fruit especialFruit;
	

	public FruitController() {
		//fruits = new LinkedList<>();
		//timer = new Timer();
		especialFruit = new Fruit();
		randomFruit = new Random();
		
		}
	
	public Fruit getEspecialFruit() {
		return especialFruit;
	}

	@Override
	public void run() {
		
//		System.out.println("TIME");
		try {
			Thread.sleep(FRUIT_TIME);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
//		System.out.println("entrou no run");
		while(Engine.isRunning()) {
			
		
			switch(randomFruit.nextInt(3)) {
			case 0:
//				System.out.println("bomba!");
				especialFruit = new FruitBomb();
				especialFruit.empty = false;
				break;
			case 1:
//				System.out.println("GRANDE!");
				especialFruit = new FruitBig();
				especialFruit.empty = false;
				break;
			case 2:
//				System.out.println("----------- ENCOLHE!");
				especialFruit = new FruitDecrease();
				especialFruit.empty = false;
				break;
			}
							
			
			
			try {
				Thread.sleep(FRUIT_TIME);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}
			
			
			
		}
		
	}




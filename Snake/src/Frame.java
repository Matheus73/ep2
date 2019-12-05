
import java.awt.Dimension;


import javax.swing.BoxLayout;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	public Frame() {
		initConfig();
	}
	
	public void initConfig() {
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(300,300));
		setTitle("Snake");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
//		this.add(panel);
		
	}
	
	
}

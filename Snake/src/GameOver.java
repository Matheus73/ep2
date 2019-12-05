import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class GameOver extends JPanel implements ActionListener{
	private JLabel mensage;
	
	private JButton btnExit;
	private JButton btnReset;
	private Frame teste;
	public GameOver(Frame teste) {
		this.teste = teste;
		setPreferredSize(new Dimension(300,300));
		setBackground(Color.RED);
		mensage = new JLabel();
		mensage.setForeground(Color.BLACK);
		mensage.setFont(new Font("Dialog", Font.BOLD, 22));
		mensage.setBounds(70, 38, 168, 166);
		mensage.setText("GAME OVER!");
		mensage.setPreferredSize(new Dimension(100,200));
		btnExit = new JButton("EXIT");
		btnExit.setBounds(31, 180, 110, 70);
		btnExit.addActionListener(this);
		btnExit.setActionCommand("EXIT");
		btnExit.setForeground(Color.BLACK);
		btnExit.setFocusPainted(false);
		btnReset = new JButton("RESTART");
		btnReset.setBounds(153, 180, 110, 70);
		btnReset.addActionListener(this);
		btnReset.setActionCommand("REPLAY");
		btnReset.setForeground(Color.BLACK);
		setLayout(null);
		this.add(btnExit);
		this.add(btnReset);
		this.add(mensage);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch(arg0.getActionCommand()) {
			case "EXIT":
				System.exit(0);
				break;
			case "REPLAY":
				teste.dispose();
				new MenuBuilder();
				break;
				
		}
		
	}
	

}

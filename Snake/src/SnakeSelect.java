import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SnakeSelect implements ActionListener {
	private JPanel menuPanel;
	private Frame tela;
	private JButton btnSimple;
	private JButton btnStar;
	private JButton btnKitty;
	private JLabel logo;
	private JLabel logo1;
	SnakeSelect(){
		logo = new JLabel("SNAKE");
		logo1 = new JLabel("SELECT THE SNAKE:");
		logo1.setForeground(Color.GREEN);
		logo1.setLocation(83, 75);
		logo1.setSize(150, 70);
		logo.setFont(new Font("Dialog", Font.BOLD, 24));
		logo.setBounds(97, 46, 203, 46);
		logo.setForeground(Color.green);
		
		menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(300,300));
		menuPanel.setBackground(Color.black);
		menuPanel.setLayout(null);
		btnKitty = new JButton("KITTY");
		btnKitty.setLocation(12, 175);
		btnKitty.setSize(80, 80);
		btnStar = new JButton("STAR");
		btnStar.setLocation(208, 175);
		btnStar.setSize(80, 80);
		btnSimple = new JButton("SIMPLE");
		btnSimple.setFont(new Font("Dialog", Font.BOLD, 9));
		btnSimple.setLocation(112, 175);
		btnSimple.setSize(80, 80);
		btnSimple.addActionListener(this);
		btnStar.addActionListener(this);
		btnKitty.addActionListener(this);
		btnSimple.setActionCommand("SIMPLE");
		btnStar.setActionCommand("STAR");
		btnKitty.setActionCommand("KITTY");
		menuPanel.add(logo);
		menuPanel.add(logo1);
		menuPanel.add(btnKitty);
		menuPanel.add(btnSimple);
		menuPanel.add(btnStar);
		tela = new Frame();
		tela.getContentPane().add(menuPanel);
		tela.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "SIMPLE":
			tela.dispose();
			new Engine(1);
			break;
		case "STAR":
			tela.dispose();
			new Engine(2);
			break;
		case "KITTY":
			tela.dispose();
			new Engine(3);
			break;

		
	}

}
}

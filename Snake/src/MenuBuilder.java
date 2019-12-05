import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class MenuBuilder implements ActionListener{
	private JPanel menuPanel;
	private Frame tela;
	private JButton btnExit;
	private JButton btnPlay;
	private JLabel logo;
	MenuBuilder(){
		logo = new JLabel("SNAKE");
		logo.setFont(new Font("Dialog", Font.BOLD, 35));
		logo.setBounds(85, 86, 203, 46);
		logo.setForeground(Color.green);
		btnExit = new JButton("EXIT");
		btnExit.setBounds(12, 195, 123, 57);
		btnPlay = new JButton("PLAY");
		btnPlay.setBounds(165, 195, 123, 57);
		btnPlay.addActionListener(this);
		btnExit.addActionListener(this);
		menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(300,300));
		menuPanel.setBackground(Color.black);
		menuPanel.setLayout(null);
		menuPanel.add(logo);
		menuPanel.add(btnExit);
		menuPanel.add(btnPlay);
		tela = new Frame();
		tela.getContentPane().add(menuPanel);
		tela.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "EXIT":
			System.exit(0);
			break;
		case "PLAY":
			tela.dispose();
			new SnakeSelect();
			
			break;

		
	}

}

}

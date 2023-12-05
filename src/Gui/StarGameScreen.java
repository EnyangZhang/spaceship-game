package Gui;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;

public class StarGameScreen {

	private JFrame frmStartGame;
	private GameManager manager;
	
	/**
	 * Create the application.
	 */
	public StarGameScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		frmStartGame.setVisible(true);
	}
	
	public void closeWindow() {
		frmStartGame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeStarScreen(this);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStartGame = new JFrame();
		frmStartGame.getContentPane().setBackground(Color.WHITE);
		frmStartGame.setTitle("StartGame");
		frmStartGame.setBounds(100, 100, 1000, 700);
		frmStartGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStartGame.getContentPane().setLayout(null);
		
		JButton startGameButton = new JButton("");
		startGameButton.setIcon(new ImageIcon(StarGameScreen.class.getResource("/img/play button.png")));
		startGameButton.setContentAreaFilled(false);
		startGameButton.setBorderPainted(false);
		startGameButton.setOpaque(false);
		startGameButton.setBackground(Color.WHITE);
		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
				manager.launchSetupScreen();
			}
		});
		
		startGameButton.setBounds(311, 475, 367, 126);
		frmStartGame.getContentPane().add(startGameButton);
		JLabel BackGround = new JLabel("");
		BackGround.setIcon(new ImageIcon(StarGameScreen.class.getResource("/img/background.jpg")));
		BackGround.setBounds(0, 0, 1000, 672);
		frmStartGame.getContentPane().add(BackGround);
		
		
	}
}

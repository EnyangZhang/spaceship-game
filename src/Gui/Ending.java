package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;

import game.Crew;
import game.CrewMember;

public class Ending {

	private JFrame ending;
	private GameManager manager;
	private int result;

	public Ending(GameManager incomingManager, int end) {
		result = end;
		manager = incomingManager;
		initialize();
		ending.setVisible(true);
	}
	
	public void closeWindow() {
		ending.dispose();
	}
	
	public void finishedWindow() {
		manager.closeEndingScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ending = new JFrame();
		ending.getContentPane().setBackground(Color.GRAY);
		ending.getContentPane().setLayout(null);
		
		int scrore=0;
		for(CrewMember crew: Crew.getCrew()) {
			scrore += crew.getHealth();
		}
		
		scrore = scrore/Crew.getCrew().size();
		
		
		
		if(result == 1) {
			JLabel endingPrompt = new JLabel("You have found all missing transporter parts, let's go home!Home sweet home!");
			endingPrompt.setBounds(139, 90, 536, 62);
			ending.getContentPane().add(endingPrompt);
			JLabel score = new JLabel("score: " + Integer.toString(scrore));
			score.setBounds(160, 150, 536, 62);
			ending.getContentPane().add(score);
			ending.setTitle("Ending");
			ending.setBounds(100, 100, 600, 480);
			ending.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			finishedWindow();
		} else if(result == 2) {
			JLabel endingPrompt = new JLabel("You run out of time! Lost in space.");
			endingPrompt.setBounds(139, 150, 536, 62);
			ending.getContentPane().add(endingPrompt);
			JLabel score = new JLabel("score: " + Integer.toString(scrore));
			score.setBounds(160, 90, 536, 62);
			ending.getContentPane().add(score);
			ending.setTitle("Ending");
			ending.setBounds(100, 100, 600, 480);
			ending.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			finishedWindow();
		} else if(result == 3) {
			JLabel endingPrompt = new JLabel("Your crew members are all dead, %s is flying in the space peacefully forever!");
			endingPrompt.setBounds(139, 90, 536, 62);
			ending.getContentPane().add(endingPrompt);
			JLabel score = new JLabel("score: " + Integer.toString(scrore));
			score.setBounds(160, 150, 536, 62);
			ending.getContentPane().add(score);
			ending.setTitle("Ending");
			ending.setBounds(100, 100, 600, 480);
			ending.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			finishedWindow();
		} else if(result == 4) {
			JLabel endingPrompt = new JLabel("You dead by explosion of your spaceship");
			endingPrompt.setBounds(139, 90, 536, 62);
			ending.getContentPane().add(endingPrompt);
			JLabel score = new JLabel("score: " + Integer.toString(scrore));
			score.setBounds(160, 150, 536, 62);
			ending.getContentPane().add(score);
			ending.setTitle("Ending");
			ending.setBounds(100, 100, 600, 480);
			ending.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			finishedWindow();
		}
	}

}

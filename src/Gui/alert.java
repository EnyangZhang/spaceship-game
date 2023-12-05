package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import game.GameEnvironment;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class alert {

	private JFrame alert;
	private GameManager manager;
	private int alertVersion;

	public alert(GameManager incomingManager, int alertVersion) {
		manager = incomingManager;
		this.alertVersion = alertVersion;
		initialize();
		alert.setVisible(true);

	}

	public void closeWindow() {
		alert.dispose();
	}

	public void finishedWindow() {
		manager.closeAlertScreen(this);
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		alert = new JFrame();
		alert.setTitle("Alert");
		alert.getContentPane().setBackground(Color.GRAY);
		alert.setBounds(100, 100, 800, 238);
		alert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alert.getContentPane().setLayout(null);
		
	
			JLabel alertPromt = new JLabel();
			alertPromt.setBounds(12, 12, 600, 15);
			alert.getContentPane().add(alertPromt);
			if(alertVersion == 1) {
				alertPromt.setText("No more room on our spaceship");
			} else if(alertVersion == 2) {
				alertPromt.setText("You need more than 2 crew member");
			} else if(alertVersion == 3) {
				alertPromt.setText("Unique name for crew member");
			} else if(alertVersion == 4) {
				alertPromt.setText("Required transport parts " + GameEnvironment.partsRequired + " in " + GameEnvironment.daysToPlay + " days.");
			} else if(alertVersion == 5) {
				alertPromt.setText(GameScreen.getCrewMember().getName() + " has recovered 25 tiredness");
			} else if(alertVersion == 6) {
				alertPromt.setText(GameScreen.getCrewMember().getName() + " no need to rest");
			} else if(alertVersion == 7) {
				alertPromt.setText("Please choose one crew for action");
			} else if(alertVersion == 8) {
				alertPromt.setText("Can't perform action");
			} else if(alertVersion == 9) {
				alertPromt.setText("Spaceship been repaired by " + GameScreen.getCrewMember().getRepairAbility());
			} else if(alertVersion == 10) {
				alertPromt.setText("Our spaceship no need to be repaired");
			} else if(alertVersion == 11) {
				alertPromt.setText("Plane has already been searched");
			} else if(alertVersion == 12) {
				alertPromt.setText(GameScreen.getCrewMember().getName() + " is too tired to do this");
			} else if(alertVersion == 13) {
				alertPromt.setText("A transporter part has been found");
			} else if(alertVersion == 14) {
				alertPromt.setText("No transporter part on this planet leave here");
			} else if(alertVersion == 15) {
				alertPromt.setText("Found some supplies on this planet");
			} else if(alertVersion == 16) {
				alertPromt.setText("Out of stock or money");
			} else if(alertVersion == 17) {
				alertPromt.setText(GameScreen.getCrewMember().getName() +  " is eating food");
			} else if(alertVersion == 18) {
				alertPromt.setText(GameScreen.getCrewMember().getName() +  " no need to eat");
			} else if(alertVersion == 19) {
				alertPromt.setText(GameScreen.getCrewMember().getName() +  " is healed");
			} else if(alertVersion == 20) {
				alertPromt.setText(GameScreen.getCrewMember().getName() +  " no need to be heal");
			} else if(alertVersion == 21) {
				GameEnvironment.mercenaryCheck();
				if(GameEnvironment.haveMercenary) {
					alertPromt.setText("You encontered space pirate, your Mercenary protected you");
				} else {
					alertPromt.setText("You encontered space pirate, they stolen one of your item");
				}
			} else if(alertVersion == 22) {
				alertPromt.setText("A crew of you infest plague, use potion");
			} else if(alertVersion == 23) {
				alertPromt.setText("You dont have enough pilot to fly, waiting for death");
			} else if(alertVersion == 24) {
				alertPromt.setText("One of pilot can't make it");
			}else if(alertVersion == 25) {
				alertPromt.setText("Met astroid belt, your pilot helps you reduced damage");
			}else if(alertVersion == 26) {
				alertPromt.setText("Met astroid belt, your shield level been reduced");
			}else if(alertVersion == 27) {
				alertPromt.setText("We are on new planet");
			} else if(alertVersion == 28) {
				alertPromt.setText("We have professional pilot and assistant pilot, they will help us avoid astroid belt!");
			} else if(alertVersion == 29) {
				alertPromt.setText("Our pilot reduced damage from astriod belt");
			} else if(alertVersion == 30) {
				alertPromt.setText("We went through an astroid belt during the flight to next planet");
			} else if(alertVersion == 31) {
				alertPromt.setText("Pirate is stealing your stuff, but you are poor");
			} else if(alertVersion == 32) {
				alertPromt.setText("Please choose two pilots");
			} 
			
			JButton Ok = new JButton("Ok");
			Ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					finishedWindow();
					if(alertVersion == 4) {
						GameEnvironment.initOutPost();
						SetupGameScreen.closeWindow();
						manager.launchGameScreen();
					};
				}
			});
			Ok.setBackground(Color.LIGHT_GRAY);
			Ok.setBounds(360, 156, 114, 25);
			alert.getContentPane().add(Ok);
			
	}

}

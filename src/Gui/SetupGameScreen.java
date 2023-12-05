package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import game.Crew;
import game.CrewMember;
import game.GameEnvironment;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class SetupGameScreen {
	private int days = 3;
	private static int crewNumber = 0;
	private static JFrame setupGame;
	private GameManager manager;
	private JTextField crewNameInput;
	private JTextField spaceshipNameInput;
	private static JPanel panel = new JPanel();
	private static JLabel crewInfo;
	
	public SetupGameScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		setupGame.setVisible(true);
	}

	public static void closeWindow() {
		setupGame.dispose();
	}

	public void finishedWindow() {
		manager.closeSetupScreen(this);
	}
	
	public int getCrewNumber() {
		return crewNumber;
	}
	
	public static void addCrewNumber() {
		crewNumber += 1;
	}
	
	public static void displayButton() {
		System.out.println(Crew.getCrew());

		panel.removeAll();
		panel.validate();
		panel.repaint();
		int y = 35; 
		for(CrewMember crew: Crew.getCrew()) {
			if(crew.getType() == "pilot") {	
					JButton pilotSelect = new JButton("Pilot");
					pilotSelect.setBounds(60, y,100, 90);
					pilotSelect.setIcon(new ImageIcon(SetupGameScreen.class.getResource("/img/pilot.jpg")));

					panel.add(pilotSelect);

					
					crewInfo = new JLabel("Name:" + crew.getName());
					crewInfo.setForeground(Color.RED);

					crewInfo.setBounds(170, y, 123, 30);
					panel.add(crewInfo);
					y += 110;

				} else if(crew.getType() == "assistant pilot") {	
					JButton pilotSelect = new JButton("Assistant pilot");
					pilotSelect.setIcon(new ImageIcon(SetupGameScreen.class.getResource("/img/assistant pilot.jpg")));

					pilotSelect.setBounds(60, y,100, 90);
					panel.add(pilotSelect);

					crewInfo = new JLabel("Name:" + crew.getName());
					crewInfo.setForeground(Color.RED);

					crewInfo.setBounds(170, y, 123, 30);
					panel.add(crewInfo);
					y += 110;
				} else if(crew.getType() == "doctor") {	
					JButton pilotSelect = new JButton("doctor");
					pilotSelect.setIcon(new ImageIcon(SetupGameScreen.class.getResource("/img/doctor.jpg")));

					pilotSelect.setBounds(60, y,100, 90);
					panel.add(pilotSelect);

					
					crewInfo = new JLabel("Name:" + crew.getName());
					crewInfo.setForeground(Color.RED);

					crewInfo.setBounds(170, y, 123, 30);
					panel.add(crewInfo);
					y += 110;
				} else if(crew.getType() == "scavenger") {	
					JButton pilotSelect = new JButton("scavenger");
					pilotSelect.setIcon(new ImageIcon(SetupGameScreen.class.getResource("/img/scavenger.jpg")));

					pilotSelect.setBounds(60, y,100, 90);
					panel.add(pilotSelect);
	
					
					crewInfo = new JLabel("Name:" + crew.getName());
					crewInfo.setForeground(Color.RED);

					crewInfo.setBounds(170, y, 123, 30);
					panel.add(crewInfo);
					y += 110;
				} else if(crew.getType() == "mercenary") {	
					JButton pilotSelect = new JButton("mercenary");
					pilotSelect.setIcon(new ImageIcon(SetupGameScreen.class.getResource("/img/mercenary.jpg")));
					pilotSelect.setBounds(60, y,100, 90);
					panel.add(pilotSelect);
		
					
					crewInfo = new JLabel("Name:" + crew.getName());
					crewInfo.setForeground(Color.RED);

					crewInfo.setBounds(170, y, 123, 30);
					panel.add(crewInfo);
					y += 110;
				} else if(crew.getType() == "mechanician") {	
					JButton pilotSelect = new JButton("mechanician");
					pilotSelect.setIcon(new ImageIcon(SetupGameScreen.class.getResource("/img/mechanicial.jpg")));

					pilotSelect.setBounds(60, y,100, 90);
					panel.add(pilotSelect);
		
					crewInfo = new JLabel("Name:" + crew.getName());
					crewInfo.setForeground(Color.RED);
					crewInfo.setBounds(170, y, 123, 30);
					panel.add(crewInfo);
					y += 110;
				} 
			}
		panel.validate();
		panel.repaint();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setupGame =new JFrame();
		setupGame.setTitle("Setup game");
		setupGame.getContentPane().setBackground(Color.GRAY);
		setupGame.setBounds(100, 100, 1000, 700);
		setupGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupGame.getContentPane().setLayout(null);
		
		JTextArea storyLine = new JTextArea("The scientist have just found that there are other planets apart from earth and wants to discover if we can live in it. Because of your \n" + 
				"outstanding dedication to the research program, you have been appointed to build a crew to explore the new found planets. On the way to \n" + 
				"your first planet, you just found out that someone have already went ahead of you to explore the space and they destroyed the transporter\n" + 
				" parts. Your new mission now is to find these parts to go back to the earth");
		storyLine.setBounds(25, 12, 948, 138);
		setupGame.getContentPane().add(storyLine);
		
		JLabel daysToPlay = new JLabel("Days to play");
		daysToPlay.setForeground(Color.RED);
		daysToPlay.setBounds(25, 162, 100, 35);
		setupGame.getContentPane().add(daysToPlay);
		
		JLabel day = new JLabel(Integer.toString(days));
		day.setForeground(Color.RED);
		day.setBounds(201, 162, 30, 35);
		setupGame.getContentPane().add(day);
		
		JButton minusOne = new JButton("-");
		minusOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				days -= 1;
				if(days < 3) {
					days = 3;
				}
				day.setText(Integer.toString(days));
			}
		});
		minusOne.setBounds(143, 162, 44, 35);
		setupGame.getContentPane().add(minusOne);
		
		JButton plusOne = new JButton("+");
		plusOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  days += 1;
					if(days > 10) {
						days = 10;
					}
					day.setText(Integer.toString(days));
			}
		});
		plusOne.setBounds(227, 162, 44, 35);
		setupGame.getContentPane().add(plusOne);
		
		JLabel setCrewName = new JLabel("Crew name");
		setCrewName.setForeground(Color.RED);
		setCrewName.setBackground(Color.WHITE);
		setCrewName.setBounds(25, 218, 100, 35);
		setupGame.getContentPane().add(setCrewName);
		
		JLabel setSpaceshipName = new JLabel("Spaceship");
		setSpaceshipName.setForeground(Color.RED);
		setSpaceshipName.setBounds(25, 276, 100, 35);
		setupGame.getContentPane().add(setSpaceshipName);
		
		crewNameInput = new JTextField("");
		crewNameInput.setBounds(147, 226, 196, 35);
		setupGame.getContentPane().add(crewNameInput);
		crewNameInput.setColumns(10);
		
		spaceshipNameInput = new JTextField("");
		spaceshipNameInput.setBounds(147, 276, 196, 35);
		setupGame.getContentPane().add(spaceshipNameInput);
		spaceshipNameInput.setColumns(10);
		
		JButton pilotSelect = new JButton("Pilot");
		pilotSelect.setIcon(new ImageIcon(SetupGameScreen.class.getResource("/img/pilot.jpg")));
		pilotSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
				if(crewNumber < 4) {
					manager.launchNameInputScreen(1, "Pilot: 80HP, 20Repair, 15search", "Can decrease the damage from asteroid belt.");
				} else {
					manager.launchAlertScreen(1);
				}
			}
		});
		pilotSelect.setBounds(124, 353, 100, 90);
		setupGame.getContentPane().add(pilotSelect);
		
		JButton assiPilotselect = new JButton("Assistant pilot");
		assiPilotselect.setIcon(new ImageIcon(SetupGameScreen.class.getResource("/img/assistant pilot.jpg")));
		assiPilotselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(crewNumber < 4) {
					manager.launchNameInputScreen(2, "Assistant Pilot: 80HP, 20Repair, 15search", "Having pilot and assistant pilot has a higher chance of avoiding asteroid belt.");
				} else {
					manager.launchAlertScreen(1);
				}
			}
		});
		assiPilotselect.setBounds(350, 353, 100, 90);
		setupGame.getContentPane().add(assiPilotselect);
		
		JButton mechanicianSelect = new JButton("mech");
		mechanicianSelect.setIcon(new ImageIcon(SetupGameScreen.class.getResource("/img/mechanicial.jpg")));
		mechanicianSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
 
				if(crewNumber < 4) {
				manager.launchNameInputScreen(6, "Mechanician: 80HP, 100Repair, 20search", " Repairs the Spaceship's Shield level by great amount.");
				} else {
					manager.launchAlertScreen(1);
				}
			}
		});
		mechanicianSelect.setBounds(124, 455, 100, 90);
		setupGame.getContentPane().add(mechanicianSelect);
		
		JButton scavenger = new JButton("scavenger");
		scavenger.setIcon(new ImageIcon(SetupGameScreen.class.getResource("/img/scavenger.jpg")));
		scavenger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
 
				if(crewNumber < 4) {
					manager.launchNameInputScreen(4,"Scavenger: 90HP, 30Repair, 50search",  "Has a higher chance of finding an item or a transporter part.");
				} else {
					manager.launchAlertScreen(1);
				}
			}
		});
		scavenger.setBounds(350, 455, 100, 90);
		setupGame.getContentPane().add(scavenger);
		
		JButton doctor = new JButton("doctor");
		doctor.setIcon(new ImageIcon(SetupGameScreen.class.getResource("/img/doctor.jpg")));
		doctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
 
				if(crewNumber < 4) {
				manager.launchNameInputScreen(3, "Doctor: 100HP, 5Repair, 5search", "Can boost healing item for the crew members.");
				} else {
					manager.launchAlertScreen(1);
				}
			}
		});
		doctor.setBounds(124, 565, 100, 90);
		setupGame.getContentPane().add(doctor);

		JButton mercenary = new JButton("mercenary");
		mercenary.setIcon(new ImageIcon(SetupGameScreen.class.getResource("/img/mercenary.jpg")));
		mercenary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
 
				if(crewNumber < 4) {
					manager.launchNameInputScreen(5, "Mercenary: 100HP, 5Repair, 5search", "Has higher chance of getting the item back from Alien pirates.");
				} else {
					manager.launchAlertScreen(1);
				}
			}
		});
		mercenary.setBounds(350, 565, 100, 90);
		setupGame.getContentPane().add(mercenary);
		
		JLabel pilotLabel = new JLabel("Pilot");
		pilotLabel.setForeground(Color.RED);
		pilotLabel.setBounds(25, 391, 66, 15);
		setupGame.getContentPane().add(pilotLabel);
		
		JLabel APLabel = new JLabel("Assistant pilot");
		APLabel.setForeground(Color.RED);
		APLabel.setBounds(242, 391, 101, 15);
		setupGame.getContentPane().add(APLabel);
		
		JLabel mechLabel_1 = new JLabel("Mechenician");
		mechLabel_1.setForeground(Color.RED);
		mechLabel_1.setBounds(12, 493, 113, 15);
		setupGame.getContentPane().add(mechLabel_1);
		
		JLabel scavengerLabel = new JLabel("Scavenger");
		scavengerLabel.setForeground(Color.RED);
		scavengerLabel.setBounds(242, 493, 109, 15);
		setupGame.getContentPane().add(scavengerLabel);
		
		JLabel doctorLabel = new JLabel("Doctor");
		doctorLabel.setForeground(Color.RED);
		doctorLabel.setBounds(25, 603, 66, 15);
		setupGame.getContentPane().add(doctorLabel);
		
		JLabel mercenaryLabel = new JLabel("Mercenary");
		mercenaryLabel.setForeground(Color.RED);
		mercenaryLabel.setBounds(242, 603, 90, 15);
		setupGame.getContentPane().add(mercenaryLabel);
		panel.setBackground(Color.DARK_GRAY);
		
		 
		panel.setBounds(504, 209, 327, 463);
		setupGame.getContentPane().add(panel);
		panel.setLayout(null);
		
		

		JButton resetCrew = new JButton("Reset crew member");
		resetCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crewNumber = 0;
				Crew.resetCrew();
				displayButton();
				System.out.println(Crew.getCrew());
			}
		});
		resetCrew.setBounds(556, 162, 214, 25);
		setupGame.getContentPane().add(resetCrew);
		
		JButton starJourrney = new JButton("Set off!");
		starJourrney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(crewNumber < 2) {
					manager.launchAlertScreen(2);
				}  else {
					GameEnvironment.initOutPost();
					GameEnvironment.setDaysToPlay(days);
					GameEnvironment.setPartsRequired();
					Crew.setShipName(spaceshipNameInput.getText());
					Crew.setName(crewNameInput.getText());
					manager.launchAlertScreen(4);
				}
			}
		});
		starJourrney.setBounds(860, 603, 113, 36);
		setupGame.getContentPane().add(starJourrney);
		
		JLabel background = new JLabel();
		background.setIcon(new ImageIcon(SetupGameScreen.class.getResource("/img/background.jpg")));
		background.setBounds(0, 0, 1000, 672);
		setupGame.getContentPane().add(background);
	}
}

package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import game.Crew;
import game.CrewMember;
import game.GameEnvironment;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class GameScreen {

	private JFrame game;
	private GameManager manager;
	private static JPanel crewPanel = new JPanel();
	private static CrewMember crewPoint;
	private static Random rand = new Random();

	
	public GameScreen(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		game.setVisible(true);
	}
	
	public void closeWindow() {
		game.dispose();
	}
	
	public void finishedWindow() {
		manager.closeGameScreen(this);
	}

	public static CrewMember getCrewMember() {
		return crewPoint;
	}
	
	public static void displayInfo() {
		crewPanel.removeAll();
		crewPanel.validate();
		crewPanel.repaint();
		int x = 20; 
		for(CrewMember crew: Crew.getCrew()) {
			if(crew.getType() == "pilot") {
					float hpPercentage = (((float)crew.getHealth() / (float)crew.getMaxHealth()) * 100);
					float hgPercentage = (((float)crew.getHunger() / 100) * 100);
					float tnPercentage = (((float)crew.getTiredness() / 100) * 100);
				
					JLabel crewName = new JLabel();
					crewName.setText(crew.getName());
					crewName.setBounds(x, 0, 100, 10);
					crewPanel.add(crewName);
					
					JButton crewMember = new JButton(crew.getType());
					crewMember.setIcon(new ImageIcon(SetupGameScreen.class.getResource("/img/pilot.jpg")));

					crewMember.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							crewPoint = crew;
						}
					});
					crewMember.setBounds(x, 20, 100, 90);
					crewPanel.add(crewMember);
					
					JButton HP = new JButton(Integer.toString(crew.getHealth()));
					HP.setBackground(Color.GREEN);
					HP.setBounds(x, 122, Math.round(hpPercentage), 10);
					crewPanel.add(HP);
					
					JButton hunger = new JButton(Integer.toString(crew.getHunger()));
					hunger.setBackground(Color.RED);
					hunger.setBounds(x, 138, Math.round(hgPercentage), 10);
					crewPanel.add(hunger);
					
					JButton tiredNess = new JButton(Integer.toString(crew.getTiredness()));
					tiredNess.setBackground(Color.BLUE);
					tiredNess.setBounds(x, 152, Math.round(tnPercentage), 10);
					crewPanel.add(tiredNess);
					
					JLabel Action = new JLabel("Action: " + crew.getActionNumber());
					Action.setBounds(x, 168, 100, 20);
					crewPanel.add(Action);
					x += 120;
				} else if(crew.getType() == "assistant pilot") {	
		
					float hpPercentage = (((float)crew.getHealth() / (float)crew.getMaxHealth()) * 100);
					float hgPercentage = (((float)crew.getHunger() / 100) * 100);
					float tnPercentage = (((float)crew.getTiredness() / 100) * 100);
				
					JLabel crewName = new JLabel();
					crewName.setText(crew.getName());
					crewName.setBounds(x, 0, 100, 10);
					crewPanel.add(crewName);
					
					JButton crewMember = new JButton(crew.getType());
					crewMember.setIcon(new ImageIcon(GameScreen.class.getResource("/img/assistant pilot.jpg")));

					crewMember.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							crewPoint = crew;
						}
					});
					crewMember.setBounds(x, 20, 100, 90);
					crewPanel.add(crewMember);
					
					JButton HP = new JButton(Integer.toString(crew.getHealth()));
					HP.setBackground(Color.GREEN);
					HP.setBounds(x, 122, Math.round(hpPercentage), 10);
					crewPanel.add(HP);
					
					JButton hunger = new JButton(Integer.toString(crew.getHunger()));
					hunger.setBackground(Color.RED);
					hunger.setBounds(x, 138, Math.round(hgPercentage), 10);
					crewPanel.add(hunger);
					
					JButton tiredNess = new JButton(Integer.toString(crew.getTiredness()));
					tiredNess.setBackground(Color.BLUE);
					tiredNess.setBounds(x, 152, Math.round(tnPercentage), 10);
					crewPanel.add(tiredNess);
					
					JLabel Action = new JLabel("Action: " + crew.getActionNumber());
					Action.setBounds(x, 168, 100, 20);
					crewPanel.add(Action);
					x += 120;
			} else if(crew.getType() == "doctor") {	
		
					float hpPercentage = (((float)crew.getHealth() / (float)crew.getMaxHealth()) * 100);
					float hgPercentage = (((float)crew.getHunger() / 100) * 100);
					float tnPercentage = (((float)crew.getTiredness() / 100) * 100);
				
					JLabel crewName = new JLabel();
					crewName.setText(crew.getName());
					crewName.setBounds(x, 0, 100, 10);
					crewPanel.add(crewName);
					
					JButton crewMember = new JButton(crew.getType());
					crewMember.setIcon(new ImageIcon(GameScreen.class.getResource("/img/doctor.jpg")));

					crewMember.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							crewPoint = crew;
						}
					});
					crewMember.setBounds(x, 20, 100, 90);
					crewPanel.add(crewMember);
					
					JButton HP = new JButton(Integer.toString(crew.getHealth()));
					HP.setBackground(Color.GREEN);
					HP.setBounds(x, 122, Math.round(hpPercentage), 10);
					crewPanel.add(HP);
					
					JButton hunger = new JButton(Integer.toString(crew.getHunger()));
					hunger.setBackground(Color.RED);
					hunger.setBounds(x, 138, Math.round(hgPercentage), 10);
					crewPanel.add(hunger);
					
					JButton tiredNess = new JButton(Integer.toString(crew.getTiredness()));
					tiredNess.setBackground(Color.BLUE);
					tiredNess.setBounds(x, 152, Math.round(tnPercentage), 10);
					crewPanel.add(tiredNess);
					
					JLabel Action = new JLabel("Action: " + crew.getActionNumber());
					Action.setBounds(x, 168, 100, 20);
					crewPanel.add(Action);
					x += 120;
			} else if(crew.getType() == "scavenger") {	
		
				float hpPercentage = (((float)crew.getHealth() / (float)crew.getMaxHealth()) * 100);
				float hgPercentage = (((float)crew.getHunger() / 100) * 100);
				float tnPercentage = (((float)crew.getTiredness() / 100) * 100);
			
				JLabel crewName = new JLabel();
				crewName.setText(crew.getName());
				crewName.setBounds(x, 0, 100, 10);
				crewPanel.add(crewName);
				
				JButton crewMember = new JButton(crew.getType());
				crewMember.setIcon(new ImageIcon(GameScreen.class.getResource("/img/scavenger.jpg")));

				crewMember.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						crewPoint = crew;
					}
				});
				crewMember.setBounds(x, 20, 100, 90);
				crewPanel.add(crewMember);
				
				JButton HP = new JButton(Integer.toString(crew.getHealth()));
				HP.setBackground(Color.GREEN);
				HP.setBounds(x, 122, Math.round(hpPercentage), 10);
				crewPanel.add(HP);
				
				JButton hunger = new JButton(Integer.toString(crew.getHunger()));
				hunger.setBackground(Color.RED);
				hunger.setBounds(x, 138, Math.round(hgPercentage), 10);
				crewPanel.add(hunger);
				
				JButton tiredNess = new JButton(Integer.toString(crew.getTiredness()));
				tiredNess.setBackground(Color.BLUE);
				tiredNess.setBounds(x, 152, Math.round(tnPercentage), 10);
				crewPanel.add(tiredNess);
				
				JLabel Action = new JLabel("Action: " + crew.getActionNumber());
				Action.setBounds(x, 168, 100, 20);
				crewPanel.add(Action);
				x += 120;
			} else if(crew.getType() == "mercenary") {	
		
				float hpPercentage = (((float)crew.getHealth() / (float)crew.getMaxHealth()) * 100);
				float hgPercentage = (((float)crew.getHunger() / 100) * 100);
				float tnPercentage = (((float)crew.getTiredness() / 100) * 100);
			
				JLabel crewName = new JLabel();
				crewName.setText(crew.getName());
				crewName.setBounds(x, 0, 100, 10);
				crewPanel.add(crewName);
				
				JButton crewMember = new JButton(crew.getType());
				crewMember.setIcon(new ImageIcon(GameScreen.class.getResource("/img/mercenary.jpg")));

				crewMember.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						crewPoint = crew;
					}
				});
				crewMember.setBounds(x, 20, 100, 90);
				crewPanel.add(crewMember);
				
				JButton HP = new JButton(Integer.toString(crew.getHealth()));
				HP.setBackground(Color.GREEN);
				HP.setBounds(x, 122, Math.round(hpPercentage), 10);
				crewPanel.add(HP);
				
				JButton hunger = new JButton(Integer.toString(crew.getHunger()));
				hunger.setBackground(Color.RED);
				hunger.setBounds(x, 138, Math.round(hgPercentage), 10);
				crewPanel.add(hunger);
				
				JButton tiredNess = new JButton(Integer.toString(crew.getTiredness()));
				tiredNess.setBackground(Color.BLUE);
				tiredNess.setBounds(x, 152, Math.round(tnPercentage), 10);
				crewPanel.add(tiredNess);
				
				JLabel Action = new JLabel("Action: " + crew.getActionNumber());
				Action.setBounds(x, 168, 100, 20);
				crewPanel.add(Action);
				x += 120;
			} else if(crew.getType() == "mechanician") {	
		
				float hpPercentage = (((float)crew.getHealth() / (float)crew.getMaxHealth()) * 100);
				float hgPercentage = (((float)crew.getHunger() / 100) * 100);
				float tnPercentage = (((float)crew.getTiredness() / 100) * 100);
			
				JLabel crewName = new JLabel();
				crewName.setText(crew.getName());
				crewName.setBounds(x, 0, 100, 10);
				crewPanel.add(crewName);
				
				JButton crewMember = new JButton(crew.getType());
				crewMember.setIcon(new ImageIcon(GameScreen.class.getResource("/img/mechanicial.jpg")));
				crewMember.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						crewPoint = crew;
					}
				});
				crewMember.setBounds(x, 20, 100, 90);
				crewPanel.add(crewMember);
				
				JButton HP = new JButton(Integer.toString(crew.getHealth()));
				HP.setBackground(Color.GREEN);
				HP.setBounds(x, 122, Math.round(hpPercentage), 10);
				crewPanel.add(HP);
				
				JButton hunger = new JButton(Integer.toString(crew.getHunger()));
				hunger.setBackground(Color.RED);
				hunger.setBounds(x, 138, Math.round(hgPercentage), 10);
				crewPanel.add(hunger);
				
				JButton tiredNess = new JButton(Integer.toString(crew.getTiredness()));
				tiredNess.setBackground(Color.BLUE);
				tiredNess.setBounds(x, 152, Math.round(tnPercentage), 10);
				crewPanel.add(tiredNess);
				
				JLabel Action = new JLabel("Action: " + crew.getActionNumber());
				Action.setBounds(x, 168, 100, 20);
				crewPanel.add(Action);
				x += 120;
				}
		
		}
		float shpPercentage = (((float)Crew.getShieldLevel() / 1000) * 100);
		JButton spaceship = new JButton("spaceship");
		spaceship.setIcon(new ImageIcon(GameScreen.class.getResource("/img/spaceship.png")));

		spaceship.setBounds(764, 45, 100, 90);
		crewPanel.add(spaceship);
		
		JLabel shipName = new JLabel(Crew.getShipName());
		shipName.setHorizontalAlignment(SwingConstants.CENTER);
		shipName.setBounds(764, 10, 100, 20);
		crewPanel.add(shipName);
		
		JButton sheildLevel = new JButton(Integer.toString(Crew.getShieldLevel()));
		sheildLevel.setBackground(Color.ORANGE);
		sheildLevel.setBounds(764, 147, Math.round(shpPercentage), 25);
		crewPanel.add(sheildLevel);
		
		JLabel transporterPart = new JLabel("Parts been found: " + GameEnvironment.numberOfParts);
		transporterPart.setBounds(555, 44, 175, 36);
		crewPanel.add(transporterPart);
		
		JLabel money = new JLabel("Money: " + Crew.getAmountOfMoney());
		money.setBounds(555, 83, 154, 15);
		crewPanel.add(money);
		
		JLabel CurrentDay = new JLabel("Day: " + GameEnvironment.currentDay);
		CurrentDay.setBounds(555, 26, 66, 15);
		crewPanel.add(CurrentDay);
		
		String crewName = "";
		for(CrewMember crew: Crew.getCrew()) {
			if(crew.sickCheck()) {
				crewName += " " + crew.getName();
			}
		}
			JLabel Sick = new JLabel("Sick: " + crewName);
			Sick.setBounds(502, 110, 269, 15);
			crewPanel.add(Sick);
			
		
		

		crewPanel.validate();
		crewPanel.repaint();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		game = new JFrame();
		game.setTitle(Crew.getName());
		game.getContentPane().setBackground(Color.GRAY);
		game.getContentPane().setLayout(null);
		game.setBounds(100, 100, 1000, 700);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		crewPanel.setBounds(34, 433, 924, 203);
		game.getContentPane().add(crewPanel);
		crewPanel.setLayout(null);

		displayInfo();

		
		JButton sleep = new JButton("Sleep");
		sleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(crewPoint == null) {
					manager.launchAlertScreen(7);
				} else if(crewPoint.getActionNumber() == 0) {
					manager.launchAlertScreen(8);
				}
				else if(crewPoint.sleep()) {
					displayInfo();
					manager.launchAlertScreen(5);
				} else {
					manager.launchAlertScreen(6);
				}
				
			}
		});
		sleep.setBounds(73, 132, 150, 25);
		game.getContentPane().add(sleep);
		
		JLabel Action = new JLabel("Action");
		Action.setBounds(105, 33, 66, 15);
		game.getContentPane().add(Action);
		
		JButton repair = new JButton("Repair spaceship");
		repair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(crewPoint == null) {
					manager.launchAlertScreen(7);
				} else if(crewPoint.getActionNumber() == 0) {
					manager.launchAlertScreen(8);
				} else if(crewPoint.getTiredness() == 100) {
					manager.launchAlertScreen(12);
				} else if(crewPoint.repairTheShieldsOfSpaceship()) {
					displayInfo();
					manager.launchAlertScreen(9);
				} else {
					manager.launchAlertScreen(10);
				}
				
				
			}
		});
		repair.setBounds(73, 169, 150, 25);
		game.getContentPane().add(repair);
		
		JButton scavenge = new JButton("Scavenge");
		scavenge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(crewPoint == null) {
					manager.launchAlertScreen(7);
				} else if(crewPoint.getActionNumber() == 0) {
					manager.launchAlertScreen(8);
				} else if(crewPoint.getTiredness() == 100) {
					manager.launchAlertScreen(12);
				} else if(GameEnvironment.searched == true) {
					manager.launchAlertScreen(11);
				} else {
					GameEnvironment.searched = true;
					if(crewPoint.searchTransporterPartsForGui()) {
						manager.launchAlertScreen(13);
					} else {
						manager.launchAlertScreen(14);
					}
					if(crewPoint.searchItem()) {
						manager.launchAlertScreen(15);
				}
				displayInfo();
				}
				
			}
		});
		scavenge.setBounds(73, 206, 150, 25);
		game.getContentPane().add(scavenge);
		
		JButton outPost = new JButton("Outost");
		outPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.launchOutpostScreen();
			}
		});
		outPost.setBounds(73, 332, 150, 25);
		game.getContentPane().add(outPost);
		
		JButton Eat = new JButton("Eat");
		Eat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(crewPoint == null) {
					manager.launchAlertScreen(7);
				} else if(crewPoint.getActionNumber() == 0) {
					manager.launchAlertScreen(8);
				} else if(crewPoint.getTiredness() == 100) {
					manager.launchAlertScreen(12);
				} else {
					manager.launchEatingScreen(crewPoint);
				}
			}
		});
		Eat.setBounds(74, 60, 149, 25);
		game.getContentPane().add(Eat);
		
		JButton Heal = new JButton("Heal");
		Heal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(crewPoint == null) {
					manager.launchAlertScreen(7);
				} else if(crewPoint.getActionNumber() == 0) {
					manager.launchAlertScreen(8);
				} else if(crewPoint.getTiredness() == 100) {
					manager.launchAlertScreen(12);
				} else {
					manager.launchHealingScreen(crewPoint);
				}
			}
		});
		Heal.setBounds(73, 95, 150, 25);
		game.getContentPane().add(Heal);
		
		JButton nextDay = new JButton("Next day");
		nextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(GameEnvironment.numberOfParts >= GameEnvironment.partsRequired) {
					manager.launchEndingScreen(1);
					finishedWindow();
				}
				GameEnvironment.currentDay += 1;
				if(GameEnvironment.currentDay > GameEnvironment.daysToPlay) {
					manager.launchEndingScreen(2);
					finishedWindow();
				}
				int eventGenerator = rand.nextInt(100) + 1;
				if(eventGenerator <= 40) {
					int eventDecider = rand.nextInt(2);
					if(eventDecider == 0) {
						GameEnvironment.pirate();
						if(Crew.getFoods().size() == 0 && Crew.getMedicalItems().size() == 0) {
							manager.launchAlertScreen(31);
						} else {
						manager.launchAlertScreen(21);;
						}
					} else {
						GameEnvironment.plague();
						manager.launchAlertScreen(22);
					}
				}
				GameEnvironment.initOutPost();
				GameEnvironment.resetActionNumber();
				GameEnvironment.plagueDamage();
				GameEnvironment.dailyDamage();
				if(Crew.getCrew().size() == 0) {
					manager.launchEndingScreen(3);
					finishedWindow();
				}
				displayInfo();
			}
		});
		nextDay.setBounds(73, 365, 150, 25);
		game.getContentPane().add(nextDay);
		
		JLabel bigrocket = new JLabel("New label");
		
		bigrocket.setBounds(439, 33, 409, 317);
		game.getContentPane().add(bigrocket);
		bigrocket.setIcon(new ImageIcon(GameScreen.class.getResource("/img/spaceship(large).jpg")));
		JButton ToOtherPlane = new JButton("Next planet");
		ToOtherPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Crew.getCrew().size() < 2) {
					manager.launchAlertScreen(23);
				} else {
					manager.launchPilotScreen();
					if(Crew.getShieldLevel() <= 0) {
						manager.launchEndingScreen(3);

					}
				}
			}
		});
		ToOtherPlane.setBounds(73, 243, 150, 25);
		game.getContentPane().add(ToOtherPlane);
		
		
		
	}
}

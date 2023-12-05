package Gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

import game.Crew;
import game.CrewMember;
import game.GameEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pilot {

	private JFrame pilot;
	private GameManager manager;
	JPanel panel = new JPanel();
	private CrewMember pilot1;
	private CrewMember pilot2;
	private int order = 0;
	private static Random rand = new Random();
	boolean flag = false;
	private int number = 0;
	private JButton back;

	/**
	 * Create the application.
	 */
	public Pilot(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		pilot.setVisible(true);
	}
	
	public void closeWindow() {
		pilot.dispose();
	}
	
	public void finishedWindow() {
		manager.closePilotScreen(this);
	}
	
	public void display() {
		panel.removeAll();
		panel.validate();
		panel.repaint();
		System.out.println(Crew.getCrew());
		System.out.println(1);
		

		int x = 50;


		for(CrewMember crew: Crew.getCrew()) {
			System.out.println(1);

			if(crew.getType() == "pilot") {
				JButton pilotmember = new JButton("pilot");
				pilotmember.setIcon(new ImageIcon(Pilot.class.getResource("/img/pilot.jpg")));

				pilotmember.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(crew != pilot1 && crew != pilot2) {
							if(order == 0 ) {
								pilot1 = crew;
								order += 1;
							} else {
								pilot2 = crew;
								order -= 1;
							}
					}
						if(number != 2) {
							number += 1;
						} else {
							flag = true;
						}
				}
					}
				);
				pilotmember.setBounds(x, 99, 100, 90);
				panel.add(pilotmember);
				x += 110;
			} else if(crew.getType() == "assistant pilot") {
				JButton pilotmember = new JButton("assistan pilot");
				pilotmember.setIcon(new ImageIcon(Pilot.class.getResource("/img/assistant pilot.jpg")));

				pilotmember.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(crew != pilot1 && crew != pilot2) {
							if(order == 0 ) {
								pilot1 = crew;
								order += 1;
							} else {
								pilot2 = crew;
								order -= 1;
							}
							
					}
						if(number != 2) {
							number += 1;
						} else {
							flag = true;
						}
				}
					}
				);
				pilotmember.setBounds(x, 99, 100, 90);
				panel.add(pilotmember);
				x += 110;
			} else if(crew.getType() == "doctor") {
				JButton pilotmember = new JButton("doctor");
				pilotmember.setIcon(new ImageIcon(Pilot.class.getResource("/img/doctor.jpg")));

				pilotmember.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(crew != pilot1 && crew != pilot2) {
							if(order == 0 ) {
								pilot1 = crew;
								order += 1;
							} else {
								pilot2 = crew;
								order -= 1;
							}
					}
						if(number != 2) {
							number += 1;
						} else {
							flag = true;
						}
				}
					}
				);
				pilotmember.setBounds(x, 99, 100, 90);
				panel.add(pilotmember);
				x += 110;
			} else if(crew.getType() == "mercenary") {
				JButton pilotmember = new JButton("mercenary");
				pilotmember.setIcon(new ImageIcon(Pilot.class.getResource("/img/mercenary.jpg")));
				pilotmember.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(crew != pilot1 && crew != pilot2) {
							if(order == 0 ) {
								pilot1 = crew;
								order += 1;
							} else {
								pilot2 = crew;
								order -= 1;
							}
					}
						if(number != 2) {
							number += 1;
						} else {
							flag = true;
						}
				}
					}
				);
				pilotmember.setBounds(x, 99, 100, 90);
				panel.add(pilotmember);
				x += 110;
			} else if(crew.getType() == "scavenger") {
				JButton pilotmember = new JButton("scavenger");
				pilotmember.setIcon(new ImageIcon(Pilot.class.getResource("/img/scavenger.jpg")));

				pilotmember.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(crew != pilot1 && crew != pilot2) {
							if(order == 0 ) {
								pilot1 = crew;
								order += 1;
							} else {
								pilot2 = crew;
								order -= 1;
							}
					}
						if(number != 2) {
							number += 1;
						} else {
							flag = true;
						}
				}
					}
				);
				pilotmember.setBounds(x, 99, 100, 90);
				panel.add(pilotmember);
				x += 110;
			} else if(crew.getType() == "mechanician") {
				JButton pilotmember = new JButton("mechanician");
				pilotmember.setIcon(new ImageIcon(Pilot.class.getResource("/img/smercenary.jpg")));

				pilotmember.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(crew != pilot1 && crew != pilot2) {
						if(order == 0 ) {
							pilot1 = crew;
							order += 1;
						} else {
							pilot2 = crew;
							order -= 1;
						}
				}
						if(number != 2) {
							number += 1;
						} else {
							flag = true;
						}}
					}
				);
				pilotmember.setBounds(x, 99, 100, 90);
				panel.add(pilotmember);
				x += 110;
			} 
			
			
		}

		
		panel.validate();
		panel.repaint();
	}
	
	public boolean astriodBelt() {
			int possible = rand.nextInt(100) + 1;
			int likeHood = 50;
			float initAstroidBeltDam = 150;

			if((pilot1.getType() == "pilot" && pilot2.getType() == "assistant pilot")
					|| (pilot2.getType() == "assistant pilot" && pilot2.getType() == "pilot")) {
				likeHood = 20;
				manager.launchAlertScreen(28);
				System.out.println("We have professional pilot and assistant pilot, they will help us avoid astroid belt!");
			}		
			
			if(possible <= likeHood) {
				float realDamageAB = (initAstroidBeltDam * (2 - ((float) Crew.getShieldLevel() / 1000)));
				if(pilot1.getType() == "pilot" || pilot2.getType() == "pilot") {
					manager.launchAlertScreen(28);
					System.out.printf("We went through an astroid belt during the flight to next planet\n");
					realDamageAB -= 40;
					System.out.println("Our pilot tried to avoid damage from astorid belt. (Damage reduced 40)");
				} else if(pilot1.getType() == "assistant pilot" || pilot2.getType() == "assistant pilot") {
					System.out.printf("We went through astroid belt during the journey to next planet\n");
					manager.launchAlertScreen(29);
					realDamageAB -= 20;
					System.out.println("Our assistant pilot tried to avoid damage from astorid belt. (Damage reduced 20)");
				} else {
					manager.launchAlertScreen(30);

					System.out.printf("We went through an astroid belt during the flight to next planet.\n");
				}
				
				Crew.minusShipLevel(Math.round(realDamageAB));
				return true;
			} else {
				manager.launchAlertScreen(27);

				return false;
			}
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pilot = new JFrame();
		pilot.getContentPane().setBackground(Color.GRAY);
		pilot.setBounds(100, 100, 800, 400);
		pilot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pilot.getContentPane().setLayout(null);
		
		
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 788, 240);
		pilot.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton Go = new JButton("Go");
		Go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!flag) {
					manager.launchAlertScreen(32);
				} else if(pilot1.getActionNumber() == 0 || pilot2.getActionNumber() == 0 || pilot2.getTiredness() == 100 || pilot1.getTiredness() == 100) {
					manager.launchAlertScreen(24);
				} else {
					pilot1.minusActionNumber();
					pilot2.minusActionNumber();
					GameEnvironment.searched = false;
					GameEnvironment.initOutPost();

					astriodBelt();
					finishedWindow();
					GameScreen.displayInfo();
				}
			}
		});
		Go.setBounds(605, 301, 114, 25);
		pilot.getContentPane().add(Go);
		
		back = new JButton("back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
			}
		});
		back.setBounds(437, 301, 114, 25);
		pilot.getContentPane().add(back);
		
		display();
		
	}
}

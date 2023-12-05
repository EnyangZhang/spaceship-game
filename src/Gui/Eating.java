package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

import game.Crew;
import game.CrewMember;
import game.Food;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Eating {

	private JFrame eating;
	private GameManager manager;
	private CrewMember crew;
	JPanel panel = new JPanel();

	public Eating(GameManager incomingManager,CrewMember comingCrew) {
		crew = comingCrew;
		manager = incomingManager;
		initialize();
		eating.setVisible(true);
	}

	public void closeWindow() {
		eating.dispose();
	}

	public void finishedWindow() {
		manager.closeEatingScreen(this);
	}
	
	public void displayFood() {
		panel.removeAll();
		panel.validate();
		panel.repaint();
		
		JLabel inventory = new JLabel("food:");
		inventory.setBounds(24, 24, 66, 15);
		panel.add(inventory);
		
		int x = 30;
		int y = 60;
		for(Food food: Crew.getFoods()) {
			
			JButton foodInventory = new JButton(food.getName());
			if(food.getName()=="candy") {
				foodInventory.setIcon(new ImageIcon(Eating.class.getResource("/img/candy(small).png")));
			} else if(food.getName()=="apple") {
				foodInventory.setIcon(new ImageIcon(Eating.class.getResource("/img/apple(small).png")));
			} else if(food.getName()=="sandwich") {
				foodInventory.setIcon(new ImageIcon(Eating.class.getResource("/img/sandwich(small).png")));
			}else if(food.getName()=="pizza") {
				foodInventory.setIcon(new ImageIcon(Eating.class.getResource("/img/pizza(small).png")));
			}else if(food.getName()=="fish") {
				foodInventory.setIcon(new ImageIcon(Eating.class.getResource("/img/fish(small).png")));
			}else if(food.getName()=="chichen") {
				foodInventory.setIcon(new ImageIcon(Eating.class.getResource("/img/chichen(small).png")));
			}
			foodInventory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(crew.feed(food)) {
						manager.launchAlertScreen(17);
						displayFood();
						GameScreen.displayInfo();
						
					} else if(crew.getActionNumber() == 0) {
						manager.launchAlertScreen(8);
					} else {
						manager.launchAlertScreen(18);
					}
				}
			});
			foodInventory.setBounds(x, y, 40, 40);
			panel.add(foodInventory);
		
		x += 50;
		
		if(x >= 950) {
			x = 30;
			y += 110;
		}
		}
//		JButton button = new JButton("New button");
//		button.setBounds(910, 60, 40, 40);
//		panel.add(button);
//		
		
		
		panel.validate();
		panel.repaint();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		eating = new JFrame();
		eating.setTitle(GameScreen.getCrewMember().getName());
		eating.getContentPane().setBackground(Color.GRAY);
		eating.getContentPane().setLayout(null);
		eating.setBounds(100, 100, 1000, 460);
		eating.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 988, 378);
		eating.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton Back = new JButton("Back");
		Back.setBounds(786, 405, 114, 25);
		eating.getContentPane().add(Back);
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
				GameScreen.displayInfo();
			}
		});
		
		displayFood();
	}

}

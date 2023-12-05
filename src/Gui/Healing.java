package Gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Crew;
import game.CrewMember;
import game.Food;
import game.MedicalItem;

import java.awt.Color;

public class Healing {

	private JFrame healing;
	private GameManager manager;
	private CrewMember crew;
	JPanel panel = new JPanel();

	public Healing(GameManager incomingManager,CrewMember comingCrew) {
		crew = comingCrew;
		manager = incomingManager;
		initialize();
		healing.setVisible(true);
	}

	public void closeWindow() {
		healing.dispose();
	}

	public void finishedWindow() {
		manager.closeHealingScreen(this);
	}
	
	public void displayMedicine() {
		panel.removeAll();
		panel.validate();
		panel.repaint();
		
		JLabel inventory = new JLabel("Medicine:");
		inventory.setBounds(24, 24, 66, 15);
		panel.add(inventory);
		
		int x = 30;
		int y = 60;
		for(MedicalItem medical: Crew.getMedicalItems()) {
			
			JButton MedicineInventory = new JButton(medical.getName());
			if(medical.getName() == "bandage") {
				MedicineInventory.setIcon(new ImageIcon(Healing.class.getResource("/img/bandage(small).png")));
			}else if(medical.getName() == "medkit") {
				MedicineInventory.setIcon(new ImageIcon(Healing.class.getResource("/img/medkit(small).png")));
			}else if(medical.getName() == "potion") {
				MedicineInventory.setIcon(new ImageIcon(Healing.class.getResource("/img/potion(small).png")));
			}
			MedicineInventory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(crew.applyMedicalItem(medical)) {
						manager.launchAlertScreen(19);
						displayMedicine();
						GameScreen.displayInfo();
						
					} else if(crew.getActionNumber() == 0) {
						manager.launchAlertScreen(8);
					} else {
						manager.launchAlertScreen(20);
					}
				}
			});
			MedicineInventory.setBounds(x, y, 40, 40);
			panel.add(MedicineInventory);
		
		x += 50;
		
		if(x >= 950) {
			x = 30;
			y += 110;
		}
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		healing = new JFrame();
		healing.getContentPane().setBackground(Color.GRAY);
		healing.getContentPane().setLayout(null);
		healing.setBounds(100, 100, 1000, 460);
		healing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 988, 378);
		healing.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JButton Back = new JButton("Back");
		Back.setBounds(786, 405, 114, 25);
		healing.getContentPane().add(Back);
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
				GameScreen.displayInfo();
			}
		});
		displayMedicine();
		
	}

}

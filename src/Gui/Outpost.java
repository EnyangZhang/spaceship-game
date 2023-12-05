package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import game.Crew;
import game.CrewMember;
import game.Food;
import game.GameEnvironment;
import game.Item;
import game.MedicalItem;

import java.awt.Color;

import javax.print.attribute.standard.Finishings;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Outpost {

	private JFrame outpost;
	private GameManager manager;
	private JPanel panel = new JPanel();


	public Outpost(GameManager incomingManager) {
		manager = incomingManager;
		initialize();
		outpost.setVisible(true);
	}

	public void closeWindow() {
		outpost.dispose();
	}

	public void finishedWindow() {
		manager.closeOutpostScreen(this);
	}
	
	public void refresh() {
		panel.removeAll();
		panel.validate();
		panel.repaint();
		JLabel money = new JLabel("Money: " + Crew.getAmountOfMoney());
		money.setBounds(35, 12, 139, 15);
		panel.add(money);
		
		JLabel inventory = new JLabel("Inventory: ");
		inventory.setBounds(452, 12, 84, 15);
		panel.add(inventory);
		
		String foodList = "";
		for(Item item : Crew.getFoods()) {
			foodList += " " + item.getName();
		}		
		JLabel food = new JLabel(foodList);
		food.setBounds(121, 29, 861, 35);
		panel.add(food);
		
		String medicalList = "";
		for(Item item: Crew.getMedicalItems()) {
			medicalList += " " + item.getName();
		}	
		JLabel medicine = new JLabel(medicalList);
		medicine.setBounds(121, 81, 861, 35);
		
		
		
		
		panel.add(medicine);
		
		JButton candy = new JButton("candy");
		candy.setIcon(new ImageIcon(Outpost.class.getResource("/img/candy.png")));
		candy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(Crew.getAmountOfMoney() - GameEnvironment.shop.get(0).getCost() < 0 || GameEnvironment.stock.get(0) -1 < 0) {
				manager.launchAlertScreen(16);
			} else {
				GameEnvironment.stock.set(0,GameEnvironment.stock.get(0) -1);
				Crew.minusMoney(GameEnvironment.shop.get(0));
				Crew.setFoods((Food)GameEnvironment.shop.get(0));
				refresh();
			}
			}
		});
		candy.setBounds(49, 161, 100, 90);
		panel.add(candy);
		
		JButton apple = new JButton("apple");
		apple.setIcon(new ImageIcon(Outpost.class.getResource("/img/apple.png")));
		apple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Crew.getAmountOfMoney() - GameEnvironment.shop.get(1).getCost() < 0 || GameEnvironment.stock.get(1) -1 < 0) {
					manager.launchAlertScreen(16);
				} else {
					GameEnvironment.stock.set(1,GameEnvironment.stock.get(1) -1);
					Crew.minusMoney(GameEnvironment.shop.get(1));
					Crew.setFoods((Food)GameEnvironment.shop.get(1));
					refresh();
				}
			}
		});
		apple.setBounds(211, 161, 100, 90);
		panel.add(apple);
		
		JButton sandwich = new JButton("sandwich");
		sandwich.setIcon(new ImageIcon(Outpost.class.getResource("/img/sandwich.png")));
		sandwich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Crew.getAmountOfMoney() - GameEnvironment.shop.get(2).getCost() < 0 || GameEnvironment.stock.get(2) -1 < 0) {
					manager.launchAlertScreen(16);
				} else {
					GameEnvironment.stock.set(2,GameEnvironment.stock.get(2) -1);
					Crew.minusMoney(GameEnvironment.shop.get(2));
					Crew.setFoods((Food)GameEnvironment.shop.get(2));
					refresh();
				}
			}
		});
		sandwich.setBounds(377, 161, 100, 90);
		panel.add(sandwich);
		
		JButton pizza = new JButton("pizza");
		pizza.setIcon(new ImageIcon(Outpost.class.getResource("/img/pizza.png")));
		pizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Crew.getAmountOfMoney() - GameEnvironment.shop.get(3).getCost() < 0 || GameEnvironment.stock.get(3) -1 < 0) {
					manager.launchAlertScreen(16);
				} else {
					GameEnvironment.stock.set(3,GameEnvironment.stock.get(3) -1);
					Crew.minusMoney(GameEnvironment.shop.get(3));
					Crew.setFoods((Food)GameEnvironment.shop.get(3));
					refresh();
				}
			}
		});
		pizza.setBounds(548, 161, 100, 90);
		panel.add(pizza);
		
		JButton fish = new JButton("fish");
		fish.setIcon(new ImageIcon(Outpost.class.getResource("/img/fish.png")));
		fish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Crew.getAmountOfMoney() - GameEnvironment.shop.get(4).getCost() < 0 || GameEnvironment.stock.get(4) -1 < 0) {
					manager.launchAlertScreen(16);
				} else {
					GameEnvironment.stock.set(4,GameEnvironment.stock.get(4) -1);
					Crew.minusMoney(GameEnvironment.shop.get(4));
					Crew.setFoods((Food)GameEnvironment.shop.get(4));
					refresh();
				}
			}
		});
		fish.setBounds(711, 161, 100, 90);
		panel.add(fish);
		
		JButton chichen = new JButton("chichen");
		chichen.setIcon(new ImageIcon(Outpost.class.getResource("/img/chicken.png")));
		chichen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Crew.getAmountOfMoney() - GameEnvironment.shop.get(5).getCost() < 0 || GameEnvironment.stock.get(5) -1 < 0) {
					manager.launchAlertScreen(16);
				} else {
					GameEnvironment.stock.set(5,GameEnvironment.stock.get(5) -1);
					Crew.minusMoney(GameEnvironment.shop.get(5));
					Crew.setFoods((Food)GameEnvironment.shop.get(5));
					refresh();
				}
			}
		});
		

		JButton bandage = new JButton("bandage");
		bandage.setIcon(new ImageIcon(Outpost.class.getResource("/img/bandage.png")));
		bandage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Crew.getAmountOfMoney() - GameEnvironment.shop.get(6).getCost() < 0 || GameEnvironment.stock.get(6) -1 < 0) {
					manager.launchAlertScreen(16);
				} else {
					GameEnvironment.stock.set(6,GameEnvironment.stock.get(6) -1);
					Crew.minusMoney(GameEnvironment.shop.get(6));
					Crew.setMedicalItems((MedicalItem)GameEnvironment.shop.get(6));
					refresh();
				}
			}
		});
		bandage.setBounds(165, 382, 100, 90);
		panel.add(bandage);
		

		JButton medkit = new JButton("medkit");
		medkit.setIcon(new ImageIcon(Outpost.class.getResource("/img/medkit.png")));
		medkit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Crew.getAmountOfMoney() - GameEnvironment.shop.get(7).getCost() < 0 || GameEnvironment.stock.get(7) -1 < 0) {
					manager.launchAlertScreen(16);
				} else {
					GameEnvironment.stock.set(7,GameEnvironment.stock.get(7) -1);
					Crew.minusMoney(GameEnvironment.shop.get(7));
					Crew.setMedicalItems((MedicalItem)GameEnvironment.shop.get(7));
					refresh();
				}
			}
		});
		medkit.setBounds(436, 382, 100, 90);
		panel.add(medkit);
		

		JButton potion = new JButton("potion");
		potion.setIcon(new ImageIcon(Outpost.class.getResource("/img/potion.png")));
		potion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Crew.getAmountOfMoney() - GameEnvironment.shop.get(8).getCost() < 0 || GameEnvironment.stock.get(8) -1 < 0) {
					manager.launchAlertScreen(16);
				} else {
					GameEnvironment.stock.set(8,GameEnvironment.stock.get(8) -1);
					Crew.minusMoney(GameEnvironment.shop.get(8));
					Crew.setMedicalItems((MedicalItem)GameEnvironment.shop.get(8));
					refresh();
				}
			}
		});
		potion.setBounds(711, 382, 100, 90);
		panel.add(potion);
		

		chichen.setBounds(882, 161, 100, 90);
		panel.add(chichen);
		
		JLabel candyStorage = new JLabel("Storage: " + GameEnvironment.stock.get(0));
		candyStorage.setBounds(49, 277, 107, 21);
		panel.add(candyStorage);
		
		JLabel applestorage = new JLabel("Storage: " + GameEnvironment.stock.get(1));
		applestorage.setBounds(216, 280, 107, 21);
		panel.add(applestorage);
		
		JLabel sandwichStorage = new JLabel("Storage: " + GameEnvironment.stock.get(2));
		sandwichStorage.setBounds(377, 280, 107, 21);
		panel.add(sandwichStorage);
		
		JLabel pizzaStorage = new JLabel("Storage: " + GameEnvironment.stock.get(3));
		pizzaStorage.setBounds(548, 280, 107, 21);
		panel.add(pizzaStorage);
		
		JLabel fishStorage = new JLabel("Storage: " + GameEnvironment.stock.get(4));
		fishStorage.setBounds(711, 280, 107, 21);
		panel.add(fishStorage);
		
		JLabel chickenStorage = new JLabel("Storage: " + GameEnvironment.stock.get(5));
		chickenStorage.setBounds(882, 280, 107, 21);
		panel.add(chickenStorage);
		
		JLabel bandageStorage = new JLabel("Storage: " + GameEnvironment.stock.get(6));
		bandageStorage.setBounds(165, 501, 107, 21);
		panel.add(bandageStorage);
		
		JLabel medkitStorage = new JLabel("Storage: " + GameEnvironment.stock.get(7));
		medkitStorage.setBounds(436, 504, 107, 21);
		panel.add(medkitStorage);
		
		JLabel potionStorage = new JLabel("Storage: " + GameEnvironment.stock.get(8));
		potionStorage.setBounds(711, 504, 107, 21);
		panel.add(potionStorage);
		
		JLabel foodinventory = new JLabel("Food:");
		foodinventory.setBounds(45, 39, 84, 15);
		panel.add(foodinventory);
		
		JLabel medicineStorage = new JLabel("Medicine:");
		medicineStorage.setBounds(45, 92, 84, 15);
		panel.add(medicineStorage);
		
		JLabel candyPrice = new JLabel("Price:  7");
		candyPrice.setBounds(49, 298, 107, 21);
		panel.add(candyPrice);
		
		JLabel candyValue = new JLabel("Hungry:  5");
		candyValue.setHorizontalAlignment(SwingConstants.LEFT);
		candyValue.setBounds(49, 318, 107, 21);
		panel.add(candyValue);
		
		JLabel applePrice = new JLabel("Price:  14");
		applePrice.setBounds(218, 301, 107, 21);
		panel.add(applePrice);
		
		JLabel sandwichPrice = new JLabel("Price:  20");
		sandwichPrice.setBounds(377, 301, 107, 21);
		panel.add(sandwichPrice);
		
		JLabel pizzaPrice = new JLabel("Price:  27");
		pizzaPrice.setBounds(548, 298, 107, 21);
		panel.add(pizzaPrice);
		
		JLabel fishPrice = new JLabel("Price:  33");
		fishPrice.setBounds(711, 301, 107, 21);
		panel.add(fishPrice);
		
		JLabel chickenPrice = new JLabel("Price:  38");
		chickenPrice.setBounds(882, 301, 107, 21);
		panel.add(chickenPrice);
		
		JLabel appleValue = new JLabel("Hungry:  10");
		appleValue.setBounds(211, 318, 107, 21);
		panel.add(appleValue);
		
		JLabel sandwichValue = new JLabel("Hungry:  15");
		sandwichValue.setBounds(377, 321, 107, 21);
		panel.add(sandwichValue);
		
		JLabel pizzaValue = new JLabel("Hungry:  20");
		pizzaValue.setBounds(548, 321, 107, 21);
		panel.add(pizzaValue);
		
		JLabel fishValue = new JLabel("Hungry:  25");
		fishValue.setBounds(711, 321, 107, 21);
		panel.add(fishValue);
		
		JLabel chikenvalue = new JLabel("Hungry:  30");
		chikenvalue.setBounds(882, 321, 107, 21);
		panel.add(chikenvalue);
		
		JLabel bandagePrice = new JLabel("Price:  20");
		bandagePrice.setBounds(165, 527, 107, 21);
		panel.add(bandagePrice);
		
		JLabel bandageValue = new JLabel("health:  10");
		bandageValue.setHorizontalAlignment(SwingConstants.LEFT);
		bandageValue.setBounds(165, 552, 107, 21);
		panel.add(bandageValue);
		
		JLabel medkitPrice = new JLabel("Price:  30");
		medkitPrice.setBounds(436, 527, 107, 21);
		panel.add(medkitPrice);
		
		JLabel lblHealth = new JLabel("health:  20");
		lblHealth.setHorizontalAlignment(SwingConstants.LEFT);
		lblHealth.setBounds(436, 555, 107, 21);
		panel.add(lblHealth);
		
		JLabel potionPrice = new JLabel("Price:  40");
		potionPrice.setBounds(711, 530, 107, 21);
		panel.add(potionPrice);
		
		JLabel lblHealth_1 = new JLabel("health:  30");
		lblHealth_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblHealth_1.setBounds(711, 555, 107, 21);
		panel.add(lblHealth_1);
		
		JLabel functionality = new JLabel("Can heal plague");
		functionality.setBounds(711, 484, 147, 15);
		panel.add(functionality);
		
		
		panel.validate();
		panel.repaint();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		outpost = new JFrame();
		outpost.getContentPane().setBackground(Color.GRAY);
		outpost.setTitle("Outpost");
		outpost.setBounds(100, 100, 1005, 709);
		outpost.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton back = new JButton("Back");
		back.setBounds(847, 605, 114, 25);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GameScreen.displayInfo();
				finishedWindow();
			}
		});
		outpost.getContentPane().setLayout(null);
		outpost.getContentPane().add(back);
		
		
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 1005, 585);
		outpost.getContentPane().add(panel);
		panel.setLayout(null);

		refresh();
	}

}

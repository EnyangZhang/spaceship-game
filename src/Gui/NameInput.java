package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;

import game.Crew;
import game.CrewMember;
import game.GameEnvironment;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NameInput {
	private int type;
	private JFrame nameInput;
	private GameManager manager;
	private JTextField name;
	private String info1;
	private String info2;

	
	public NameInput(GameManager incomingManager, int type, String info1, String info2) {
		this.info1 = info1;
		this.info2 = info2;
		this.type = type;
		manager = incomingManager;
		initialize();
		nameInput.setVisible(true);
	}
	
	public void closeWindow() {
		nameInput.dispose();
	}
	
	public void finishedWindow() {
		manager.closeNameInputScreen(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		nameInput = new JFrame();
		nameInput.getContentPane().setBackground(Color.GRAY);
		nameInput.setBounds(100, 100, 563, 320);
		nameInput.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nameInput.getContentPane().setLayout(null);
		
		name = new JTextField();
		name.setBounds(205, 118, 152, 46);
		nameInput.getContentPane().add(name);
		name.setColumns(10);
		
		JButton nameOkbutton = new JButton("OK");
		nameOkbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean flag = false;
				for(CrewMember crew: Crew.getCrew()) {
					System.out.println(name.getText());
					System.out.println(crew.getName());
					if(GameEnvironment.duplicateNames(name.getText())) {
						manager.launchAlertScreen(3);
						flag = true;
						break;
					} 
				}
				if(!flag) {
					GameEnvironment.createCrew(type, name.getText());
					SetupGameScreen.displayButton();
					SetupGameScreen.addCrewNumber();
					finishedWindow();
				}
				
			}
		});
		nameOkbutton.setBounds(226, 202, 114, 25);
		nameInput.getContentPane().add(nameOkbutton);
		
		JLabel nameLabel = new JLabel("Enter crew name:");
		nameLabel.setBounds(220, 91, 120, 15);
		nameInput.getContentPane().add(nameLabel);
		
		JLabel crewInfo = new JLabel(info1);
		crewInfo.setBounds(12, 0, 539, 25);
		nameInput.getContentPane().add(crewInfo);
		
		JLabel crewInfo2 = new JLabel(info2);
		crewInfo2.setBounds(12, 20, 574, 29);
		nameInput.getContentPane().add(crewInfo2);
	}

}

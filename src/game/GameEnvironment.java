package game;

import java.util.*;

/**
 * @author Hezekiah Dacillo
 * @author Enyang Zhang
 *
 */
public class GameEnvironment {
	//game init
	public static int daysToPlay;
	public static int partsRequired;
	
	//game status and parts
	public static int currentDay = 1;
	public static int numberOfParts = 0;
	
	//shop
	private static Food candy = new Food("candy", 7, 5);
	private static Food apple = new Food("apple", 14, 10);
	private static Food sandwich = new Food("sandwich", 20, 15);
	private static Food pizza = new Food("pizza", 27, 20);
	private static Food fish = new Food("fish", 33, 25);
	private static Food chicken = new Food("chicken", 38, 30);
	private static MedicalItem bandage = new MedicalItem("bandage", 20, 10);
	private static MedicalItem medkit = new MedicalItem("medkit", 30, 20);
	private static MedicalItem potion = new MedicalItem("potion", 40, 30);
	public static ArrayList<Item> shop = new ArrayList<Item>(Arrays.asList(candy,apple,sandwich,pizza,fish,chicken,bandage,medkit,potion));
	public static ArrayList<Integer> stock = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0));

	//menu
	enum MenuState {
		MAIN, ACTION, STATUS, OUTPOST, NEXTDAY,CREWMEMBER, SPACESHIP, FOODSELECTION, ACTCREWSELECTION, MEDICALSELECTION, ACTCREWSELECTIONPILOT, DOCTORSELECTION
	}
	private static MenuState state = MenuState.MAIN;
	private static int selection;
	public static int crewSelection;
	public static int crewSelectionPilot;
	private static int foodSelection;
	private static int medicineSelection;
	private static int doctorSelection;
	private static boolean haveDoctor = false;
	public static boolean haveMercenary = false;
	public static boolean searched = false;

	//reader/scanner, number generator
	private static Scanner reader;
	private static Random rand = new Random();
	
	/**
	 * Adds the number of transporter found
	 */
	public static void addParts() {
		numberOfParts += 1;
	}
	
	/**
	 * Reads the user input as a string 
	 * @return	The string that that user enters
	 */
	public static String userInputS() {
		reader = new Scanner(System.in);
		String s = reader.nextLine();
		return s;
	}
	
	/**
	 * Reads the user input as integer
	 * @return	The integer that the user enters
	 */
	public static int userInputI() {
		reader = new Scanner(System.in);
		int i;
		String s;
		s = reader.nextLine();
		while(!s.matches("[0-9]+")) {
			System.out.println("Please enter a number.");
			s = reader.nextLine();	
		}
		i = Integer.parseInt(s);
		return i;
	} 
	
	/**
	 * Checks if the entered name for a crew member is the same with other crew members
	 * @param crewMemberName	An input string from the user to set the name of a crew member
	 * @return					True if the input name is the same with other crew member's name or false if it's unique 
	 */
	public static boolean duplicateNames(String crewMemberName) {
		boolean ifDup = false;
		for(CrewMember crew: Crew.getCrew()) {
			if (crew.getName().equals(crewMemberName)) {
				ifDup = true;
			} 
		}	
		if(ifDup) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if the crew has doctor(s)
	 */
	public static void doctorCheck() {
		haveDoctor = false;
		for(CrewMember crew : Crew.getCrew()) {
			if(crew.getType() == "doctor" && crew.getTiredness() != 100 && crew.getActionNumber() != 0) {
				haveDoctor = true;
				System.out.println("We have an avaliable doctor");
			}
		}
	}
	
	/**
	 * Checks if the crew has mercenaries/a mercenary 
	 */
	public static void mercenaryCheck() {
		haveMercenary = false;
		for(CrewMember crew : Crew.getCrew()) {
			if(crew.getType() == "mercenary" && crew.getTiredness() != 100 && crew.getActionNumber() != 0) {
				haveMercenary = true;
				System.out.println("We have an avaliable mercenary");
			}
		}
	}
	
	/**
	 * Sets how many transporter parts need to collect through desired number of days to play given by the player 
	 */
	public static void setPartsRequired() {
		switch(daysToPlay) {
		case 3:
			partsRequired = 2;
			break;
		case 4:
			partsRequired = 2;
			break;
		case 5:
			partsRequired = 3;
			break;
		case 6:
			partsRequired = 4;
			break;
		case 7:
			partsRequired = 4;
			break;
		case 8:
			partsRequired = 5;
			break;
		case 9:
			partsRequired = 6;
		case 10:
			partsRequired = 6;
		}
	}
	
	/**
	 * Creates a crew member that the player desires
	 * @param chooseCrew		Integer input from the user to create a desired crew type
	 * @param crewMemberName	An input string from the user to set the name of a crew member
	 */
	public static void createCrew(int chooseCrew, String crewMemberName) {
		switch(chooseCrew) {
		case 1:
			Pilot pilot = new Pilot(crewMemberName);
			Crew.addCrew(pilot);
			break;
		case 2:
			AssistantPilot assistantPilot = new AssistantPilot(crewMemberName);
			Crew.addCrew(assistantPilot);			
			break;
		case 3:
			Doctor doctor = new Doctor(crewMemberName);
			Crew.addCrew(doctor);			
			break;
		case 4:
			Scavenger scavenger = new Scavenger(crewMemberName);
			Crew.addCrew(scavenger);
			break;
		case 5:
			Mercenary mercenary = new Mercenary(crewMemberName);
			Crew.addCrew(mercenary);			
			break;
		case 6:
			Mechanician mechanician = new Mechanician(crewMemberName);
			Crew.addCrew(mechanician);			
			break;
		}
	}
	
	/**
	 * Set days that player want to play
	 * @param dayNumber the number that play want to play
	 */
	public static void setDaysToPlay(int dayNumber) {
		daysToPlay = dayNumber;
	}
	
	/**
	 * Game initializer
	 */
	public static void init() {//
		int crewNumber;
		int chooseCrew;
		String crewMemberName;
		String spaceshipName;
		String crewName;
		
		//Ask how many days to play
		System.out.println("Enter how many days you want to play (3-10 days)?");
		daysToPlay = userInputI();
		while(daysToPlay < 3 || daysToPlay >  10) {
			System.out.println("Please enter number between 3 to 10.");
			daysToPlay = userInputI();
		}
		setPartsRequired();
		
		//Ask for how many crew members
		System.out.println("Enter how many crew members you want to have (2-4 crew members)?");
		crewNumber = userInputI();
		while(crewNumber < 2 || crewNumber >  4) {
			System.out.println("Please enter number between 2 to 4.");
			crewNumber = userInputI();
		}
		
		//spaceship name
		System.out.println("Please give a name for your spaceship.");
		spaceshipName = userInputS();
		Crew.setShipName(spaceshipName);
		
		//crew name
		System.out.println("Please give a name for your crew.");
		crewName = userInputS();	
		Crew.setName(crewName);
		
		
		for(int i = 1; i <= crewNumber; i++) {
			
			//give a name to crew member
			System.out.printf("Please give a name for crew member #%d.\n", i);
			crewMemberName = userInputS();
			while(duplicateNames(crewMemberName)) {
				System.out.printf("Please give a unique name for crew member #%d.\n", i);
				crewMemberName = userInputS();
			}
			
			//Choose crew member type
			System.out.printf("Choose type for %s?\n", crewMemberName);
			System.out.println("1. Pilot: 80HP, 20Repair, 15search\n   Can decrease the damage from asteroid belt.");
			System.out.println("2. Assistant Pilot: 80HP, 20Repair, 15search\n   Having pilot and assistant pilot has a higher chance of avoiding asteroid belt.");
			System.out.println("3. Doctor: 100HP, 5Repair, 5search\n   Can boost healing item for the crew members.");
			System.out.println("4. Scavenger: 90HP, 30Repair, 50search\n   Has a higher chance of finding an item or a transporter part.");
			System.out.println("5. Mercenary: 100HP, 5Repair, 5search\n   Has higher chance of getting the item back from Alien pirates.");
			System.out.println("6. Mechanician: 80HP, 100Repair, 20search\n   Repairs the Spaceship's Shield level by great amount.");
			chooseCrew = userInputI();
			while(chooseCrew < 1 || chooseCrew >  6) {
				System.out.println("Please enter number between 1 to 6.");
				crewNumber = userInputI();
			}
		createCrew(chooseCrew, crewMemberName);		
		}
	}
	
	/**
	 * Outpost (shop) initializer
	 * Sets the stock items in the store (refreshes everyday)
	 */
	public static void initOutPost() {
		stock = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0));
		Random rand = new Random();
		
		for(int i = 0; i < 4; i++) {
			int n = rand.nextInt(6);
			int addStock = stock.get(n) + 1;
			stock.set(n, addStock);
		}
		
		for(int i = 0; i < 3; i++) {
			int n = rand.nextInt(3);
			int addStock = stock.get(n+6) + 1;
			stock.set(n+6, addStock);
		}
	}
	
	/**
	 * Resets the crew member action everyday
	 */
	public static void resetActionNumber() {
		for(CrewMember crew: Crew.getCrew()) {
			crew.resetActonNumber();
		}
	}
	
	/**
	 * Summary information of how many transporter parts to collect, chosen days to play, crew name, crew member types and it's names
	 */
	public static void summarytInfo() {
		System.out.printf("You're playing for %d days and ", daysToPlay);
		System.out.printf("you need to collect %d transporter parts.\n", partsRequired);
		System.out.printf("Your crew name is %s.\n", Crew.getName());
		System.out.printf("Your spaceship name is %s.\n", Crew.getShipName());
		System.out.printf("Your crew members are:\n");
		for (CrewMember crew: Crew.getCrew()) {
			System.out.printf("%s a %s.\n", crew.getName(), crew.getType());
		}
		System.out.printf("\n");
	}
	
	/**
	 * Game main menu
	 */
	public static void mainMenu() {
		System.out.printf("\nChoose what you want to do for today (enter number).\n");
		System.out.printf("1. Actions\n");
		System.out.printf("2. View status\n");
		System.out.printf("3. Visit outpost\n");
		if(numberOfParts == partsRequired) {
			System.out.printf("4. Next day to win! (Don't crash your spaceship!)\n");
		} else if (Crew.getCrew().size() == 0) {
			System.out.printf("4. Next day (You don't have crew member anymore. You will float in the space forever!)\n");
		} else {
			System.out.printf("4. Next day\n");
		}
		selection = userInputI();
		while(selection < 1 || selection >  4) {
			System.out.println("Please enter number between 1 to 4.");
			selection = userInputI();
		}
		if(selection == 1) {
			state = MenuState.ACTION;
		} else if(selection == 2) {
			state = MenuState.STATUS;
		} else if(selection == 3) {
			state = MenuState.OUTPOST;
		} else if(selection == 4) {
			state = MenuState.NEXTDAY;
		}		
	}
	
	/**
	 * Chooses a crew member to perform an action
	 */
	public static void crewSelection() {
		int counter = 1;
		System.out.printf("\nChoose which crew member you want to control (enter number).\n");
		System.out.printf("0. Back to main menu\n");

		for(CrewMember crew: Crew.getCrew()) {
			System.out.printf("%d. %s type: %s\n", counter, crew.getName(), crew.getType());
			counter++;
		}
		
		crewSelection = userInputI();
		while(crewSelection < 0 || crewSelection >  counter-1) {
			System.out.printf("Please enter number between 0 to %d.\n", counter-1);
			crewSelection = userInputI();
		}
		
		if(crewSelection == 0) {
			state = MenuState.MAIN;
		} else {
			state = MenuState.ACTCREWSELECTION;
		}
	}
	
	/**
	 * Chooses which status to view; crew or spaceship
	 */
	public static void statusMenu() {
		System.out.printf("\nChoose what status you want to view (enter number).\n");
		System.out.printf("0. Back to main menu\n");
		System.out.printf("1. Crew members\n");
		System.out.printf("2. Spaceship\n");
		selection = userInputI();
		while(selection < 0 || selection >  2) {
			System.out.println("Please enter number between 0 to 2.");
			selection = userInputI();
		}
		if(selection == 1) {
			state = MenuState.CREWMEMBER;
		} else if(selection == 2) { 
			state = MenuState.SPACESHIP;
		} else if (selection == 0) {
			state = MenuState.MAIN;
		}
	}
	
	/**
	 * Outpost (shop) menu
	 */
	public static void outpostMenu() {
		System.out.printf("\nMoney: %d\n", Crew.getAmountOfMoney());
		System.out.printf("Your inventory\nFood: ");
		for(Item item : Crew.getFoods()) {
			System.out.printf("%s ", item.getName());
		}
		System.out.printf("\nMedicalItems: ");
		for(Item item: Crew.getMedicalItems()) {
			System.out.printf("%s ", item.getName());
		}		
		System.out.println();
		System.out.printf("Please press number of item you want to buy\n");
		System.out.printf("0. Finish shopping\n");
		for(int i = 0; i < 9; i++) {
			System.out.printf("%d. %s(stock: %d, price: %d)\n", i+1, shop.get(i).getName(), stock.get(i), shop.get(i).getCost());
		}
		selection = userInputI();
		while(selection < 0 || selection >  9) {
			System.out.println("Please enter number between 0 to 9.");
			selection = userInputI();
		}
		
		if(selection == 0) {
			state = MenuState.MAIN;
		} else if(stock.get(selection-1) == 0) {
			System.out.printf("Out of stock at this outpost\n");
		} else if(Crew.getAmountOfMoney() < shop.get(selection-1).getCost()){
			System.out.printf("Insufficient money\n");
		} else if(selection == 1) {
			Crew.setFoods(candy);
			stock.set(selection-1, stock.get(selection-1)-1); 
			Crew.minusMoney(candy);
		} else if(selection == 2) {
			Crew.setFoods(apple);
			stock.set(selection-1, stock.get(selection-1)-1); 
			Crew.minusMoney(apple);
		} else if(selection == 3) {
			Crew.setFoods(sandwich);
			stock.set(selection-1, stock.get(selection-1)-1); 
			Crew.minusMoney(sandwich);
		} else if(selection == 4) {
			Crew.setFoods(pizza);
			stock.set(selection-1, stock.get(selection-1)-1); 
			Crew.minusMoney(pizza);
		} else if(selection == 5) {
			Crew.setFoods(fish);
			stock.set(selection-1, stock.get(selection-1)-1); 
			Crew.minusMoney(fish);
		} else if(selection == 6) {
			Crew.setFoods(chicken);
			stock.set(selection-1, stock.get(selection-1)-1); 
			Crew.minusMoney(chicken);
		} else if(selection == 7) {
			Crew.setMedicalItems(bandage);
			stock.set(selection-1, stock.get(selection-1)-1); 
			Crew.minusMoney(bandage);
		} else if(selection == 8) {
			Crew.setMedicalItems(medkit);
			stock.set(selection-1, stock.get(selection-1)-1); 
			Crew.minusMoney(medkit);
		} else if(selection == 9) {
			Crew.setMedicalItems(potion);
			stock.set(selection-1, stock.get(selection-1)-1); 
			Crew.minusMoney(potion);
		}
	}
	
	/**
	 * Shows the status of the crew
	 */
	public static void crewMemberStatus() {
		System.out.println();
		int num = 1;
		for(CrewMember crew : Crew.getCrew()) {
			System.out.printf("Crew %d: %s", num, crew);
			num++;
		}
		System.out.println("Please enter 0 to go back to previous menu.");
		selection = userInputI();
		while(selection != 0) {
			System.out.println("Please enter number 0");
			selection = userInputI();
		}
		if(selection == 0) {
			state = MenuState.STATUS;
		}
	}
	
	/**
	 * Shows the status of the spaceship
	 */
	public static void spaceshipStatus(){
		System.out.printf("\nOur spaceship %s has %d/1000Shield level\n", Crew.getShipName(),Crew.getShieldLevel() );
		System.out.println("Please enter 0 to go back to previous menu.");
		selection = userInputI();
		while(selection != 0) {
			System.out.println("Please enter number 0");
			selection = userInputI();
		}
		if(selection == 0) {
			state = MenuState.STATUS;
		}
	}
	
	/**
	 * Chooses an action for a crew member to perform
	 */
	public static void action() {
		System.out.printf("\nChooes what action you want to ask %s to do (enter number).\n", Crew.getCrew().get(crewSelection-1).getName());
		System.out.printf("0. Back to crew selection menu\n");
		System.out.printf("1. Eat\n");
		System.out.printf("2. Heal\n");//Implement doctor boost the effect of medicines
		System.out.printf("3. Sleep\n");
		System.out.printf("4. Repair spaceship\n");
		System.out.printf("5. Scavenge\n");
		System.out.printf("6. Pilot to next planet\n");
		
		selection = userInputI();
		while(selection < 0 || selection >  6) {
			System.out.println("Please enter number between 0 to 6.");
			selection = userInputI();
		}
		
		if(selection == 0) {
			state = MenuState.ACTION;
		} else if(selection == 1){
			if(Crew.getCrew().get(crewSelection-1).getTiredness() == 100) {
				System.out.printf("%s is to tired to do this! Let him get some sleep.\n", Crew.getCrew().get(crewSelection-1).getName());
			}else {
				state = MenuState.FOODSELECTION;
			}
		} else if(selection == 2) {
			doctorCheck();
			if(Crew.getCrew().get(crewSelection-1).getTiredness() == 100 && !haveDoctor) {
				System.out.printf("%s is to tired to do this! Let him get some sleep.\n", Crew.getCrew().get(crewSelection-1).getName());
			}else {
					state = MenuState.MEDICALSELECTION;
			}
		} else if(selection == 3) {
			Crew.getCrew().get(crewSelection-1).sleep();
		} else if(selection == 4) {
			if(Crew.getCrew().get(crewSelection-1).getTiredness() == 100) {
				System.out.printf("%s is to tired to do this! Let him get some sleep.\n", Crew.getCrew().get(crewSelection-1).getName());
			}else {
				Crew.getCrew().get(crewSelection-1).repairTheShieldsOfSpaceship();
			}
		} else if(selection == 5) {
			if(Crew.getCrew().get(crewSelection-1).getTiredness() == 100) {
				System.out.printf("%s is to tired to do this! Let him get some sleep.\n", Crew.getCrew().get(crewSelection-1).getName());
			}else {
				if(!searched) {
					if(Crew.getCrew().get(crewSelection-1).searchTransporterParts()) {
					Crew.getCrew().get(crewSelection-1).searchItem();
					searched = true;
					}
				} else {
					System.out.println("We have already searched this planet, try head to another planet.");
				}
			}
		} else if(selection == 6) {
			if(Crew.getCrew().size() < 2) {
				System.out.println("We don't have enough crew to operate our spaceship.\nYou will die hopeless!");
			} else {
				state = MenuState.ACTCREWSELECTIONPILOT;
			}
		}
	}
	
	/**
	 * Chooses a food for a crew member to eat
	 */
	public static void foodSelection() {
		int counter = 1;
		System.out.printf("\nChoose what food you want your crew to eat (enter number).\n");
		System.out.printf("0. Back to action menu\n");

		for(Item item : Crew.getFoods()) {
			System.out.printf("%d. %s(%d)\n",counter, item.getName(), item.getValue());
			counter++;
		}
		
		foodSelection = userInputI();
		while(foodSelection < 0 || foodSelection >  counter-1) {
			System.out.printf("Please enter number between 0 to %d.\n", counter-1);
			foodSelection = userInputI();
		}
		
		if(foodSelection == 0) {
			state = MenuState.ACTCREWSELECTION;
		} else{
			Crew.getCrew().get(crewSelection-1).feed(Crew.getFoods().get(foodSelection-1));
		}
	}
	
	/**
	 * Chooses a medical item for a crew member to use
	 */
	public static void medicineSelection() {
		int counter = 1;
		System.out.printf("\nChoose what medicine you want your crew to use (enter number).\n");
		System.out.printf("0. Back to action menu\n");

		for(Item item : Crew.getMedicalItems()) {
			System.out.printf("%d. %s(%d)\n",counter, item.getName(), item.getValue());
			counter++;
		}
		
		medicineSelection = userInputI();
		while(medicineSelection < 0 || medicineSelection >  counter-1) {
			System.out.printf("Please enter number between 0 to %d.\n", counter-1);
			medicineSelection = userInputI();
		}
		
		if(medicineSelection == 0) {
			state = MenuState.ACTCREWSELECTION;
		} else {
			doctorCheck();//Enough action number and tiredness and you must have a doctor
			if(haveDoctor) {
				state = MenuState.DOCTORSELECTION;
			} else {
				Crew.getCrew().get(crewSelection-1).applyMedicalItem(Crew.getMedicalItems().get(medicineSelection-1));
			}
		}
	}
	
	/**
	 * Chooses whether the player wants the doctor to heal a crew member or not
	 */
	public static void doctorSelection() {
		int counter = 1;
		System.out.println("\nChoose doctor you want for applying medicine to others (enter number)");
		System.out.printf("0. Don't let doctor to do this\n");
		for(CrewMember crew: Crew.getCrew()) {
			System.out.printf("%d. %s type: %s\n", counter, crew.getName(), crew.getType());
			counter++;
			}
			
		doctorSelection = userInputI();
		while(doctorSelection < 0 || doctorSelection > counter-1) {
			System.out.printf("Please enter number between 0 to %d.\n", counter-1);
			doctorSelection = userInputI();
			}
			
		if(doctorSelection == 0) {
			System.out.println("Without doctor's help.");
		//tiredness check
		if(Crew.getCrew().get(crewSelection-1).getTiredness() != 100) {
			Crew.getCrew().get(crewSelection-1).applyMedicalItem(Crew.getMedicalItems().get(medicineSelection-1));
			state = MenuState.MEDICALSELECTION;
			} else {
				System.out.printf("%s is to tired to do this! Let him get some sleep.\n", Crew.getCrew().get(crewSelection-1).getName());
				state = MenuState.MEDICALSELECTION;
				}
			} else if(Crew.getCrew().get(doctorSelection -1).getType() != "doctor"){
				System.out.println("You need to choose a doctor.");
				state = MenuState.DOCTORSELECTION;
			} else {
				System.out.println("With doctor's help.");
				((Doctor) Crew.getCrew().get(doctorSelection -1)).healOther(Crew.getCrew().get(crewSelection-1), Crew.getMedicalItems().get(medicineSelection-1));
				state = MenuState.MEDICALSELECTION;
			}
	 }
	
	/**
	 * Chooses pilots to pilot the spaceship to another planet
	 */
	public static void crewSelectionPilot() {
		int counter = 1;
		System.out.printf("\nChoose a second crew member you want to pilot the spaceship (enter number)\n");
		System.out.printf("0. Back to action menu\n");
		for(CrewMember crew: Crew.getCrew()) {
			if(crew == Crew.getCrew().get(crewSelection-1)) {
				System.out.printf("%d. %s type: %s (First pilot)\n", counter, crew.getName(), crew.getType());
			} else {
				System.out.printf("%d. %s type: %s\n", counter, crew.getName(), crew.getType());
			}
			counter++;
		}
		
		crewSelectionPilot = userInputI();
		while(crewSelectionPilot < 0 || crewSelectionPilot >  counter-1) {
			System.out.printf("Please enter number between 0 to %d.\n", counter-1);
			crewSelectionPilot = userInputI();
		}
		
		if(crewSelectionPilot == 0) {
			state = MenuState.ACTCREWSELECTION;
		} else if(crewSelection == crewSelectionPilot) {
			System.out.println("You can't choose same crew member as a pilot.");
		} else {
			if(Crew.getCrew().get(crewSelection-1).getActionNumber() != 0 && Crew.getCrew().get(crewSelectionPilot-1).getActionNumber() != 0
					&& Crew.getCrew().get(crewSelection-1).getTiredness() != 100 && Crew.getCrew().get(crewSelectionPilot-1).getTiredness() != 100) {
				searched = false;
				initOutPost();
				Crew.getCrew().get(crewSelection-1).minusActionNumber();
				Crew.getCrew().get(crewSelectionPilot-1).minusActionNumber();				
				astroidBelt();
				if(Crew.getShieldLevel() != 0) {
					System.out.println("We arrived a new planet.");
					state = MenuState.MAIN;
				} else {
					state = MenuState.MAIN;
				}
			} else {
				System.out.println("Our pilots are not good enough to pilot our spaceship.");
				state = MenuState.ACTION;
			}
		}
	}
	
	/**
	 * Handles the main menu of the game
	 */
	public static void mainGame() {
		System.out.printf("\nDay %d\n", currentDay);
		boolean notNextDay = true;
		
		while(notNextDay) {
			
			switch(state) {
			case MAIN:
				if(Crew.getShieldLevel() != 0) {
					mainMenu();
				} else {
					notNextDay = false;
				}
				break;
			case ACTION:
				crewSelection();
				break;
			case STATUS:
				statusMenu();
				break;
			case OUTPOST:
				outpostMenu();
				break;
			case NEXTDAY:
				notNextDay = false;
				state = MenuState.MAIN;
				break;
			case CREWMEMBER:
				crewMemberStatus();
				break;
			case SPACESHIP:
				spaceshipStatus();
				break;
			case ACTCREWSELECTION:
				action();
				break;
			case FOODSELECTION:
				foodSelection();
				break;
			case MEDICALSELECTION:
				medicineSelection();
				break;	
			case ACTCREWSELECTIONPILOT:
				crewSelectionPilot();
				break;
			case DOCTORSELECTION:
				doctorSelection();
				break;
			}
		}
		currentDay += 1;
	}
	
//*******************************EVENTS**********************************************
	/**
	 * Implements asteroid belt during the flight
	 * @return	True if the player encounters asteroid belt during the flight or false if they didn't
	 */
	public static boolean astroidBelt() {
		int possible = rand.nextInt(100) + 1;
		int likeHood = 50;
		float initAstroidBeltDam = 150;

		if((Crew.getCrew().get(crewSelection-1).getType() == "pilot" && Crew.getCrew().get(crewSelectionPilot-1).getType() == "assistant pilot")
				|| (Crew.getCrew().get(crewSelection-1).getType() == "assistant pilot" && Crew.getCrew().get(crewSelectionPilot-1).getType() == "pilot")) {
			likeHood = 20;	
			System.out.println("We have professional pilot and assistant pilot, they will help us avoid astroid belt!");
		}		
		
		if(possible <= likeHood) {
			float realDamageAB = (initAstroidBeltDam * (2 - ((float) Crew.getShieldLevel() / 1000)));
			if(Crew.getCrew().get(crewSelection-1).getType() == "pilot" || Crew.getCrew().get(crewSelectionPilot-1).getType() == "pilot") {
				System.out.printf("We went through an astroid belt during the flight to next planet\n");
				realDamageAB -= 40;
				System.out.println("Our pilot tried to avoid damage from astorid belt. (Damage reduced 40)");
			} else if(Crew.getCrew().get(crewSelection-1).getType() == "assistant pilot" || Crew.getCrew().get(crewSelectionPilot-1).getType() == "assistant pilot") {
				System.out.printf("We went through astroid belt during the journey to next planet\n");
				realDamageAB -= 20;
				System.out.println("Our assistant pilot tried to avoid damage from astorid belt. (Damage reduced 20)");
			} else {
				System.out.printf("We went through an astroid belt during the flight to next planet.\n");
			}
			
			Crew.minusShipLevel(Math.round(realDamageAB));
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Implements space plague at the start of a new day
	 */
	public static void plague() {
		//Must have one random crew member will get space plague
		int plagueDecider = rand.nextInt(Crew.getCrew().size());
		Crew.getCrew().get(plagueDecider).getSick();
		
		//The rest of crew members will have 33% get space plague
		for(CrewMember crew : Crew.getCrew()) {
			plagueDecider = rand.nextInt(3);
			if(plagueDecider == 0) {
				crew.getSick();
			}
		}
	}
	
	/**
	 * Implements space plague damage on the affected crew member(s)
	 */
	public static void plagueDamage(){
		int i = Crew.getCrew().size();
		while (--i >= 0) {
		    if (Crew.getCrew().get(i).sickCheck()) {
		    	Crew.getCrew().get(i).minusHealth(20);
		    	System.out.println("Because of plague.");
		    	}
		    }
		}
	
	/**
	 * Implements space pirates at the start of a new day
	 * If the player has Mercenaries or a Mercenary, it to protect the items from being stolen 
	 */
	public static void pirate() {
		mercenaryCheck();
		
		System.out.println("You encounter space pirate, they are trying to steal our supplies.");

		if(!haveMercenary) {
			if(Crew.getFoods().size() + Crew.getMedicalItems().size() != 0) {
				int stealDecider = rand.nextInt(Crew.getFoods().size() + Crew.getMedicalItems().size());
			
				if(stealDecider < Crew.getFoods().size()) {
					System.out.printf("You %s has been stolen!\n", Crew.getFoods().get(stealDecider).getName());
					Crew.getFoods().remove(stealDecider);
				} else {
					System.out.printf("You %s has been stolen!\n", Crew.getMedicalItems().get(stealDecider - Crew.getFoods().size()).getName());
					Crew.getMedicalItems().remove(stealDecider - Crew.getFoods().size());
				}
				
			} else {
					System.out.println("But you have nothing to be stolen, poor!");
			}
		} else {
			System.out.println("Your mercenary protected you from space pirate.");
			for(CrewMember crew : Crew.getCrew()) {
				if(crew.getType() == "mercenary" && crew.getTiredness() != 100 && crew.getActionNumber() != 0) {
					crew.minusActionNumber();
					crew.minusHealth(20);
					break;
				}
			}
		}
	}
	
	/**
	 * Degrades crew health and increases their hunger, and tiredness over time
	 */
	public static void dailyDamage() {
		for(CrewMember crew: Crew.getCrew()) {
			if(crew.getType() == "pilot") {
				if(crew.getHunger() != 100) {
					crew.minusHealth(10);
				} else {
					crew.minusHealth(20);
					System.out.printf("%s is too hungry, He lost extra 10HP.\n", crew.getName());
				}
				crew.addHunger(20);
				crew.addTiredness(15);
			} else if(crew.getType() == "assistant pilot") {
				if(crew.getHunger() != 100) {
					crew.minusHealth(10);
				} else {
					crew.minusHealth(20);
					System.out.printf("%s is too hungry, He lost extra 10HP.\n", crew.getName());
				}
				crew.addHunger(20);
				crew.addTiredness(15);
			} else if(crew.getType() == "doctor") {
				if(crew.getHunger() != 100) {
					crew.minusHealth(5);
				} else {
					crew.minusHealth(15);
					System.out.printf("%s is too hungry, He lost extra 10HP.\n", crew.getName());
				}
				crew.addHunger(15);
				crew.addTiredness(15);
			} else if(crew.getType() == "mercenary") {
				if(crew.getHunger() != 100) {
					crew.minusHealth(10);
				} else {
					crew.minusHealth(20);
					System.out.printf("%s is too hungry, He lost extra 10HP.\n", crew.getName());
				}
				crew.addHunger(30);
				crew.addTiredness(20);
			} else if(crew.getType() == "scavenger") {
				if(crew.getHunger() != 100) {
					crew.minusHealth(5);
				} else {
					crew.minusHealth(15);
					System.out.printf("%s is too hungry, He lost extra 10HP.\n", crew.getName());
				}
				crew.addHunger(10);
				crew.addTiredness(10);
			} else if(crew.getType() == "mechanician") {
				if(crew.getHunger() != 100) {
					crew.minusHealth(10);
				} else {
					crew.minusHealth(20);
					System.out.printf("%s is too hungry, He lost extra 10HP.\n", crew.getName());
				}
				crew.addHunger(20);
				crew.addTiredness(15);
			}
		}
	}
	
	public static void main(String[] args) {
		init();
		summarytInfo();
		while(currentDay <= daysToPlay && Crew.getShieldLevel() > 0 && Crew.getCrew().size() > 0 && numberOfParts < partsRequired) {
			initOutPost();
			mainGame();
			resetActionNumber();	
			if(Crew.getShieldLevel() > 0 && Crew.getCrew().size() > 0 && currentDay <= daysToPlay && numberOfParts < partsRequired) {
				int eventGenerator = rand.nextInt(100) + 1;
				if(eventGenerator <= 40) {
					int eventDecider = rand.nextInt(2);
					if(eventDecider == 0) {
						pirate();
					} else {
						plague();
					}
				}
				plagueDamage();
				dailyDamage();
				}
		}
		
		//Different scenario for ending
		if(numberOfParts >= partsRequired) {
			System.out.println("You have found all missing transporter parts, let's go home!\nHome sweet home!");
		} else if(currentDay > daysToPlay) {
			System.out.println("You run out of time!\nAfter struggling with suviving in the space,\n"
					+ "You lost in dark universe.\nYou're almost there!");
		} else if(Crew.getCrew().size() == 0){
			System.out.printf("Your crew members are all dead, %s is flying in the space peacefully forever!\n", Crew.getShipName());
		} else if(Crew.getShieldLevel() == 0) {
			System.out.println("Your spaceship crashed!\nNothing left.");
		}
	} 
}
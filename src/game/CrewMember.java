package game;

import java.util.*;

//to be super class and we need 6 different types of crew members
public class CrewMember {
	private String name;
	private int maxHealth;
	private int health;
	private int hunger=0;
	private int tiredness=0;
	protected int numberOfActions=2;
	private int repairAbility;
	private int searchAbility;
	private String crewType;
	private boolean sick = false;
	private Random rand;
//	private boolean alive = true;
	 
	/**
	 * Constructor of CrewMember
	 * @param name				Name of crew member
	 * @param crewType			Type of crew member (6 types)
	 * @param health			HP of crew member
	 * @param repairAbility		How much HP that a crew member can recover to the space shield (out of 100%)
	 * @param searchAbility		The possibility that crew member can find one part of transporter (out of 100%)
	 */
	public CrewMember(String name, String crewType, int health, int repairAbility, int searchAbility){
		this.name = name;
		this.health = health;
		this.maxHealth = health;
		this.repairAbility = repairAbility;
		this.searchAbility = searchAbility;
		this.crewType = crewType;
	}
	
	/**
	 * Returns the crew member's name
	 * @return	Crew member's name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the crew member's name
	 * @param name	Name to be given a crew member
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the crew member type 
	 * @return	Type of crew member
	 */
	public String getType() {
		return this.crewType;
	}
	
	/**
	 * Returns the health of the crew member
	 * @return	Health of the crew member
	 */
	public int getHealth() {
		return this.health;
	}
	
	/**
	 * Returns the max health of the crew member
	 * @return	Max health of the crew member
	 */
	public int getMaxHealth() {
		return this.maxHealth;
	}
	
	/**
	 * Recover crew member's health by given health value
	 * @param health	Amount of health that the crew will recover
	 * @return			True for successfully health recover or false if crew member is in full health
	 */
	public boolean addHealth(int health) {
		if(this.health == this.maxHealth ) {
			System.out.printf("%s doesn't need to heal.\n", this.name);
			return false;
		} else {
			this.health += health;
			if(this.health >= this.maxHealth) {
				this.health = this.maxHealth;
				System.out.printf("%s's is fully healthy. (%d/%dHP)\n", this.name, this.health, this.maxHealth);
			} else {
				System.out.printf("%s's health has increased by %d.(%d/%dHP)\n", this.name, health, this.health, this.maxHealth);
			}
			return true;
		}
	}
	
	/**
	 * Reduces the health of crew member
	 * @param health	Amount of health that the crew member looses
	 * @return			True if the crew member will not die or false if crew member dies
	 */
	public boolean minusHealth(int health) {
		this.health -= health;
		if(this.health <= 0) {
			this.health = 0;
			Crew.removeCrew(this);
			System.out.printf("%s is dead.\n", this.name);
			return false;
		} else {
			System.out.printf("%s's health has decreased by %d (%d/%dHP).\n", this.name, health, this.health, this.maxHealth);
			return true;
		}
	}
	
	/**
	 * Gets the hunger value of a crew member
	 * @return	Hunger value of a crew member
	 */
	public int getHunger() {
		return hunger;
	}

	/**
	 * Increases the hunger of the crew member
	 * @param hunger	Increases the hunger value
	 */
	public void addHunger(int hunger) {
		this.hunger += hunger;
		if(this.hunger >= 100) {
			this.hunger = 100;
			System.out.printf("%s is really hungry (Hunger: %d/100) and his/her health is decreasing.\n", this.name, this.hunger);
		}
		if(this.hunger >= 80 && this.hunger < 100) {
			System.out.printf("%s is getting hungry (Hunger: %d/100).\n", this.name, this.hunger);
		}
	}
	
	/**
	 * Reduces crew member's hunger 
	 * @param hunger	Hunger value of a crew member that will be reduced
	 * @return			True if successfully reducing crew member's hunger or false if hunger value is zero
	 */
	public boolean minusHunger(int hunger) {
		if(this.hunger == 0) {
			System.out.printf("%s is not hungry.\n", this.name);
			return false;
		} else {
			this.hunger -= hunger;
			if(this.hunger <= 0) {
				this.hunger = 0;
				System.out.printf("%s is full.\n", this.name);
			} else {
				System.out.printf("%s is eating food. (%d/100hunger)\n", this.name, this.hunger);
			}
			return true;
		}
	}
	
	/**
	 * Get tiredness value of crew member
	 * @return	Tiredness value
	 */
	public int getTiredness() {
		return tiredness;
	}
	
	/**
	 * Increases tiredness of a crew member
	 * @param tiredness	A value of tiredness that the crew member will be increased
	 */
	public void addTiredness(int tiredness) {
		this.tiredness += tiredness;
		if(this.tiredness >= 100) {
			this.tiredness = 100;
			System.out.printf("%s is really tired (tiredness: %d/100) and he/she couldn't perform any task.\n", this.name, this.tiredness);
		}
		if(this.tiredness >= 80 && this.tiredness < 100) {
			System.out.printf("%s is getting tired (tiredness: %d/100).\n", this.name, this.tiredness);
		}
	}
	
	/**
	 * Reduces the tiredness of a crew member 
	 * @param tiredness	A value of tiredness that the crew member will be reduced
	 * @return			True if reducing crew member's tiredness is successful or false if the tiredness value is zero
	 */
	public boolean minusTiredness(int tiredness) {
		if(this.tiredness == 0) {
			System.out.printf("%s is not tired.\n", this.name);
			return false;
		} else {
			this.tiredness -= tiredness;
			if(this.tiredness <= 0) {
				this.tiredness = 0;
				System.out.printf("%s have fully rested.\n", this.name);
			} else {
				System.out.printf("%s had a rest. (%d/100tiredness)\n", this.name, this.tiredness);
			}
			return true;
		}
	}
	
	/**
	 * Gets the remaining action number of a crew member
	 * @return	Remaining action number
	 */
	public int getActionNumber() {
		return numberOfActions;
	}
	
	/**
	 * Resets the action number of the crew member to 2
	 */
	public void resetActonNumber() {
		numberOfActions = 2;
	}
	
	/**
	 * Subtracts an action to the current number of action that a crew member has 
	 */
	public void minusActionNumber() {
		if(numberOfActions == 0) {
			System.out.printf("%s cannot perform anymore actions for today.\n", this.name);
		} else {
			numberOfActions -= 1;
		}
	}
	
	public int getRepairAbility() {
		return this.repairAbility;
	}
	
	/**
	 * Implements the space plague to a crew member
	 */
	public void getSick() {
		if(this.sick == false) {
			this.sick = true;
			System.out.printf("%s got space plague (use potion to heal).\n", this.name);
		}
	}
	
	/**
	 * Check's if the crew member has a space plague
	 * @return	True if the crew member is has a space plague or false if it doesn't
	 */
	public boolean sickCheck() {
		if(this.sick) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Heals the crew member that has space plague
	 */
	public void healSick() {
		this.sick = false;
	}
	
	
	/**
	 * Feeds the crew member
	 * @param food A food that contains hunger value that decreases the crew member's hunger, once it is used, it will be remove from food list
	 * @return return true if feed succeed or return false
	 */
	public boolean feed(Food food) {
		if (this.numberOfActions == 0) {
			System.out.printf("%s cannot perform anymore actions for today.\n", this.name);
			return false;
		} else {
			if(this.minusHunger(food.getValue())) {
				this.numberOfActions -= 1;
				Crew.getFoods().remove(food);
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 * Heals the crew member
	 * @param medicalItem	A medical item that contains healing value that adds to the crew member's health
	 * @return 
	 */
	public boolean applyMedicalItem (MedicalItem medicalItem) {
		if (this.numberOfActions == 0) {
			System.out.printf("%s cannot perform anymore actions for today.\n", this.name);
			return false;
		} else {
			if(medicalItem.getName() == "potion" && this.sick) {
				this.numberOfActions -= 1;
				this.sick = false;
				System.out.printf("%s recovered from space plague.\n", this.name);
				this.health += medicalItem.getValue();
				if(this.health >= this.maxHealth) {
					this.health = this.maxHealth;
					System.out.printf("%s is fully healthy.\n", this.name);
				} else {
					System.out.printf("%s's health has increased by %d.\n", this.name, health);
				}
				
				Crew.getMedicalItems().remove(medicalItem);
				return true;
			} else if (this.addHealth(medicalItem.getValue())) {
				this.numberOfActions -= 1;
				Crew.getMedicalItems().remove(medicalItem);
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 * Puts the crew member to sleep, it decreases the crew member's tiredness
	 */
	public Boolean sleep(){
		if (this.numberOfActions == 0) {
			System.out.printf("%s cannot perform anymore actions for today.\n", this.name);
			return false;
		} else {
			if(this.minusTiredness(25)) {
				this.numberOfActions -= 1;
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 * Repairs the shield of the spaceship
	 */
	public boolean repairTheShieldsOfSpaceship () {
		if (this.numberOfActions == 0) {
			System.out.printf("%s cannot perform anymore actions for today.\n", this.name);
			return false;
		} else {
			if(Crew.addShipLevel(this.repairAbility)) {
				this.numberOfActions -= 1;
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
	 * Returns a string output that contains the status of crew members
	 */
	public String toString() {
		String output = this.crewType.substring(0,1).toUpperCase() + this.crewType.substring(1) +
				" " + this.name + " has " + this.health+ "/" + this.maxHealth + "HP, " + this.hunger + "/100" + "hunger, "
				+ this.tiredness + "/100" + "tiredness, " + this.numberOfActions + "Action(s).\n";
		
		if(this.hunger >= 80 && this.tiredness >= 80) {
			output += "        " + this.name.substring(0,1).toUpperCase() + this.name.substring(1) + " is getting hungry and tired.\n";
		} else if(this.hunger >= 80) {
			output += "        " + this.name.substring(0,1).toUpperCase() + this.name.substring(1) + " is getting hungry.\n";
		}else if(this.tiredness >= 80){
			output += "        " + this.name.substring(0,1).toUpperCase() + this.name.substring(1) + " is getting tired.\n";
		}
		if(this.sick) {
			output += "        " + this.name.substring(0,1).toUpperCase() + this.name.substring(1) + " is sick, will lost HP each day!\n";
		}
				
		return output;
	}
	
	/**
	 * Searches a transporter part in the planet
	 */
	public boolean searchTransporterParts() {
		if (this.numberOfActions == 0) {
			System.out.println("Cannot perform anymore actions for today.");
			return false;
		} else {
			this.numberOfActions -= 1;

			rand = new Random();
	
			// Obtain a number between [0 - 99].
			int n = rand.nextInt(100);
	
			// Add 1 to the result to get a number from the required range
			// (i.e., [1 - 100]).
			n += 1;
			
			if(n <= this.searchAbility) {
				GameEnvironment.numberOfParts += 1;
				System.out.printf("You found a Transporter part! (%d/%d)\n", GameEnvironment.numberOfParts, GameEnvironment.partsRequired);
				return true;
			} else {
				System.out.println("There is no Transporter part on this planet.");
				return true;
			}	
		}
	}		
	
	public boolean searchTransporterPartsForGui() {
		if (this.numberOfActions == 0) {
			System.out.println("Cannot perform anymore actions for today.");
			return false;
		} else {
			this.numberOfActions -= 1;

			rand = new Random();
	
			// Obtain a number between [0 - 99].
			int n = rand.nextInt(100);
	
			// Add 1 to the result to get a number from the required range
			// (i.e., [1 - 100]).
			n += 1;
			
			if(n <= this.searchAbility) {
				GameEnvironment.numberOfParts += 1;
				System.out.printf("You found a Transporter part! (%d/%d)\n", GameEnvironment.numberOfParts, GameEnvironment.partsRequired);
				return true;
			} else {
				System.out.println("There is no Transporter part on this planet.");
				return false;
			}	
		}
	}		
	
	/**
	 * Searches the items in the planet
	 */
	public boolean searchItem() {
		boolean flag = false;
		//Must have one random crew member will get space plague
		if((rand.nextInt(100) + 1) <= this.searchAbility) {
			int foodDecider = rand.nextInt(6);
			Crew.setFoods((Food)GameEnvironment.shop.get(foodDecider));
			System.out.printf("%s found a %s.\n", this.name, GameEnvironment.shop.get(foodDecider).getName());
			flag = true;
			
		}
		if((rand.nextInt(100) + 1) <= this.searchAbility) {
			int medicineDecider = rand.nextInt(3) + 6;
			Crew.setMedicalItems((MedicalItem)GameEnvironment.shop.get(medicineDecider));
			System.out.printf("%s found a %s.\n", this.name, GameEnvironment.shop.get(medicineDecider).getName());
			flag = true;
			
		}
		if((rand.nextInt(100) + 1) <= this.searchAbility) {
			int moneyDecider = rand.nextInt(100) + 1;
			Crew.addMoney(moneyDecider);
			System.out.printf("%s found %d money.\n", this.name, moneyDecider);
			flag = true;
		}
		if(flag) {
			return true;
		} else {
			return false;
		}
		
	}
}
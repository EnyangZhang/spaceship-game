package game;
import java.util.ArrayList;

public class Crew {
	private static String crewName;
	private static String shipName;
	private static int shieldLevel = 1000;
	private static int maxShieldLevel = 1000;
	private static ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();
	private static ArrayList<MedicalItem> medicalItemsList = new ArrayList<MedicalItem>();
	private static ArrayList<Food> foodList = new ArrayList<Food>();
	private static int amountOfMoney=100;
	
	/**
	 * Returns the name of the crew
	 * @return	crew name
	 */
	public static String getName() {
		return crewName;
	}
	
	/**
	 * Set crew name
	 * @param name name for crew
	 */
	public static void setName(String name) {
		crewName = name;
	}
	
	/**
	 * Returns the name of the ship
	 * @return	Ship name
	 */
	public static String getShipName() {
		return shipName;
	}
	
	/**
	 * Set the ship name 
	 * @param name name for spaceship
	 */
	public static void setShipName(String name) {
		shipName = name;
	}
	
	/**
	 * Returns the shield level
	 * @return	shield level
	 */
	public static int getShieldLevel() {
		return shieldLevel;
	}
	
	/**
	 * Increases the shield level
	 * @param HP	Amount of level that is added to the shield level
	 * @return		True if the shield has been fully repaired or false if it increases the shield level
	 */
	public static boolean addShipLevel(int HP) {
		if(shieldLevel == maxShieldLevel) {
			System.out.printf("Our ship no need to be repaired\n");
			return false;
		} else {
			shieldLevel += HP;
			if(shieldLevel >= maxShieldLevel) {
				shieldLevel = maxShieldLevel;
				System.out.printf("%s has been fully repaired\n", shipName);
				return true;
			} else {
				System.out.printf("%s has been repaired (%d/1000ShieldLevel)\n", shipName, shieldLevel);
				return true;
			}
		}
	}
	
	/**
	 * Decreases the shield level
	 * @param HP	Amount of level that is taken to the shield level
	 */
	public static void minusShipLevel(int HP) {
		shieldLevel -= HP;
		if(shieldLevel < 0) {
			shieldLevel = 0;
//			System.out.println("You lost the game");
			}
		System.out.printf("%s lost %d shield (%d/%d)\n", shipName, HP, shieldLevel, maxShieldLevel);
	}
	
	/**
	 * Return the list of crew
	 * @return	Crew list
	 */
	public static ArrayList<CrewMember> getCrew() {
		return crewList;
	}
	
	/**
	 * Adds the crew member to the crew list
	 * @param crew	A crew member that is added to the crew list
	 */
	public static void addCrew(CrewMember crew) {
			crewList.add(crew);
	}
	
	/**
	 * Removes the crew member to the crew list
	 * @param crew	A crew member that is removed to the crew list
	 * @return		True if the crew member has been successfully removed or false if not
	 */
	public static boolean removeCrew(CrewMember crew) {
		if(crewList.contains(crew)){
			crewList.remove(crew);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * to reset crew list
	 */
	public static void resetCrew() {
		crewList = new ArrayList<CrewMember>();
	}
	
	/**
	 * Returns the list of medical items
	 * @return	Medical item list
	 */
	public static ArrayList<MedicalItem> getMedicalItems() {
		return medicalItemsList;
	}
	
	/**
	 * Adds a medical item to the list
	 * @param item	A medical item that is added in the list
	 */
	// should be divided to addMedicalItem (if the medical item is purchased) and removeMedicalItem (if the medical item has been used) 
	public static void setMedicalItems(MedicalItem item) {
		medicalItemsList.add(item);
	}
	
	/**
	 * Returns a list of foods 
	 * @return	Food list
	 */
	public static ArrayList<Food> getFoods() {
		return foodList;
	}
	
	/**
	 * Adds a food item to the list
	 * @param food	A food item that is added in the list
	 */
	// should be divided to addFood (if the food is purchased) and removeFood (if the food has been consumed)
	public static void setFoods(Food food) {
		foodList.add(food);
	}

	/**
	 * Returns the amount of money that the player
	 * @return	Amount of money that the player has
	 */
	public static int getAmountOfMoney() {
		return amountOfMoney;
	}
	
	/**
	 * Decreases the current amount of money
	 * @param item	An item that has a cost to minus to the current amount of money when bought
	 */
	public static void minusMoney(Item item) {
		amountOfMoney -= item.getCost();
	}
	
	/**
	 * Adds a money to the current money
	 * @param money	An amount that is added to current amount of money
	 */
	public static void addMoney(int money) {
		amountOfMoney += money;
	}
}
package game;

public class Item {
	private String name;
	private int cost;
	private int value;
	
	/**
	 * Constructor of Item
	 * @param name		Name of the item
	 * @param cost		Cost of the item
	 * @param value		Healing value or hunger value of the item
	 */
	public Item(String name, int cost, int value) {
		this.name = name;
		this.cost = cost;
		this.value = value;
	}
	
	/**
	 * Returns the item name
	 * @return	Item's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the item's name
	 * @param name	Item's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the cost of the item
	 * @return	Item's cost
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * Sets the cost of the item
	 * @param cost	The cost of the item
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	/**
	 * Returns the healing value that the item restores or hunger value that the item decreases
	 * @return	The healing value or hunger value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Sets the healing value or hunger value of an item
	 * @param value	Healing value or hunger value
	 */
	public void setValue(int value) {
		this.value = value;
	}
}
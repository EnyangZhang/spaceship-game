package game;
public class Food extends Item {
	
	/**
	 * Sets the food name, cost and how much hunger it decreases
	 * @param name	Food name
	 * @param cost	The cost of the food in the outpost (market)
	 * @param value	The amount of hunger that it decreases
	 */
	public Food(String name, int cost, int value) {
		super(name, cost, value);
	}
}
package game;
public class MedicalItem extends Item{

	/**
	 * Sets the medical item name, cost, and how much health value it restores
	 * @param name	Medical item name
	 * @param cost	The cost of medical item in the outpost (market)
	 * @param value	The amount of health it restores
	 */
	public MedicalItem(String name, int cost, int value) {
		super(name, cost, value);
	}	
}
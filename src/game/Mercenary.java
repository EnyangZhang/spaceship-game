package game;
public class Mercenary extends CrewMember {
	//Has higher chance of getting the item back from Alien pirates.
	
	/**
	 * Sets mercenary's name, health, repair ability and search ability
	 * @param name	mercenary's name given by player
	 */
	public Mercenary(String name) {
		super(name, "mercenary", 100, 5, 5);
	}
}
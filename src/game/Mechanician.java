package game;
public class Mechanician extends CrewMember {
	//Repairs the Spaceship's Shield level by great amount.
	
	/**
	 * Set mechanic's name, health, repair ability and search ability
	 * @param name	Mechanic's name given by player
	 */
	public Mechanician(String name) {
		super(name, "mechanician", 80, 100, 20);
	}
}
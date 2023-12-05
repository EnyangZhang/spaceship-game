package game;
public class Scavenger extends CrewMember {
	//Has a higher chance of finding an item or a transporter part.
	
	/**
	 * Set scavenger's name, health, repair ability and search ability
	 * @param name	Scavenger's name given by player
	 */
	public Scavenger(String name) {
		super(name, "scavenger", 90, 20, 50);
	}
}
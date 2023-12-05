package game;
public class Pilot extends CrewMember {
	//Can decrease the damage from asteroid belt.
	//Having pilot and assistant pilot has a higher chance of avoiding asteroid belt.
	
	/**
	 * Sets the pilot's name, health, repair ability and search ability
	 * @param name	pilot's name given by player
	 */
	public Pilot(String name) {
		super(name, "pilot", 80, 20, 15);
	}
}
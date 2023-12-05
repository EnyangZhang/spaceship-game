package game;
public class AssistantPilot extends CrewMember {
	//Can decrease the damage from asteroid belt.
	//Having pilot and assistant pilot has a higher chance of avoiding asteroid belt.
	
	/**
	 * Set assistant pilot's name, health, repair ability and search ability
	 * @param name	Assistant pilot's name given by player
	 */
	public AssistantPilot(String name) {
		super(name, "assistant pilot", 80, 20, 15);
	}
}

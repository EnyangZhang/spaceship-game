package game;
public class Doctor extends CrewMember {
	//Can heal the crew members with healing item and doubles the healing value of an item.
	
	/**
	 * Set doctor's name, health, repair ability and search ability
	 * @param name	Doctor's name given by player
	 */
	public Doctor(String name) {
		super(name, "doctor", 100, 5, 5);
	}
	
	/**
	 * Special ability of a doctor crew member that doubles the healing value
	 * @param patient	A crew member that needs healing
	 * @param medicine	A medicine item that is applied to a crew member
	 */
	public void healOther(CrewMember patient, MedicalItem medicine) {
		if (this.numberOfActions == 0) {
			System.out.printf("%s cannot perform anymore actions for today.\n", this.getName());	
		} else {
			if (patient.addHealth(medicine.getValue() * 2)) {
				this.numberOfActions -= 1;
				Crew.getMedicalItems().remove(medicine);
			} 
		}
	}
}
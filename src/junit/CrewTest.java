package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Crew;
import game.CrewMember;
import game.Food;

class CrewTest {
	private CrewMember testCrewMember;
	
	@BeforeEach
	public void init() {
		Crew.setName("LugtuFam");
		Crew.setShipName("HondaFit");
		testCrewMember = new CrewMember("Rchi", "pilot", 80, 20, 50);
	}
	
	@Test
	public void getNameTest() {
		assertEquals("LugtuFam", Crew.getName());
	}

	@Test
	public void getShipNameTest() {
		assertEquals("HondaFit", Crew.getShipName());
	}
	
	@Test
	public void getShieldLevel() {
		assertEquals(1000, Crew.getShieldLevel());
	}
	
	@Test
	public void addShipLevelTest() {
		assertEquals(false, Crew.addShipLevel(100));
		Crew.minusShipLevel(100);
		assertEquals(true, Crew.addShipLevel(150));
		Crew.minusShipLevel(200);
		assertEquals(true, Crew.addShipLevel(100));
	}
	
	@Test
	public void addCrewTest() {
		Crew.addCrew(testCrewMember);
//		assertEquals(testCrewMember, Crew.getCrew());
	}
	
	@Test
	public void removeCrewTest() {
		assertEquals(false, Crew.removeCrew(testCrewMember));
		Crew.addCrew(testCrewMember);
		assertEquals(true, Crew.removeCrew(testCrewMember));
	}
	
	@Test
	public void getCrewTest() {
		
	}
	
	@Test
	public void getMedicalItemsTest() {
		
	}
	
	@Test
	public void setMedicalItemsTest() {
		
	}
	
	@Test
	public void getFoodsTest() {
		
	}
	
	@Test
	public void setFoodsTest() {
		
	}
	
	@Test
	public void amountOfMoneyTest() {
		assertEquals(100, Crew.getAmountOfMoney());
		Crew.addMoney(50);
		assertEquals(150, Crew.getAmountOfMoney());
		Food chicken = new Food("chicken", 38, 30);
		Crew.minusMoney(chicken);
		assertEquals(112, Crew.getAmountOfMoney());
	}
}
package junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.Crew;
import game.CrewMember;
import game.Food;
import game.MedicalItem;

class CrewMemberTest {
	private CrewMember testCrewMember;

	
	@BeforeEach
	public void init() {
		testCrewMember = new CrewMember("Rchi", "pilot", 80, 20, 50);	
	}
	
	@Test
	public void getNameTest() {
		testCrewMember.setName("MelissaLugtu");
		assertEquals("MelissaLugtu", testCrewMember.getName());
	}
	
	@Test
	public void getTypeTest() {
		assertEquals("pilot", testCrewMember.getType());
	}
	
	@Test
	public void getHealthTest() {
		testCrewMember.addHealth(500);
		assertEquals(80, testCrewMember.getHealth());
	}
	
	@Test
	public void addHealthTest() {
		assertEquals(false, testCrewMember.addHealth(100));
		testCrewMember.minusHealth(10);
		assertEquals(true, testCrewMember.addHealth(5));
		testCrewMember.addHealth(100);
	}
	
	@Test
	public void getMaxHealthTest() {
		testCrewMember.addHealth(500);
		assertEquals(80, testCrewMember.getMaxHealth());
	}
	
	@Test
	public void minusHealthTest() {
		assertEquals(true, testCrewMember.minusHealth(20));
		assertEquals(false, testCrewMember.minusHealth(100));
	}
	
	@Test
	public void addHungerTest() {
		testCrewMember.addHunger(80);
		assertEquals(80, testCrewMember.getHunger());
		testCrewMember.addHunger(30);
		assertEquals(100, testCrewMember.getHunger());
	}
	
	@Test
	public void minusHungerTest() {
		assertEquals(false, testCrewMember.minusHunger(20));
		testCrewMember.addHunger(50);
		assertEquals(true, testCrewMember.minusHunger(20));
		assertEquals(true, testCrewMember.minusHunger(100));
	}
	
	@Test
	public void addTirednessTest() {
		testCrewMember.addTiredness(85);
		assertEquals(85, testCrewMember.getTiredness());
		testCrewMember.addTiredness(150);
		assertEquals(100, testCrewMember.getTiredness());
	}
	
	@Test
	public void minusTirednessTest() {
		assertEquals(false, testCrewMember.minusTiredness(20));
		testCrewMember.addTiredness(20);
		assertEquals(true, testCrewMember.minusTiredness(15));
		assertEquals(true, testCrewMember.minusTiredness(25));
	}
	
	@Test
	public void minusActionNumberTest() {
		testCrewMember.minusActionNumber();
		testCrewMember.minusActionNumber();
		testCrewMember.minusActionNumber();
		assertEquals(0, testCrewMember.getActionNumber());
	}
	
	@Test
	public void resetActionNumberTest() {
		testCrewMember.resetActonNumber();
		assertEquals(2, testCrewMember.getActionNumber());
	}
	
	@Test
	public void getSickTest() {
		assertEquals(false, testCrewMember.sickCheck());
		testCrewMember.getSick();
		testCrewMember.getSick();
		assertEquals(true, testCrewMember.sickCheck());
	}
	
	@Test
	public void healSickTest() {
		testCrewMember.getSick();
		testCrewMember.healSick();
		assertEquals(false, testCrewMember.sickCheck());	
	}
	
	@Test
	public void feedTest() {
		Food candy = new Food("candy", 7, 5);
		testCrewMember.addHunger(10);
		testCrewMember.feed(candy);
		assertEquals(5, testCrewMember.getHunger());
		testCrewMember.minusActionNumber();
		testCrewMember.minusActionNumber();
		testCrewMember.feed(candy);
	}
	
	@Test
	public void applyMedicalItemTest() {
		MedicalItem bandage = new MedicalItem("bandage", 20, 10);
		MedicalItem potion = new MedicalItem("potion", 40, 30);
		testCrewMember.minusHealth(15);
		testCrewMember.applyMedicalItem(bandage);
		testCrewMember.getSick();
		testCrewMember.applyMedicalItem(potion);
		testCrewMember.minusActionNumber();
		testCrewMember.minusActionNumber();
		testCrewMember.applyMedicalItem(potion);
	}
	
	@Test
	public void sleepTest() {
		testCrewMember.addTiredness(30);
		testCrewMember.sleep();
		assertEquals(5, testCrewMember.getTiredness());
		assertEquals(1, testCrewMember.getActionNumber());
		testCrewMember.minusActionNumber();
		testCrewMember.minusActionNumber();
		testCrewMember.sleep();
	}
	
	@Test
	public void repairTheShieldOfSpaceshipTest() {
		Crew.minusShipLevel(50);
		testCrewMember.repairTheShieldsOfSpaceship();
		testCrewMember.minusActionNumber();
		testCrewMember.minusActionNumber();
		testCrewMember.repairTheShieldsOfSpaceship();
	}
	
	@Test
	public void toStringTest() {
		System.out.println(testCrewMember);
		testCrewMember.addHunger(90);
		testCrewMember.addTiredness(90);
		testCrewMember.getSick();
		System.out.println(testCrewMember);
	}
	
	@Test
	public void searchTransporterTest() {
		testCrewMember.searchTransporterParts();
		testCrewMember.minusActionNumber();
		testCrewMember.minusActionNumber();
		assertEquals(false, testCrewMember.searchTransporterParts());
	}
	
	@Test
	public void searchItemTest() {
		
	}
}
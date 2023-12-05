package Gui;

import java.util.* ;

import game.CrewMember;

/**
 * @author Hezekiah Dacillo
 * @author Enyang Zhang
 *
 */
public class GameManager {


	public void launchStartScreen() {
		StarGameScreen starWindow = new StarGameScreen(this);
	}
	
	public void closeStarScreen(StarGameScreen window) {
		window.closeWindow();
		
	}

	public void launchSetupScreen() {
		SetupGameScreen setupWindow = new SetupGameScreen(this);
	}
	
	public void closeSetupScreen(SetupGameScreen window) {
		window.closeWindow();
	}
	
	public void launchNameInputScreen(int type, String info1, String info2) {
		NameInput nameWindow = new NameInput(this, type, info1, info2);
	}
	
	public void closeNameInputScreen(NameInput window) {
		window.closeWindow();
	}
	
	public void launchAlertScreen(int alertVersion) {
		alert Window = new alert(this, alertVersion);
	}
	
	public void closeAlertScreen(alert window) {
		window.closeWindow();
	}
	
	public void launchGameScreen() {
		GameScreen Window = new GameScreen(this);
	}
	
	public void closeGameScreen(GameScreen window) {
		window.closeWindow();
	}
	public void launchOutpostScreen() {
		Outpost Window = new Outpost(this);
	}
	
	public void closeOutpostScreen(Outpost window) {
		window.closeWindow();
	}
	
	public void launchEatingScreen(CrewMember crew) {
		Eating Window = new Eating(this, crew);
	}
	
	public void closeEatingScreen(Eating window) {
		window.closeWindow();
	}
	
	public void launchHealingScreen(CrewMember crew) {
		Healing Window = new Healing(this, crew);
	}
	
	public void closeHealingScreen(Healing window) {
		window.closeWindow();
	}
	
	public void launchEndingScreen(int end) {
		Ending Window = new Ending(this, end);
	}
	
	public void closeEndingScreen(Ending window) {
		window.closeWindow();
	}
	
	public void launchPilotScreen() {
		Pilot Window = new Pilot(this);
	}
	
	public void closePilotScreen(Pilot window) {
		window.closeWindow();
	}
	public static void main(String[] args) {
		GameManager gameManager = new GameManager();
		gameManager.launchStartScreen();
	}
}
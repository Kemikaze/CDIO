package controllers;

import desktop_fields.Brewery;
import desktop_fields.Chance;
import desktop_fields.Field;
import desktop_fields.Jail;
import desktop_fields.Refuge;
import desktop_fields.Start;
import desktop_fields.Street;
import desktop_fields.Tax;
import desktop_fields.Shipping;
import desktop_resources.GUI;
import entities.Ownable;
import entities.Parking;
import entities.RailRoad;
import entities.TryYourLuck;
import entities.Utility;
import entities.Shaker;
import entities.Text;
import entities.PercentageTax;
import entities.FixedTax;

import java.awt.Color;
import java.io.IOException;

import desktop_codebehind.Car;
import desktop_board.Board;
import entities.Property;

/**
 * @author Emil Jørgensen
 */
public class mGUI {
	
	private Text TitleFile = new Text("FieldTitles.txt");
	GameBoard FieldList = new GameBoard();
	private String[] TitleList = null;
	Game game;
	
	/**
	 * Creates the board 
	 */
	public void CreateBoard(){
		{
			FieldList.CreateBoardFromTextFile();
			Field[] Fields = new Field[40];
			
			Fields[0] = new Start.Builder().
					setBgColor(FieldList.getFieldList().get(1).getColour()).
					setTitle(FieldList.getFieldList().get(1).getTitle()).
					setSubText("").
					build();
			Fields[1] = new Street.Builder().setBgColor(FieldList.getFieldList().get(2).getColour()).
					setDescription(FieldList.getFieldList().get(2).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(2)).toString(((Ownable) FieldList.getFieldList().get(2)).getRent())).
					setTitle(FieldList.getFieldList().get(2).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(2)).getSub()).
					build();
			Fields[2] = new Chance.Builder().setBgColor(FieldList.getFieldList().get(3).getColour()).
					setSubText(FieldList.getFieldList().get(3).getTitle()).
					setDescription(FieldList.getFieldList().get(3).getDescription()).
					setFgColor(((TryYourLuck) FieldList.getFieldList().get(3)).getTxColour()).
					build();
			Fields[3] = new Street.Builder().setBgColor(FieldList.getFieldList().get(4).getColour()).
					setDescription(FieldList.getFieldList().get(4).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(4)).toString(((Ownable) FieldList.getFieldList().get(4)).getRent())).
					setTitle(FieldList.getFieldList().get(4).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(4)).getSub()).
					build();
			Fields[4] = new Tax.Builder().setBgColor(FieldList.getFieldList().get(5).getColour()).
					setDescription(FieldList.getFieldList().get(5).getDescription()).
					setSubText(((FixedTax) FieldList.getFieldList().get(5)).getSubtext()).
					setTitle(FieldList.getFieldList().get(5).getTitle()).
					build();
			Fields[5] = new Shipping.Builder().setBgColor(FieldList.getFieldList().get(6).getColour()).
					setDescription(FieldList.getFieldList().get(6).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(6)).toString(((Ownable) FieldList.getFieldList().get(6)).getRent())).
					setTitle(FieldList.getFieldList().get(6).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(6)).getSub()).
					setFgColor(((RailRoad) FieldList.getFieldList().get(6)).getTxColour()).
					build();
			Fields[6] = new Street.Builder().setBgColor(FieldList.getFieldList().get(7).getColour()).
					setDescription(FieldList.getFieldList().get(7).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(7)).toString(((Ownable) FieldList.getFieldList().get(7)).getRent())).
					setTitle(FieldList.getFieldList().get(7).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(7)).getSub()).
					build();
			Fields[7] = new Chance.Builder().setBgColor(FieldList.getFieldList().get(8).getColour()).
					setFgColor(((TryYourLuck) FieldList.getFieldList().get(8)).getTxColour()).
					setDescription(FieldList.getFieldList().get(8).getDescription()).
					setSubText(FieldList.getFieldList().get(8).getTitle()).
					build();
			Fields[8] = new Street.Builder().setBgColor(FieldList.getFieldList().get(9).getColour()).
					setDescription(FieldList.getFieldList().get(9).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(9)).toString(((Ownable) FieldList.getFieldList().get(9)).getRent())).
					setTitle(FieldList.getFieldList().get(9).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(9)).getSub()).
					build();
			Fields[9] = new Street.Builder().setBgColor(FieldList.getFieldList().get(10).getColour()).
					setDescription(FieldList.getFieldList().get(10).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(10)).toString(((Ownable) FieldList.getFieldList().get(10)).getRent())).
					setTitle(FieldList.getFieldList().get(10).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(10)).getSub()).
					build();
			Fields[10] = new Jail.Builder().setBgColor(FieldList.getFieldList().get(11).getColour()).
					setFgColor(((entities.Jail) FieldList.getFieldList().get(11)).getTxColour()).
					setTitle(FieldList.getFieldList().get(11).getTitle()).
					setDescription(FieldList.getFieldList().get(11).getDescription()).
					setSubText(((entities.Jail) FieldList.getFieldList().get(11)).getSubtext()).
					build();
			Fields[11] = new Street.Builder().setBgColor(FieldList.getFieldList().get(12).getColour()).
					setDescription(FieldList.getFieldList().get(12).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(12)).toString(((Ownable) FieldList.getFieldList().get(12)).getRent())).
					setTitle(FieldList.getFieldList().get(12).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(12)).getSub()).
					build();
			Fields[12] = new Brewery.Builder().setBgColor(FieldList.getFieldList().get(13).getColour()).
					setDescription(FieldList.getFieldList().get(13).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(13)).toString(((Ownable) FieldList.getFieldList().get(13)).getRent())).
					setTitle(FieldList.getFieldList().get(13).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(13)).getSub()).
					setFgColor(((Utility) FieldList.getFieldList().get(13)).getTxColour()).
					build();
			Fields[13] = new Street.Builder().setBgColor(FieldList.getFieldList().get(14).getColour()).
					setDescription(FieldList.getFieldList().get(14).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(14)).toString(((Ownable) FieldList.getFieldList().get(14)).getRent())).
					setTitle(FieldList.getFieldList().get(14).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(14)).getSub()).
					build();
			Fields[14] = new Street.Builder().setBgColor(FieldList.getFieldList().get(15).getColour()).
					setDescription(FieldList.getFieldList().get(15).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(15)).toString(((Ownable) FieldList.getFieldList().get(15)).getRent())).
					setTitle(FieldList.getFieldList().get(15).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(15)).getSub()).
					build();
			Fields[15] = new Shipping.Builder().setBgColor(FieldList.getFieldList().get(16).getColour()).
					setDescription(FieldList.getFieldList().get(16).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(16)).toString(((Ownable) FieldList.getFieldList().get(16)).getRent())).
					setTitle(FieldList.getFieldList().get(16).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(16)).getSub()).
					setFgColor(((RailRoad) FieldList.getFieldList().get(16)).getTxColour()).
					build();
			Fields[16] = new Street.Builder().setBgColor(FieldList.getFieldList().get(17).getColour()).
					setDescription(FieldList.getFieldList().get(17).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(17)).toString(((Ownable) FieldList.getFieldList().get(17)).getRent())).
					setTitle(FieldList.getFieldList().get(17).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(17)).getSub()).
					build();
			Fields[17] = new Chance.Builder().setBgColor(FieldList.getFieldList().get(18).getColour()).
					setFgColor(((TryYourLuck) FieldList.getFieldList().get(18)).getTxColour()).
					setDescription(FieldList.getFieldList().get(18).getDescription()).
					setSubText(FieldList.getFieldList().get(18).getTitle()).
					build();
			Fields[18] = new Street.Builder().setBgColor(FieldList.getFieldList().get(19).getColour()).
					setDescription(FieldList.getFieldList().get(19).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(19)).toString(((Ownable) FieldList.getFieldList().get(19)).getRent())).
					setTitle(FieldList.getFieldList().get(19).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(19)).getSub()).
					build();
			Fields[19] = new Street.Builder().setBgColor(FieldList.getFieldList().get(20).getColour()).
					setDescription(FieldList.getFieldList().get(20).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(20)).toString(((Ownable) FieldList.getFieldList().get(20)).getRent())).
					setTitle(FieldList.getFieldList().get(20).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(20)).getSub()).
					build();
			Fields[20] = new Refuge.Builder().setBgColor(FieldList.getFieldList().get(21).getColour()).
					setSubText(FieldList.getFieldList().get(21).getTitle()).
					setDescription(FieldList.getFieldList().get(21).getDescription()).
					setBgColor(((Parking) FieldList.getFieldList().get(21)).getColour()).
					setFgColor(((Parking) FieldList.getFieldList().get(21)).getTxColour()).
					setSubText(((Parking) FieldList.getFieldList().get(21)).getSubtext()).
					build();
			Fields[21] = new Street.Builder().setBgColor(FieldList.getFieldList().get(22).getColour()).
					setDescription(FieldList.getFieldList().get(22).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(22)).toString(((Ownable) FieldList.getFieldList().get(22)).getRent())).
					setTitle(FieldList.getFieldList().get(22).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(22)).getSub()).
					build();
			Fields[22] = new Chance.Builder().setBgColor(FieldList.getFieldList().get(23).getColour()).
					setFgColor(((TryYourLuck) FieldList.getFieldList().get(23)).getTxColour()).
					setDescription(FieldList.getFieldList().get(23).getDescription()).
					setSubText(FieldList.getFieldList().get(23).getTitle()).
					build();
			Fields[23] = new Street.Builder().setBgColor(FieldList.getFieldList().get(24).getColour()).
					setDescription(FieldList.getFieldList().get(24).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(24)).toString(((Ownable) FieldList.getFieldList().get(24)).getRent())).
					setTitle(FieldList.getFieldList().get(24).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(24)).getSub()).
					build();
			Fields[24] = new Street.Builder().setBgColor(FieldList.getFieldList().get(25).getColour()).
					setDescription(FieldList.getFieldList().get(25).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(25)).toString(((Ownable) FieldList.getFieldList().get(25)).getRent())).
					setTitle(FieldList.getFieldList().get(25).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(25)).getSub()).
					build();
			Fields[25] = new Shipping.Builder().setBgColor(FieldList.getFieldList().get(26).getColour()).
					setDescription(FieldList.getFieldList().get(26).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(26)).toString(((Ownable) FieldList.getFieldList().get(26)).getRent())).
					setTitle(FieldList.getFieldList().get(26).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(26)).getSub()).
					setFgColor(((RailRoad) FieldList.getFieldList().get(26)).getTxColour()).
					build();
			Fields[26] = new Street.Builder().setBgColor(FieldList.getFieldList().get(27).getColour()).
					setDescription(FieldList.getFieldList().get(27).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(27)).toString(((Ownable) FieldList.getFieldList().get(27)).getRent())).
					setTitle(FieldList.getFieldList().get(27).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(27)).getSub()).
					build();
			Fields[27] = new Street.Builder().setBgColor(FieldList.getFieldList().get(28).getColour()).
					setDescription(FieldList.getFieldList().get(28).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(28)).toString(((Ownable) FieldList.getFieldList().get(28)).getRent())).
					setTitle(FieldList.getFieldList().get(28).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(28)).getSub()).
					build();
			Fields[28] = new Brewery.Builder().setBgColor(FieldList.getFieldList().get(29).getColour()).
					setDescription(FieldList.getFieldList().get(29).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(29)).toString(((Ownable) FieldList.getFieldList().get(29)).getRent())).
					setTitle(FieldList.getFieldList().get(29).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(29)).getSub()).
					setFgColor(((Utility) FieldList.getFieldList().get(29)).getTxColour()).
					build();
			Fields[29] = new Street.Builder().setBgColor(FieldList.getFieldList().get(30).getColour()).
					setDescription(FieldList.getFieldList().get(30).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(30)).toString(((Ownable) FieldList.getFieldList().get(30)).getRent())).
					setTitle(FieldList.getFieldList().get(30).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(30)).getSub()).
					build();
			Fields[30] = new Jail.Builder().setBgColor(FieldList.getFieldList().get(31).getColour()).
					setTitle(FieldList.getFieldList().get(31).getTitle()).
					setFgColor(((entities.GoToJail) FieldList.getFieldList().get(31)).getTxColour()).
					setDescription(FieldList.getFieldList().get(31).getDescription()).
					setSubText(((entities.GoToJail) FieldList.getFieldList().get(31)).getSubtext()).
					build();
			Fields[31] = new Street.Builder().setBgColor(FieldList.getFieldList().get(32).getColour()).
					setDescription(FieldList.getFieldList().get(32).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(32)).toString(((Ownable) FieldList.getFieldList().get(32)).getRent())).
					setTitle(FieldList.getFieldList().get(32).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(32)).getSub()).
					build();
			Fields[32] = new Street.Builder().setBgColor(FieldList.getFieldList().get(33).getColour()).
					setDescription(FieldList.getFieldList().get(33).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(33)).toString(((Ownable) FieldList.getFieldList().get(33)).getRent())).
					setTitle(FieldList.getFieldList().get(33).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(33)).getSub()).
					build();
			Fields[33] = new Chance.Builder().setBgColor(FieldList.getFieldList().get(34).getColour()).
					setFgColor(((TryYourLuck) FieldList.getFieldList().get(34)).getTxColour()).
					setDescription(FieldList.getFieldList().get(34).getDescription()).
					setSubText(FieldList.getFieldList().get(34).getTitle()).
					build();
			Fields[34] = new Street.Builder().setBgColor(FieldList.getFieldList().get(35).getColour()).
					setDescription(FieldList.getFieldList().get(35).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(35)).toString(((Ownable) FieldList.getFieldList().get(35)).getRent())).
					setTitle(FieldList.getFieldList().get(35).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(35)).getSub()).
					build();
			Fields[35] = new Shipping.Builder().setBgColor(FieldList.getFieldList().get(36).getColour()).
					setDescription(FieldList.getFieldList().get(36).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(36)).toString(((Ownable) FieldList.getFieldList().get(36)).getRent())).
					setTitle(FieldList.getFieldList().get(36).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(36)).getSub()).
					setFgColor(((RailRoad) FieldList.getFieldList().get(36)).getTxColour()).
					build();
			Fields[36] = new Chance.Builder().setBgColor(FieldList.getFieldList().get(37).getColour()).
					setFgColor(((TryYourLuck) FieldList.getFieldList().get(37)).getTxColour()).
					setDescription(FieldList.getFieldList().get(37).getDescription()).
					setSubText(FieldList.getFieldList().get(37).getTitle()).
					build();
			Fields[37] = new Street.Builder().setBgColor(FieldList.getFieldList().get(38).getColour()).
					setDescription(FieldList.getFieldList().get(38).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(38)).toString(((Ownable) FieldList.getFieldList().get(38)).getRent())).
					setTitle(FieldList.getFieldList().get(38).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(38)).getSub()).
					build();
			Fields[38] = new Tax.Builder().setBgColor(FieldList.getFieldList().get(39).getColour()).
					setDescription(FieldList.getFieldList().get(39).getDescription()).
					setSubText(((PercentageTax) FieldList.getFieldList().get(39)).getSubtext()).
					setTitle(FieldList.getFieldList().get(39).getTitle()).build();
			Fields[39] = new Street.Builder().setBgColor(FieldList.getFieldList().get(40).getColour()).
					setDescription(FieldList.getFieldList().get(40).getDescription()).
					setRent(((Ownable) FieldList.getFieldList().get(40)).toString(((Ownable) FieldList.getFieldList().get(40)).getRent())).
					setTitle(FieldList.getFieldList().get(40).getTitle()).
					setSubText(((Ownable) FieldList.getFieldList().get(40)).getSub()).
					build();
				GUI.create(Fields);
			}
	}
	
	/**
	 * Creates a color for the car. Allows six players
	 * @param c
	 * @return
	 */
	public Color getColor(int c)
	{
		Color color = null;
		switch(c){
		case 0 : color = Color.RED;
		break;
		case 1 : color = Color.BLUE;
		break;
		case 2 : color = Color.YELLOW;
		break;
		case 3 : color = Color.PINK;
		break;
		case 4 : color = Color.ORANGE;
		break;
		case 5 : color = Color.MAGENTA;
		}
		return color;
	}
	
	/**
	 * Adds a player, with car, to the board
	 * @param game
	 * @param v
	 * @param c
	 */
	public void addPlayer(Game game, int v)
	{
		Car car = new Car.Builder().secondaryColor(getColor(v)).build();
		GUI.addPlayer(game.playerList.get(v).getName(), game.playerList.get(v).getAccount().getBalance(),car);
	}
	
	
	/**
	 * Displays a message to the user and awaits a response
	 * @param msg The message shown to the user
	 * @return A string from the user
	 */
	public String getUserString(String msg)
	{
		return GUI.getUserString(msg);
	}
	
	/**
	 * Displays a single button on screen for the player to press
	 * @param msg1 The message prompt to the user
	 * @param msg2 The text on the button
	 */
	public void getButton(String msg1, String msg2){
		GUI.getUserButtonPressed(msg1, msg2);
	}
	
	/**
	 * Displays two buttons on screen for the player to press, one returning true, the other returning false.
	 * @param msg1 The message prompt to the user
	 * @param msg2 The text on the true-button
	 * @param msg3 The text on the false-button
	 * @return True or false
	 */
	public boolean get2Buttons(String msg1, String msg2, String msg3){
		return GUI.getUserLeftButtonPressed(msg1, msg2, msg3);
	}
	
	/**
	 * Gets a drop down menu of the 40 fields for the player to choose from 
	 * @return An int corresponding to the field number of the field chosen
	 */
	public int getFieldChoice(){
		int ret = 0;
		try {
			TitleList = TitleFile.OpenFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		switch(GUI.getUserSelection("Choose a field",TitleList[2] ,TitleList[4],TitleList[6],TitleList[7],TitleList[9],
				TitleList[10],TitleList[12],TitleList[13],TitleList[14],TitleList[15],TitleList[16],TitleList[17],TitleList[19],
				TitleList[20],TitleList[22],TitleList[24],TitleList[25],TitleList[26],TitleList[27],TitleList[28],TitleList[29],
				TitleList[30],TitleList[32],TitleList[33],TitleList[35],TitleList[36],TitleList[38],TitleList[40])){

		case "Old Kent Road":ret = 2;
		break;

		case "Whitechapel Road":ret = 4;
		break;

		case "LB Ferries":ret = 6;
		break;

		case "Islington":ret = 7;
		break;

		case "Euston Road":ret = 9;
		break;

		case "Pentonville Road":ret = 10;
		break;

		case "Pall Mall":ret = 12;
		break;
		
		case "Tuborg":ret = 13;
		break;

		case "Whitehall":ret = 14;
		break;

		case "Northumberland":ret =15;
		break;

		case "DSB Ferry":ret = 16;
		break;

		case "Bow Street":ret = 17;
		break;

		case "Malborough Street":ret = 19;
		break;

		case "Vine Street":ret = 20;
		break;

		case "Strand":ret = 22;
		break;

		case "Fleet Street":ret = 24;
		break;

		case "Trefalgar Square":ret = 25;
		break;

		case "Mols-Line":ret = 26;
		break;

		case "Leicester Suuare":ret = 27;
		break;

		case "Coventry Street":ret = 28;
		break;
		
		case "Carlsberg":ret = 29;
		break;

		case "Piccadilly":ret = 30;
		break;

		case "Regent Street":ret = 32;
		break;

		case "Oxford Street":ret = 33;
		break;

		case "Bond Street":ret = 35;
		break;
		
		case "Scandlines":ret = 36;
		break;

		case "Park Lane":ret = 38;
		break;

		case "Mayfair":ret = 40;
		}
		return ret;
	}
	
	/**
	 * Shows a message prompt to the player
	 * @param msg The message
	 */
	public void showMessage(String msg){
		GUI.showMessage(msg);
	}
	
	/**
	 * Gets three buttons for the player to click
	 * @param msg The message prompt to the player
	 * @param bt1 The string on the left most button
	 * @param bt2 The string on the middle button
	 * @param bt3 THe string on the right most button
	 * @return The string of the button pressed
	 */
	public String get3Buttons(String msg, String bt1, String bt2, String bt3){
		return GUI.getUserButtonPressed(msg, bt1, bt2, bt3);
	}
	
	/**
	 * Gets an integer value from the user
	 * @param msg The message promt to the user
	 * @return An int specified by the user
	 */
	public int getUserInt(String msg){
		return GUI.getUserInteger(msg);
	}
	
	/**
	 * Plays a turn in the gui
	 * @param game
	 * @param v
	 * @param shaker
	 * @param pos
	 */
	public void playTurn(Game game, int v, Shaker shaker, int pos)
	{
		removeCar(game, v);
		setCar(game, v);
		setDice(shaker);
	}
	
	/**
	 * Shows to dice with given integer values at a random position on the board
	 */
	public void setDice(Shaker shaker)
	{
		GUI.setDice(shaker.getDice1Value(), shaker.getDice2Value());
	}
	
	/**
	 * Sets a car on a given field position (-1) on the board
	 */
	public void setCar(Game game, int v)
	{
		if(game.playerList.get(v).getPosition() == 41)
		{
			removeCar(game,v);
			GUI.setCar(11, game.playerList.get(v).getName());
		}
		else {
		removeCar(game,v);
		GUI.setCar(game.playerList.get(v).getPosition(), game.playerList.get(v).getName());
		}
	}
	
	/**
	 * Shows the Balance of a player on the board
	 */
	public void setBalance(Game game, int v)
	{
		GUI.setBalance(game.playerList.get(v).getName(), game.playerList.get(v).getAccount().getBalance());
	}
	
	/**
	 * sets the car on the start field again.
	 */
	public void setCarOnStart(Game game, int v)
	{
		GUI.setCar(1, game.playerList.get(v).getName());
	}
	
	/**
	 * Sets the car on jail
	 */
	public void setCarOnJail(Game game, int v){
		GUI.setCar(11,game.playerList.get(v).getName());
	}
	
	/**
	 * Removes a car on a given field position (-1) on the board
	 */
	public void removeCar(Game game, int v)
	{
		GUI.removeAllCars(game.playerList.get(v).getName());
	}
	
	/**
	 * Shows a description of the actions performed on a turn in the middle of the board
	 */
	public void displayMidDescription(String text)
	{
		GUI.displayChanceCard(text);
	}
	
	/**
	 * A set method for updating the owners of fields in the GUI. 
	 * @param board
	 * @param player
	 */
	public void setOwner(int pos, String player)
	{
	GUI.setOwner(pos, player);
	}
	
	/**
	 * Removes the owner of a field
	 * @param pos the number of the field to be removed of owner designation
	 */
	public void removeOwner(int pos)
	{
		GUI.removeOwner(pos);
	}
	
	/**
	 * Sets a hotel on the field (and removes
	 * @param field
	 * @param value The boolean value, true for hotel, false for none.
	 */
	public void setHotel(int field, int hotel){
		boolean value;
		if(hotel == 1){
			value = true;
		}
		else {
			value = false;
		}
		GUI.setHotel(field, value);
	}
	
	/**
	 * Sets a given number of houses on a field
	 * @param field
	 * @param house the int value of the number of houses to be set
	 */
	public void setHouse(int field,int house){
		GUI.setHouses(field, house);
	}
}

package entities;

import java.awt.Color;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;

/**
 * @author Emil LandOnField created by Aleksander
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
public class RailRoad extends Ownable{

	private Color TxColour = Color.BLACK;
	private int ownedRailRoads = 0;
	private int RENT_1 = 500;
	private int RENT_2 = 1000;
	private int RENT_3 = 2000;
	private int RENT_4 = 4000;
	
	/**
	 * The constructor for a Railroad field
	 * @param title
	 * @param description
	 * @param subText
	 * @param color
	 * @param player
	 * @param cost
	 * @param rent
	 */
	public RailRoad(int id, String title, String description, String subText, Color color, int player, int cost, int rent, boolean mortgageState) {
		super(id, title,description, subText, color, player, cost, rent, mortgageState);
		super.Colour = Color.WHITE;
	}

	/**
	 *Defines what happens when a player lands on this field
	 */
	@Override
	public void landOnField(Game game, GameBoard gameboard, int boardValue, int playerID, mGUI mui, Shaker shake) {
		if(((Ownable)gameboard.FieldList.get(boardValue)).getOwner() == 0){
			buyProperty(game, gameboard, mui, playerID, boardValue);
			mui.setBalance(game, playerID);
		}
		else if(((Ownable)gameboard.FieldList.get(boardValue)).getOwner() != playerID){
			for(Field item : gameboard.FieldList)
			{
				if((item instanceof RailRoad) && (((Ownable)item).getOwner() == game.playerList.get(((Ownable)gameboard.FieldList.get(boardValue)).getOwner()).getID()))
				{
				ownedRailRoads++;
				}
			}
			payRent(game, playerID, gameboard, boardValue, rent, mui);
		}
	}
	
	public int getRent() 
	{
		int rent = 0;
		switch(ownedRailRoads)
		{
		case 1: rent = RENT_1;
		break;
		case 2: rent = RENT_2;
		break;
		case 3: rent = RENT_3;
		break;
		case 4: rent = RENT_4;
		break;
		}
		return rent;
	}

	@Override
	public String getDescription() {
		return super.Description;
	}

	@Override
	public void setDescription(String desc) {
		super.Description = desc;
	}

	@Override
	public String getTitle() {
		return super.Title;
	}

	@Override
	public void setTitle(String titl) {
		super.Title = titl;
	}

	@Override
	public int getNumber() {
		return 0;
	}

	@Override
	public void setNumber(int numb) {
	}

	@Override
	public void setColour(Color colour) {
		super.Colour = colour;
	}

	@Override
	public Color getColour() {
		return super.Colour;
	}
	
	public String getPicture() {
		return Picture;
	}

	public void setPicture(String url){
		Picture = url;
	}
	
	public Color getTxColour(){
		return TxColour;
	}
	
	public void setTxColour(Color colour){
		TxColour = colour;
	}
	
	public void loadfield() {
		// TODO Auto-generated method stub
	}
}

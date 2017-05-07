/**
 * @author Aleksander & Emil
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package entities;

import java.awt.Color;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.DBconnector;
import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;

/**
 * @author Emil Jørgensen
 *
 */
public abstract class Ownable implements Field {
	//ATTRIBUTES
	protected String Title;
	protected String Description = "";
	protected String SubText;
	protected String Picture;
	protected Color bgColor;
	protected Text file = new Text("BuyProperty.txt");
	protected String[] TxtList = null;
	protected int owned = 0;
	protected int price;
	protected int rent;
	protected int owner;
	protected Color Colour;
	protected boolean mortgage = false;
	protected int FieldID;
	protected DBconnector connector;
	
	/**
	 * Abstract constructor for an ownable field
	 * @param title
	 * @param description
	 * @param subText
	 * @param color
	 * @param playerID
	 * @param cost
	 * @param rent
	 */
	public Ownable(int fieldID,String title, String description, String subText, Color color, int playerID, int cost, int rent)
	{
		FieldID = fieldID;
		Title = title;
		Description = description;
		SubText = subText;
		Colour = color;
		owner = playerID;
		price = cost;
		this.rent = rent;
		try {
			connector.doUpdate("game","INSERT into ownable values(" + fieldID + "," + playerID + ", " + cost + "," + false + " );");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getOwnerFDB(){
		connector.Connect("chance");
		int O = 0;
		try {
		ResultSet rs = connector.doQuery("game","SELECT owner FROM ownable WHERE fieldID = "+ FieldID +";");
		while(rs.next()){
		O = rs.getInt("chancetype");
		}
		connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return O;
	}
	//METHODS
	
	/**
	 * Lets a player buy a field, deducting price and changing owner
	 */
	public void buyField() {
	}
	
	/**
	 * Lets a player unown a Field
	 */
	public void sellField(){
		
	}
	
	/**
	 * The action when a player lands on a specific field
	 */
	public void actionField(){
		
	}
	
	/**
	 * Sets the rent of a field
	 */
	public void setRent(){
		
	}
	
	/**
	 * Gets the rent of a field
	 * @return The rent of the field
	 */
	public int getRent(){
		return rent;
		
	}

	/**
	 * Sets the price of the field
	 */
	public void setPrice(){
		
	}
	
	/**
	 * Gets the price of the field
	 * @return The price of the field
	 */
	public int getPrice(){
		return price;
		
	}
	
	/**
	 * Sets the owner of the field to an integer, corresponding to the player number (int) of the player owning the field
	 */
	public void setOwner(int ID){
		owner = ID;
	}
	
	/**
	 * Returns the owner (integer?) of the field, corresponding to the player number (int) of the player owning the field
	 */
	public int getOwner(){
		
		return owner;
		
	}
	
	/**
	 * Handles the action if a player lands on a field that is owned by another player and need to pay rent
	 */
	public void payRent(Game game, int p, GameBoard gameboard, int b, int rent, mGUI mui){
		game.playerList.get(p).getAccount().addBalance(-rent);
		mui.setBalance(game, p);
		game.playerList.get(((Ownable)gameboard.FieldList.get(b)).getOwner()).getAccount().addBalance(rent);
		mui.setBalance(game, ((Ownable)gameboard.FieldList.get(b)).getOwner());
	}
	
	/**
	 * Sets a field to a mortgaged state
	 */
	public void mortgage(){
		mortgage = true;
	}
	
	/**
	 * Sets a field to an unmortgaged state
	 */
	public void unmortgage(){
		mortgage = false;
	}
	
	/**
	 * Gets the current mortgage state of a field
	 * @return The mortgage state of the field (boolean)
	 */
	public boolean getMortgageState(){
		return mortgage;
	}
	
	/**
	 * Gets the subtext of a  field
	 * @return Subtext
	 */
	public String getSub(){
		return SubText;
	
	}

	/**
	 * Sets the subtext ofa field
	 */
	public void setSub(String sub){
		SubText = sub;
	}
	
	/**
	 * 
	 */
	public String toString(int value)
	{
		String ret = "" + value;
		return ret;
	}
	
	/**
	 * Handles buying the property
	 * @param game
	 * @param gameboard
	 * @param mui
	 * @param playerID
	 * @param boardValue
	 */
	public	void buyProperty(Game game, GameBoard gameboard, mGUI mui, int playerID, int boardValue)
	{
		boolean buyPropperty = mui.get2Buttons("Do you want to buy this property?", "Buy", "Do nothing");
		if (buyPropperty){
	
			game.playerList.get(playerID).getAccount().addBalance(-(((Ownable) gameboard.FieldList.get(boardValue)).getPrice()));
			((Ownable) gameboard.FieldList.get(boardValue)).setOwner(playerID);
			mui.setOwner(boardValue, game.playerList.get(playerID).getName());
		}
	}
	
	public abstract void loadfield();
	
}

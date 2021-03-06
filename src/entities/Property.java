package entities;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.Game;
import controllers.GameBoard;
import controllers.mGUI;
/**
 * @author Emil LandOnField created by Aleksander
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
public class Property extends Ownable {
	
	private int Houses = 0;
	private int Hotel = 0;
	private int RENT1;
	private int RENT2;
	private int RENT3;
	private int RENT4;
	private int RENT5;
	private int Houseprice;
	
	public Property(int id,String title, String description, String subText, Color colour, int player,int cost,int hprice,int rent0,int rent1, int rent2, int rent3, int rent4, int rent5, int house,int hotel, boolean mortgageState) 
	{
		super(id,title, description, subText, colour, player, cost, rent0, mortgageState);
		Houses = house;
		Hotel = hotel;
		RENT1 = rent1;
		RENT2 = rent2;
		RENT3 = rent3;
		RENT4 = rent4;
		RENT5 = rent5;
		Houseprice = hprice;
	}
	
	public void savePropertyDB(int fieldNumber){
		try{
			connector.doUpdate("game","INSERT into property values(" + fieldNumber + "," + rent + ", " + RENT2 + "," + RENT3+ ", " + RENT4+ ", " + RENT5+ ", " + Houseprice+ ", " + Houseprice+ ", " + Houses+ ", " + Hotel + " );");  
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Override

		
	
	public int getRent(){
		return super.rent;
	}
	
	public void setHousePrice(int price){
		Houseprice = price;
	}
	
	public int getHousePrice(){
		return Houseprice;
	}
	
	public int getRent(int value){
		int ret = super.rent;
		switch(value){
		case 0: ret = super.rent;
		break;
		case 1: ret = RENT1;
		break;
		case 2: ret = RENT2;
		break;
		case 3: ret = RENT3;
		break;
		case 4: ret = RENT4;
		break;
		case 5: ret = RENT5;
		}
		return ret;
	}
	
	@Override
	public void landOnField(Game game, GameBoard gameboard, int boardValue, int playerID, mGUI mui, Shaker shake) {
		if(((Ownable)gameboard.FieldList.get(boardValue)).getOwner() == 0){
			buyProperty(game, gameboard, mui, playerID, boardValue);
		}
		else if(((Ownable)gameboard.FieldList.get(boardValue)).getOwner() != playerID){
			if(((Property) gameboard.FieldList.get(boardValue)).getHotel() == 1){
				int rentToPay = getRent(5);
				payRent(game, playerID, gameboard, boardValue, rentToPay, mui);
			}
			else {
				int rentToPay = getRent(((Property)gameboard.FieldList.get(boardValue)).getHouses());
				payRent(game, playerID, gameboard, boardValue, rentToPay, mui);
			}
		}

	}
	
	public void updatePropertyDB(){
		saveHouseDB();
		saveHotelDB();
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
	
	public int getHouses(){
		return Houses;
	}
	
	public void setHouses(int house){
		Houses = Houses + house;
	}
	
	public int getHotel(){
		return Hotel;
	}
	
	public void setHotel(int hotel){
		Hotel = hotel;
	}
	/**
	 * Only add 1 or -1 House at a time
	 * @param houses
	 */
	public void addHouses(int houses){
		this.Houses = this.Houses + houses;
		if(Houses > 4){
			Houses = 0;
			Hotel = 1;
		}
		if(Hotel == 1 && houses == -1){
			Hotel = 0;
			Houses = 4;
		}
	}
	
	public void saveHouseDB(){
		int HousesToSave = getHouses();
		try {
			connector.doUpdate("game", "UPDATE Property SET House = " + HousesToSave + " WHERE FieldID = " + FieldID + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void saveHotelDB(){
		int HotelToSave = getHotel();
		try {
			connector.doUpdate("game", "UPDATE Property SET House = " + HotelToSave + " WHERE FieldID = " + FieldID + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getHouseFDB(int fieldNumber){
		int HousesFDB = 0;
		try {
			ResultSet rs = connector.doQuery("game", "Select House FROM Property WHERE FieldID = " + fieldNumber + ";");
			if(rs.next()){
			HousesFDB = rs.getInt("House");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return HousesFDB;
		
	}
	
	public int gethotelFDB(int fieldNumber){
		int HotelFDB = 0;
		try {
			ResultSet rs = connector.doQuery("game", "Select Hotel FROM Property WHERE FieldID = " + fieldNumber + ";");
			if(rs.next()){
			HotelFDB = rs.getInt("Hotel");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return HotelFDB;
	}

	@Override
	public void loadfield() {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void loadfield() {
//		// TODO Auto-generated method stub
//		setHouses(gethouseFDB());
//		setOwner(getOwnerFDB());
//		setHotel(gethotelFDB());
//	}
	


}

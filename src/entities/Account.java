/**
 * @author Simon
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */

package entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import controllers.DBconnector;

public class Account {
	
	DBconnector connector = new DBconnector();

	/**
	 * Account attributes
	 */
	int ID;
	int money;
	int networth;
	
	/**
	 * Account constructor
	 * @param Money and net worth predefined as 30000
	 */
	public Account(int ID){
		this.ID = ID;
		this.money = 30000;
		this.networth = 30000;
	}
	
	public void saveAccountDB(){
		try{
		connector.doUpdate("game","INSERT into ACCOUNT values(" + ID + "," + money + "," + networth + ");");
		}
		 catch (SQLException e) {
				e.printStackTrace();
		 }
	}
	

	/**
	 * @return money
	 */

	public int getBalance(){
		return money;
	}
	
	/**
	 * add a given amount of money to the balance and net worth
	 */
	public void addBalance(int addmoney){
		int newBalance = this.money + addmoney;
		int newNetworth = networth + addmoney;
		money = newBalance;
		networth = newNetworth;
	}
	
	/**
	 * sets the balance to a specific amount
	 * adds the difference to net worth
	 */
	public void setBalance(int balance){
		int dif = balance - money;
		networth = networth + dif;
		money = balance;
	}
	
	public void setBalanceDB(){
		int balance = money;
		connector.Connect("game");
		try {
			connector.doUpdate("Game","UPDATE ACCOUNT SET Money = " + balance + " WHERE PlayerID = " + ID + ";");
			connector.doUpdate("Game","UPDATE ACCOUNT SET networth = " + networth + " WHERE PlayerID = " + ID + ";");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getBalanceFDB(int playerNumber){
		int balance = 0;
		try {
			ResultSet rs = connector.doQuery("game", "Select Money FROM Account WHERE PlayerID = " + playerNumber + ";");
			if(rs.next()){
			balance = rs.getInt("Money");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return balance;
	}
	
	
	/**
	 * @param Checks if the player has enough money to purchase something at a given price
	 * @return boolean,  false if the player can't pay the price
	 */
	public boolean enoughMoney(int price){
			return money > price;
		
	}

	public void updateAccount(){
		connector.Connect("game");
	
		try {
			ResultSet rs = connector.doQuery("Game","SELECT money, networth FROM ACCOUNT WHERE PlayerID = "+ ID +";");
			int Balance = 0;
			int NW = 0;
			while(rs.next()){
				Balance = rs.getInt("money");
				NW = rs.getInt("networth");
			}
				connector.close();
				if(money != Balance){
					setBalanceDB();
				}
				if(networth != NW){
					setNetworth(networth);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}}
		

	
	public int getNetworth(){
		return networth;
	}
	
	public void setNetworth(int networth){
		this.networth = networth;

	}
	
	
	/**
	 * Load variables from the DB
	 * Being called in loadPlayer
	 */
	public void loadAccount(){
		connector.Connect("game");
	
		try {
			ResultSet rs = connector.doQuery("Game","SELECT money,networth FROM Account WHERE PlayerID = "+ ID +";");

				while(rs.next()){
				money = rs.getInt("money");
				networth = rs.getInt("networth");
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}
}
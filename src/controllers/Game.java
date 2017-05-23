/**
 * @author Aleksander
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Field;
import entities.Ownable;
import entities.Player;
import entities.Property;

public class Game {
static mGUI gui = new mGUI();
GameBoard board = new GameBoard();
DBcreator dbc = new DBcreator();
Scanner scan = new Scanner(System.in);
DBconnector connector = new DBconnector();
public final Object lock = new Object();
public ArrayList<Player> playerList = new ArrayList<Player>();
Chance chance = new Chance();
public Property prop;
Player player = new Player(null, 0);
public volatile int id = 1;
public int numberOfPlayers = 20;


	public void gameStart(){
		System.out.println("Start a new game, or load from memory? Yes = New game, No = Load");
		int answer = scan.nextInt();
		if(answer == 1){
			dbc.DeleteDBTemp("game", connector);
			dbc.DeleteDBTemp("Chance", connector);
			if(dbc.checkDB("game") == false){
				dbc.CreateGame();
				dbc.tbCreatorGame();
				dbc.CreateChance();
				dbc.tbCreatorChance();
				chance.createChance();
				board.CreateBoardFromTextFile();
				playerList.add(player);
				gui.CreateBoard();
				enterPlayers();
				saveDB();
				createPlayerThreads(numberOfPlayers);
			}
		}
			else if(answer == 2){
				board.CreateBoardFromDB();
				Player player = new Player(null, 0);
				playerList.add(player);
				try{
					ResultSet rs = connector.doQuery("game", "Select COUNT(*) AS rowcount FROM player;");
						if(rs.next()){
							numberOfPlayers = rs.getInt("rowcount");
						} 
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println(numberOfPlayers);
				enterPlayersFDB();
				gui.CreateBoard();
			}

		createPlayerThreads(numberOfPlayers);
	}
	
	public void saveDB(){
		for(Field item : board.FieldList){
			if(item instanceof Ownable){
				((Ownable) item).saveOwnableDB(((Ownable) item).getFieldID(), ((Ownable) item).getOwner(), ((Ownable) item).getRent(), ((Ownable) item).setMortgageDB(((Ownable) item).getMortgageState()));
			}
			if(item instanceof Property){
				((Property) item).savePropertyDB(((Ownable)item).getFieldID());
			}
		}
		for(Player item : playerList){
			item.savePlayerDB();
		}
	}
	
	public void updateDB(){
		for(Field item : board.FieldList){
			if(item instanceof Ownable){
				((Ownable) item).updateOwnableDB();
			}
			if(item instanceof Property){
				((Property) item).updatePropertyDB();
			}
		}
		for(Player item : playerList){
			if(item instanceof Player){
				item.updatePlayer();
			}
		}
		
	}
 
	public void enterPlayersFDB(){
		for(int x = 1; x <= numberOfPlayers; x++){
			String name = player.getNameFDB(x);
			int idFDB = player.getPlayerIDFDB(x);
			Player playerFDB = new Player(name, idFDB);
			playerList.add(playerFDB);
			System.out.println(playerList.get(1).getName());
			gui.addPlayer(this, idFDB);
			gui.setCarOnStart(this, id);
			gui.setCar(this, idFDB);
		}
		
	}
	
	public void enterPlayers()
	{
		while (numberOfPlayers < 2 || numberOfPlayers > 6)
		{
			//Message shown to user, to clarify that he needs to put in the correct value of players between 2 and 6.
			numberOfPlayers = gui.getUserInt("Enter Ammount of Players between 2 and 6");
		}
		
		for(int x = 0; x < numberOfPlayers; x++){
			String name = gui.getUserString("Enter a name");
			Player player = new Player(name, id);
			playerList.add(player);
			gui.addPlayer(this, id);
			gui.setCarOnStart(this, id);
			id++;

		}
	}
	/**
	 * Creates the different threads for the game.
	 * @param playersInGame
	 */
	public void createPlayerThreads(int playersInGame)
	{
			for(int x = 1; x <= playersInGame; x++){
		synchronized(lock){
			
		}
		PlayTurn thread = new PlayTurn("x", playerList.get(x).getID(), this, this.board);
		thread.start();
			}
			synchronized(lock){
			
			id = 1;
			lock.notifyAll();
			}
		}

	
	public void gameWinner(){
		for(Player item : playerList){
			
		}
	}

	
	public int gameId(){
		if(id == numberOfPlayers){
			id = 1;
		}
		else id++;
		return id;
	}

}

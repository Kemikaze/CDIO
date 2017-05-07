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

public int numberOfPlayers = 20;
public volatile int id = 1;

	public void gameStart(){
		System.out.println("Start a new game, or load from memory? Yes = New game, No = Load");
		String answer = scan.nextLine();
		if(answer == "Yes"){
			dbc.DeleteDBTemp("game", connector);
			if(dbc.checkDB("game") == false){
				dbc.CreateGame();
				dbc.tbCreatorGame();
			}
				dbc.DeleteDBTemp("Chance", connector);
				if(dbc.checkDB("chance") == false){
				dbc.CreateChance();
				dbc.tbCreatorChance();
				chance.createChance();
				}
		}
		else {
			for(int i = 1; i <= 40 ; i++){
				if(board.getField(i) instanceof Ownable){
					Ownable Ownable = (Ownable)board.getField(i);
					Ownable.loadfield();
				}
			}
			
		}
		board.CreateBoard();
		playerList.add(null);
		gui.CreateBoard();

		enterPlayers();
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
				this.createPlayerThreads(numberOfPlayers);
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

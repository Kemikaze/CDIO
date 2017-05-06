package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Player;
import language.Language;

public class Game {
static mGUI gui = new mGUI();
GameBoard board = new GameBoard();
DBcreator dbc = new DBcreator();
Scanner scan = new Scanner(System.in);
DBconnector connector = new DBconnector();
public final Object lock = new Object();

public ArrayList<Player> playerList = new ArrayList<Player>();

int numberOfPlayers = 3;
public volatile int id = 1;

	public void gameStart(){
		
		dbc.DeleteDBTemp("game", connector);
		if(dbc.checkDB("game") == false){
			dbc.CreateGame();
			dbc.tbCreatorGame();
		}
		if(dbc.checkDB("chance") == false){
			dbc.CreateChance();
		}
		System.out.println("Choose Language (Dansk/English)");
		Language.chooseLanguage(scan.nextLine());
		board.CreateBoard();
		gui.CreateBoard();

		enterPlayers();
	}

	public void enterPlayers()
	{
		while (numberOfPlayers < 2 && numberOfPlayers > 6)
		{
			//Message shown to user, to clarify that he needs to put in the correct value of players between 2 and 6.
			numberOfPlayers = gui.getUserInt("Enter Ammount of Players between 2 and 6");
		}
		
		for(int x = 0; x < numberOfPlayers; x++){
			String name = gui.getUserString("Enter a name");
			Player player = new Player(name, id);
			playerList.add(player);
			id++;

		}
		id = 1;
				this.createPlayerThreads(numberOfPlayers);
	}
	/**
	 * Creates the different threads for the game.
	 * @param playersInGame
	 */
	public void createPlayerThreads(int playersInGame)
	{
		synchronized(lock){
			for(int x = 0; x < playersInGame; x++){
		PlayTurn thread = new PlayTurn(playerList.get(0).getID(), this);
		thread.start();
		System.out.println("started thread" + x);
		}
		}
	

	}
	public int gameId(){
		return id;
	}

}

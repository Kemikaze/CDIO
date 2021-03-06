/**
 * @author Simon
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package entities;

import java.sql.SQLException;

public class RailroadMove extends ChanceCard{

	public RailroadMove(int ID, int Type, String Des) {
		super(ID, Type, Des);
		// TODO Auto-generated constructor stub
	}

	public void addToDB(){
		try {
			connector.doUpdate("chance","INSERT into Chance values(" + ID + "," + Type + ", '" + Description + "');");
			connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void removeChance(ChanceCard card) {
		connector.Connect("chance");
		try {
			connector.doUpdate("Chance","DELETE FROM chance WHERE " + card.getChanceID() +  "= ChanceID;");
				connector.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loadChance() {
		// TODO Auto-generated method stub
		ID = getdbID();
		Type = getdbType();
		
	}
}

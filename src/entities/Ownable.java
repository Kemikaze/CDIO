/**
 * @author Aleksander & Emil
 * Gruppe 
 * 02362 Projekt i software-udvikling 
 */
package entities;

public abstract class Ownable implements Field {
	//ATTRIBUTES
	
	int price;
	int rent;
	Player owner;
	boolean mortgage;
	
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
	public void setOwner(){
		
	}
	
	/**
	 * Returns the owner (integer?) of the field, corresponding to the player number (int) of the player owning the field
	 */
	public void getOwner(){
		
	}
	
	/**
	 * Handles the action if a player lands on a field that is owned by another player and need to pay rent
	 */
	public void payRent(){
		
	}
	
	/**
	 * Tages senere
	 * @return
	 */
	public int playerOwned(){
		return (tages senere) ;
		
	}
	
	/**
	 * Sets a field to a mortgaged state
	 */
	public void mortgage(){
		
	}
	
	/**
	 * Sets a field to an unmortgaged state
	 */
	public void unmortgage(){
		
	}
	
	/**
	 * Gets the current mortgage state of a field
	 * @return The mortgage state of the field (boolean)
	 */
	public boolean getMortgageState(){
		return mortgage;
		
	}
}
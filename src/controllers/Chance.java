package controllers;

import java.util.ArrayList;
import java.util.Collections;

import entities.Birthday;
import entities.ChanceCard;
import entities.ChanceFee;
import entities.DynamicMove;
import entities.FixedMove;
import entities.GetOutOfJail;
import entities.Matador;
import entities.Player;
import entities.PropertyTax;
import entities.RailroadMove;
import entities.UtillityMove;
import language.Language;

public class Chance {

		private ArrayList<ChanceCard> ChanceList = new ArrayList<ChanceCard>();
	
		
		public Chance(){
			
		}
		
		public void createChance(){
			ChanceList.add(new ChanceFee(1, 6, Language.toString(2), -1000));
			ChanceList.add(new FixedMove(2, 3, Language.toString(5), 0));
			ChanceList.add(new FixedMove(3, 3, Language.toString(3), 10));
			ChanceList.add(new FixedMove(4, 3, Language.toString(3), 10));
			ChanceList.add(new ChanceFee(5, 6, Language.toString(4), -200));
			ChanceList.add(new ChanceFee(6, 6, Language.toString(6), -2000));
			ChanceList.add(new ChanceFee(7, 6, Language.toString(7), 1000));
			ChanceList.add(new ChanceFee(8, 6, Language.toString(8), 1000));
			ChanceList.add(new Birthday(9, 7, Language.toString(9), 200));
			ChanceList.add(new ChanceFee(10, 6, Language.toString(10), 200));
			ChanceList.add(new ChanceFee(11, 6, Language.toString(11), -1000));
			ChanceList.add(new PropertyTax(12, 2, Language.toString(12), 800, 2300));
			ChanceList.add(new FixedMove(13, 3, Language.toString(13), 24));
			ChanceList.add(new UtillityMove(14, 1, Language.toString(14), 2));
			ChanceList.add(new UtillityMove(15, 1, Language.toString(14), 2));
			ChanceList.add(new RailroadMove(16, 9, Language.toString(15)));
			ChanceList.add(new GetOutOfJail(17, 8, Language.toString(16)));
			ChanceList.add(new GetOutOfJail(18, 8, Language.toString(16)));
			ChanceList.add(new ChanceFee(19, 6, Language.toString(17), 1000));
			ChanceList.add(new FixedMove(20, 3, Language.toString(18), 11));
			ChanceList.add(new ChanceFee(21, 6, Language.toString(19), 500));
			ChanceList.add(new FixedMove(22, 3, Language.toString(20), 39));
			ChanceList.add(new DynamicMove(23, 4, Language.toString(21), -3));
			ChanceList.add(new PropertyTax(24, 2, Language.toString(22), 500, 2000));
			ChanceList.add(new ChanceFee(25, 6, Language.toString(23), -3000));
			ChanceList.add(new ChanceFee(26, 6, Language.toString(23), -3000));
			ChanceList.add(new Matador(27, 5, Language.toString(24), 15000, 40000));
			ChanceList.add(new ChanceFee(28, 6, Language.toString(25), 3000));
			ChanceList.add(new ChanceFee(29, 6, Language.toString(26), 1000));
			ChanceList.add(new ChanceFee(30, 6, Language.toString(26), 1000));
			ChanceList.add(new ChanceFee(31, 6, Language.toString(27), -1000));
			ChanceList.add(new ChanceFee(32, 6, Language.toString(28), 200));
		}
		
		public void ShuffleCards(){			
			Collections.shuffle(ChanceList);				
		}
		
		public int ListLength(){
			return ChanceList.size() - 1;
		}
		
		public void DrawChance(Player Player){
		ChanceCard Card = ChanceList.get(ListLength());
	
			switch(Card.getChanceType()){
			
//			UtillityMove
				case 1 : 
					
					break;
//			PropertyTax
				case 2 : 
					break;
//			FixedMove
				case 3 : 
					break;
//			DynamicMove
				case 4 : 
					break;
//			Matador
				case 5 : 
					break;
//			Fee
				case 6 : 
					break;
//			Birthday
				case 7 : 
					break;
//			GetOutOfJail
				case 8 : 
					break;
//			RailRoad
				case 9 : 
					break;
					

					
			}
		}	
		
		
}
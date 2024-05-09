import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

public class Deck {                    //we create our class called deck
	public String[]CardsIcons;         //we set the variables which in this case are 2 Arrays
	public   Card[] Cards;             //called Cards and CardsIcons
	public int value;                  // we set a Integer variable  called value
	public ImageIcon image;            // we set a ImageIcon variable called Image

	
	public  Deck() {         
		
		Cards=new Card[52];            //we create a new Card Array
        CreateFullDeck();

	}

	public void CreateFullDeck() {
        Card card;
        int value = 0;
        for(int counter = 0; counter < 4; counter++) {

            for(int counterc = 0; counterc < 13; counterc++) {
                String nameCard;
                card = new Card();
                card.setSuit(card.Suit()[counter]);
         
                if(counterc == 0){
                    nameCard = card.Suit()[counter]+"1";
                    }else if(counterc == 10){
                    nameCard = card.Suit()[counter]+"J";
                    }else if(counterc == 11){
                    nameCard = card.Suit()[counter]+"Q";
                    }else if(counterc == 12){
                    nameCard = card.Suit()[counter]+"K";
                    }else{
                    nameCard = card.Suit()[counter]+String.valueOf(counterc +1);
                    }
                if(counterc>9){
                    value = 10;
                }else{
                    value = counterc+1;
                }
                card.setValue(value);
                card.setCardImage(card.getImageIcon(nameCard));
                Cards[counter * 13 + counterc] = card;
            }
        }
    }


	public int getRandomValue(int[] valuelist) {
		//-------------------------------------------------------------------------------------------------
		// Method            :  int getRandomValue(int[]valuelist)
		// Method Parameters :  valuelist - The method permits use the array value list.
		// Method return     :  int
		// Synopsis          :  In this method we are going to get a random value.
		// 
		//Modifications :    Date:             Author:            Notes:       
		//                 2023/03/30        C.Sebastian       Inital Setup 
		//-------------------------------------------------------------------------------------------------
		Random rand = new Random();                                                            //we do a new random
		boolean hasOne = false;                                                                //we do a boolean called hasone 
		boolean hasEleven = false;                                                             // we do a boolean called haseleven
		int index=0;
		int value;

		do {
			index = rand.nextInt(valuelist.length);           
			value = valuelist[index];

			if ((value == 1 && hasOne) || (value == 11 && hasEleven)) {
				continue;
			}
                                                                           //We create an if to set to establish that A can have a different
			if (value == 1) {                                              //value depending on the item it can have a value of 1 or it
				hasOne = true;                                             // can have a value of 11. 
			} else if (value == 11) {
				hasEleven = true;
			}
		} while ((value == 1 && !hasOne) || (value == 11 && !hasEleven));

		return valuelist[index];
	}

	public String getRandomSuit(String[] suitlist) {
		//-------------------------------------------------------------------------------------------------
		// Method            :  int getRandomSuit(int[]suitlist)
		// Method Parameters :  suitlist - The method permits use the array suit list.
		// Method return     :  int
		// Synopsis          :  In this method we are going to get a random suit to set in the cards.
		// 
		//Modifications :    Date:             Author:            Notes:       
		//                 2023/03/30        C.Sebastian       Inital Setup 
		//-------------------------------------------------------------------------------------------------
		Random rand = new Random();                                   //we set a new Random
		boolean[] selectedValues = new boolean[suitlist.length];      //we create a new boolean array called selectedValues
		int count = 0;                                                //we create a new integer variable called count

		while (count < suitlist.length) {                             //we create a while loop
			int index = rand.nextInt(suitlist.length);                //we set the length of the suitlist array as a limit.
			if (!selectedValues[index]) {
				selectedValues[index] = true;
				count++;
				return suitlist[index];
			}
		}

		return null;
	}
	private List<String> usedCards = new ArrayList<String>();       //we create a temporally deck called used cards.

	
	
	  static Deck shuffleArray(Deck ar){
		  //-------------------------------------------------------------------------------------------------
		  // Method            :  Deck ShuffleArray(Deck ar)
		  // Method Parameters :  Deck are: we create a new deck
		  // Method return     :  Deck
		  // Synopsis          :  In this method we are going to shuffle the cards and put the used ones to a 
		  //                      temp deck to avoid repeating cards
		  //
		  // References        : Wikipedia(2022). https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
		  //
		  //Modifications :    Date:             Author:            Notes:       
		  //                 2023/03/30        C.Sebastian       Inital Setup 
		  //-------------------------------------------------------------------------------------------------

	    Random rnd = ThreadLocalRandom.current();
	   
	    for (int i = ar.getCards().length - 1; i > 0; i--){ //we shuffle the array 
	    
	      int index = rnd.nextInt(i + 1);
	     
	      Card a = ar.getCards()[index];
	      ar.getCards()[index] = ar.getCards()[i];
	      ar.getCards()[i] = a;
	    }
	    return ar;
	  }

////////////////////////////////////////////////////////
	public String[] getCardsIcons() {                 //
		return CardsIcons;                            //
	}                                                 //
                                                      //
	public void setCardsIcons(String[] cardsIcons) {  //
		CardsIcons = cardsIcons;                      //
		}                                             // 
                                                      //  //we add out getters and setters.
	public Card[] getCards() {                        //
		return Cards;                                 //
	}                                                 //
                                                      //
	public void setCards(Card[] cardImage) {          //
		Cards = cardImage;                            //
	}}                                                //
////////////////////////////////////////////////////////



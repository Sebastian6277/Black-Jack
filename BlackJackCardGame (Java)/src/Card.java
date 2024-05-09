import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;

public class Card {                                                                //we create our class called card
	
	ImageIcon CardImage;                                                           //we create a new variable ImageIcon call CardImage
	public static ImageIcon Backcard= new ImageIcon("Assets/cardBack.png");        // here we called a new ImageIcon  called backcard.
	                                                                               //which will be the image shown as the back side of the cards
	
	int value;                                                                     //we create a new integer called value                                                      
	String suit;                                                                   // we create a new String called suit 
	
public int[] Value() {                                                             //We create a new Array called Value which will have the values of the cards.
	 int [] valuelist = {1,2,3,4,5,6,7,8,9,10,10,10,10};
	 return(valuelist);
}
public String[] Suit(){                                                            //We create a new Array called Suit which will have all the symbols of the cards.
	String[]stringlist = {"C","D","H","S"};
	return(stringlist);
}

public ImageIcon loadImage(String filename) {
    return new ImageIcon(filename);
}

public ImageIcon getImageIcon(String cardName) {                                   
    List<String> filenames = Arrays.asList("Assets/C1.png", "Assets/C2.png", "Assets/C3.png", "Assets/C4.png", "Assets/C5.png", "Assets/C6.png",       //We create a Dynamic Arraylist called file names 
    		"Assets/C7.png", "Assets/C8.png", "Assets/C9.png", "Assets/C10.png", "Assets/CJ.png", "Assets/CQ.png", "Assets/CK.png", "Assets/D1.png",   //which will have all out card images
    		"Assets/D2.png", "Assets/D3.png", "Assets/D4.png", "Assets/D5.png", "Assets/D6.png", "Assets/D7.png", "Assets/D8.png", "Assets/D9.png",   
    		"Assets/D10.png", "Assets/DJ.png", "Assets/DQ.png", "Assets/DK.png", "Assets/H1.png", "Assets/H2.png", "Assets/H3.png", "Assets/H4.png", 
    		"Assets/H5.png", "Assets/H6.png", "Assets/H7.png", "Assets/H8.png", "Assets/H9.png", "Assets/H10.png", "Assets/HJ.png", "Assets/HQ.png", 
    		"Assets/HK.png", "Assets/S1.png", "Assets/S2.png", "Assets/S3.png", "Assets/S4.png", "Assets/S5.png", "Assets/S6.png", "Assets/S7.png", 
    		"Assets/S8.png", "Assets/S9.png", "Assets/S10.png", "Assets/SJ.png", "Assets/SQ.png", "Assets/SK.png");
               
               //Oracle(2023). https://docs.oracle.com/javase/8/docs/api/java/util/List.html
    
    String cardFilename = filenames.stream()
            .filter(filename -> filename.startsWith("Assets/" + cardName + ".png")) //Here we place a filter which in this case is
            .findFirst()                                                   //"Assetst/" which is the directory where all 
            .orElse(null);                                                 //the images are located and we add the
                                                                           //array with the name of the images.
    if (cardFilename == null) {
        return null;
    }
    
    return loadImage(cardFilename);                                       //And we return a loadImage
}
///////////////////////////////////////////////////
public ImageIcon getCardImage() {                //                     
	return CardImage;                            //
}                                                //
public void setCardImage(ImageIcon cardImage) {  //
	CardImage = cardImage;                       //
}                                                //
public int getValue() {                          //
	return value;                                //
}                                                //
public void setValue(int value) {                // //we add our getters and setters.
	this.value = value;                          //
}                                                //
public String getSuit() {                        //
	return suit;                                 //
}                                                //
public void setSuit(String suit) {               //
	this.suit = suit;                            //
}                                                //
}                                                //
///////////////////////////////////////////////////


//Cards Assets:
//Github(2023).https://github.com/kurtkaiser/Unity-Blackjack-Game-Tutorial/tree/master/Assets/Sprites/Cards


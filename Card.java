import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
    private String suit;
    private String rank;
    private boolean isMagic = false;

    public Card (String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // getter - setter
    public String getSuit() {  
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public String toString() {
        return suit + " of " + rank;
    }

    //called card.isMagic() -- need to ask if magic cards can all be played no matter what the prev card was
    //gonna default into thinking that card b4 magic cards dont really matter
    public void isMagic(){ 
        if(rank.equals("2")||rank.equals("4")||rank.equals("7")||rank.equals("10")){
            isMagic = true; 
        }
    }   

    public int asNumber() {
        if(rank.equals("Jack")){
            System.out.println("u played a jack");
            return 11;
        }else if(rank.equals("Queen")){
            System.out.println("u played a qween yass");
            return 12;
        }else if(rank.equals("King")){
            return 13;
        }else if(rank.equals("Ace")){
            return 14;
        }else{
            return Integer.valueOf(rank);
        }
    }

}
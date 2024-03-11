import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Player{
	private String name;
	private Hand hand;
	private Hand down;
	private Hand up;
	//private ArrayList<Card> playedCards;
	
	public Player(String name){
		this.name = name;
        hand = new Hand();
        down = new Hand();
        up = new Hand();
	}

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public Hand getUp() {
        return up;
    }

    public Hand getDown() {
        return down;
    }
	
	public void initCards(Deck d){
        // deal 3 for hand
        for (int i=0; i<3; i++){
            hand.addCard(d.dealCard());
        }
        
        // deal 3 for down
        for (int i=0; i<3; i++){
            down.addCard(d.dealCard());
        }

        // deal 3 for up
        for (int i=0; i<3; i++){
            up.addCard(d.dealCard());
        }
	}

    Scanner input = new Scanner(System.in);
    
    // checks if picked is in player's hand
    // cheems will NOT touch this
    public boolean inList(int pos, ArrayList<Card> cards){ 
        //stupid method i made because i couldnt remember the built in stuff
		boolean returnValue = false;
		for(int i=0;i<cards.size();i++){
			if(cards.get(i)!=null){
				if(pos==i){
					returnValue = true;
				}
			}
		}
		return returnValue;
	}

    // public boolean inList2 (int pos, ArrayList<Card> cards) [
        
    // ]

    // just for picking
    public Card pickPlay(){
        Hand h;
        Card playedCard;

        if (!hand.isEmpty()) {
            h = hand;
            System.out.println("\nPlaying from Hand");
        } else if (!up.isEmpty()) {
            System.out.println("\nPlaying from Face Up");
            h = up;
        } else {
            System.out.println("\nPlaying from Face Down - Random card time !!");
            h = down;
        }

	    //show hand
        h.getCards();
	    
        if (h==down) {
            return playRand();
        } else {
            if (h.handSize()==1) {
                playedCard = h.pick(0); 
            }
    
            System.out.println("Dear player " + getName() + ", pretty pwease, pick a card: (pick an integer from the card #ranks displayed)");
            //choice
            int playerChoice = input.nextInt();
        
            while (!inList(playerChoice,h.getCards())) {
                System.out.println("bruh wtf pick again");
                playerChoice = input.nextInt();
            }
        
            //save card in temp value
            playedCard = h.pick(playerChoice);
        }
        
        //remove card (real value)
        h.remove(playedCard); //?????
        Card lastPlayed = playedCard;
        System.out.println("\nlast card played---------------");
        System.out.println(playedCard.toString());

        //return the (temp) card
        return playedCard;
    
    }

    // works ok
    public Card playRand(){
		//pick random from hand 
		Random random = new Random();
		int r = random.nextInt(down.handSize());
        
		//save card in temp value
		Card temp = down.pick(r);
				
		//remove card from hand (real value)
		down.remove(temp); //?????
				
		//return the (temp) card
		return temp;
	
	}

    public static void main(String[] args) {
        Player p = new Player("kitsos");
        Deck d = new Deck();

        // deck initializes alone
        System.out.println(d.toString());

        System.out.println("shufflin\n");
        //d.shuffle();
        System.out.println(d.toString());

        p.initCards(d);
        //System.out.println("\nhand");
        //p.getHand().printCards();
        // all works till here

        while(p.getDown().handSize() != 0){
            System.out.println("hand");
            p.getHand().printCards();
            System.out.println("up");
            p.getUp().printCards();
            System.out.println("down");
            p.getDown().printCards();
            Card picked = p.pickPlay();
            System.out.println("\nyou picked " + picked.toString());
            System.out.println("---------" + p.getDown().handSize() + "--------");
        }

        System.out.println("no more cards left :((");
    
    }

}
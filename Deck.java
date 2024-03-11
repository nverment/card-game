import java.util.ArrayList;
import java.util.Collections;

class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        initializeDeck();
    }
    
    private void initializeDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(rank, suit);
				//Card card = new Card(rank, suit);
                cards.add(card);
            }
        }
    }
    
    // will need
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public Card dealCard() {	
        while (!cards.isEmpty()) {
            Card temp = cards.get(0);
            cards.remove(0);
            return temp;
        } return null;
    }

    // needed (for what's left)
    public int size() { 
        return cards.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Deck d = new Deck();
        System.out.println(d.toString());

        System.out.println("shufflin---------------\n");
        //d.shuffle();
        System.out.println(d.toString());

        System.out.println("dealing a card -------------\n");
        System.out.println(d.dealCard().toString());

        System.out.println("let's see what's left in the deck ----------\n");
        System.out.println(d.toString());
    }
}
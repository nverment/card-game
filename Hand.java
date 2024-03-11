import java.util.ArrayList;

class Hand{
	private ArrayList<Card> cards;
	
	public Hand(){
		cards = new ArrayList<Card>();
	}
	
	public void printCards(){
		for(int i=0;i<cards.size();i++){
			System.out.println("Card #"+i+": "+cards.get(i).toString());
		}
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public void remove(Card card){ // yeahhhh not sure about this
		cards.remove(card);
	}

	//@Override
	public boolean isEmpty() {
		return (cards.size()==0);
	}

	public void addCard(Card c) {
		cards.add(c);
	}

	// maybe not needed
	public int handSize() {
		return cards.size();
	}

	public Card pick(int n) {
		return cards.get(n);
	}
}
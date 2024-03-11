import java.util.ArrayList;
import java.lang.Integer;
import java.util.Scanner;

class Game {
    private ArrayList<Player> players;
    private Deck deck = new Deck();
    private Hand publicCards = new Hand();
    private Card lastCard;
    private int turns;

    Scanner sc = new Scanner(System.in);

    public Game() {
        players = new ArrayList<Player>();
        deck = new Deck();
        publicCards = new Hand();
        turns = 1;
    }

    public void play() {
        System.out.println("how many players in the game?");
        int numPlayers = sc.nextInt();

        // init players and their cards
        for (int i=0; i<numPlayers; i++) {
            System.out.println("enter player name");
            players.add(new Player(sc.next()));
            players.get(i).initCards(deck);
        }

        for (int i=0; i<players.size(); i++) {
            System.out.println("hand");
            players.get(i).getHand().printCards();

            if (turns == 1) {
                Card playedCard = players.get(i).pickPlay();
                lastCard = playedCard;
            } else {
                System.out.println("\n-----last card: " + lastCard.toString()); 
                // need to fix for the first time
                //System.out.println("------------last played card: " + publicCards.pick(turns-1));
                Card playedCard = players.get(i).pickPlay();

                if (lastCard.asNumber() == 7) {
                    if (playedCard.asNumber() <=7) {
                        continue;
                    } else {
                        System.out.println("no dumbass card u lose again");
                    } 
                } else {
                    // must check if card>lastcard
                    // or if is magic etc
                    if(playedCard == null) {
                        System.out.println("bitch wtf u broke the game");
                        return;
                    } else if (playedCard.asNumber() == 4) {
                        // lastcard not changing
                        System.out.println("played a 4 - meaning a pass");
                        continue;
                    } else if (playedCard.asNumber() == 7) {
                        lastCard = playedCard;
                    } else if (playedCard.asNumber() == 10) {
                        publicCards = null;
                        lastCard = null;
                        // empty the publicCards (set  it to null - 0)
                    } else {
                        // played more than last card
                        if (playedCard.asNumber() > lastCard.asNumber()) {
                            publicCards.addCard(playedCard);
                            lastCard = playedCard;
                        } else {
                            // u lose
                            System.out.println("u played dumb card loser");
                        }
                    }   
                }

            }
         
        turns++;
        i=0;
        }
    }
    
    public static void main(String[] args) {
        Game gg = new Game();
        gg.play();
    }
}
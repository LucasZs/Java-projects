package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	final List<Card> cards = new ArrayList<>();
	
	private static Deck INSTANCE;
	
	private Deck(){
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(suit, rank);
				cards.add(card);
			}
		}
	}
	
	public static Deck getInstance(){
		if(INSTANCE==null){
			INSTANCE = new Deck();
		}
		return INSTANCE;
	}

	public List<Card> getCards() {
		return cards;
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
}

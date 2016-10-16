package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	public final static List<Card> CARDS = new ArrayList<>();
	static {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				CARDS.add(new Card(suit, rank));
			}
		}
	}

	public static void main(String[] args) {
		Collections.shuffle(CARDS);
		for (Card card : CARDS) {
			System.out.print(card + " ");
		}
		System.out.println();
		Collections.sort(CARDS);
		for (Card card : CARDS) {
			System.out.print(card + " ");
		}

	}
}

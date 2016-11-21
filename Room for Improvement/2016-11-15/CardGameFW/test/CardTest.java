package test;

import java.util.List;

import cards.Card;
import cards.Deck;

public class CardTest {

	public static void main(String[] args) {
		Deck deck = Deck.getInstance();
		deck.shuffle();
		List<Card> cards = deck.getCards();
		cards.clear();
		System.out.println(cards);
	}

}

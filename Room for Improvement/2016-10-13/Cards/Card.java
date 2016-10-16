package cards;

import java.util.Arrays;

public class Card implements Comparable<Card> {
	private Suit suit;
	private Rank rank;

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return rank.toString() + suit.toString();
	}

	@Override
	public int compareTo(Card card) {
		Rank otherCardRank = card.getRank();
		Rank[] ranks = Rank.values();
		int actualRankIndex = Arrays.binarySearch(ranks, rank);
		int otherRankIndex = Arrays.binarySearch(ranks, otherCardRank);
		return actualRankIndex - otherRankIndex;
	}
}

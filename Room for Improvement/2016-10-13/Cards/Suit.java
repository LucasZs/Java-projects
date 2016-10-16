package cards;

public enum Suit {

	HEART('h'), DIAMOND('d'), SPADE('s'), CLUB('c');
	char value;

	private Suit(char value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}

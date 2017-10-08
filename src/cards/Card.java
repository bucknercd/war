package cards;

public class Card {
	private Suit suit;
	private Rank rank;
	
	public Card(Rank rank, Suit suit) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public Rank getRank() {
		return this.rank;
	}
	
	public String toString() {
		return this.rank + " of " + this.suit + "S";
	}
}

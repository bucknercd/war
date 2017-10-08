package cards;

import java.util.Collections;
import java.util.Stack;

public class Deck {
	
	private Stack<Card> cards;

	public Deck () {
		this.cards = new Stack<Card>();
	}
	
	public void addCard(Card card) {
		this.cards.push(card);
	}
	
	public void populate() {
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values())
				this.cards.push(new Card(rank, suit));
	}
	
	public void shuffle() {
		Collections.shuffle(this.cards);
	}

	public void deal(Player player1, Player player2) {
		int count = 0;
		while (!this.cards.isEmpty()) {
			Card card = this.cards.pop();
			if (count % 2 == 0)
				player1.addCardToHand(card);
			else
				player2.addCardToHand(card);
			count++;
		}
	}
	
	public void deal(Player player1, Player player2, Player player3) {
		int count = 0;
		while (!this.cards.isEmpty()) {
			Card card = this.cards.pop();
			if (count % 3 == 0)
				player1.addCardToHand(card);
			else if (count % 3 == 1)
				player2.addCardToHand(card);
			else
				player3.addCardToHand(card);
			count++;
		}
	}
	
	public Stack<Card> getCards() {
		return this.cards;
	}
	
	
}

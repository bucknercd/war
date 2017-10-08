package game;


import java.util.LinkedList;
import cards.Card;
import cards.Deck;
import cards.Player;
import log.WarLogger;

public abstract class War {
	protected Deck deck;
	protected Player player1;
	protected Player player2;
	protected Player player3;
	protected WarLogger logger;
	protected Player winner;
	protected boolean test;
	protected boolean tie;
	protected final int LIMIT = 10000;
	
	protected int rounds;
	
	
	public War(Player player1, Player player2, Deck deck) {
		if (!deck.getCards().isEmpty())
			this.test = true;
		else
			this.test = false;
		this.logger = new WarLogger(player1, player2);
		this.player1 = player1;
		this.player2 = player2;
		this.deck = deck;
		this.winner = new Player("default");
		this.tie = false;
		
		this.rounds = 0;
	}
	
	protected void setupGame() {
		if (this.test)
			return;
		this.deck.populate();
		this.deck.shuffle();
	}
	
	public void play() {
		this.setupGame();
		this.deck.deal(this.player1, this.player2);
		this.playCards();
	}

	protected void playCards() {
		Card[] cards = new Card[2];
		cards[0] = this.player1.getCardFromHand();
		cards[1] = this.player2.getCardFromHand();
		this.player1.pushCardToUpPile(cards[0]);
		this.player2.pushCardToUpPile(cards[1]);
		this.logger.play(cards);
		this.compareCards();
	}
	
	protected void compareCards() {
		int cardValue1 = this.player1.lookAtCardFromUpPile().getRank().ordinal();
		int cardValue2 = this.player2.lookAtCardFromUpPile().getRank().ordinal();
		if (cardValue1 > cardValue2)
			this.winRound(this.player1);
		else if (cardValue1 < cardValue2)
			this.winRound(this.player2);
		else
			this.war();
	}
	
	protected void winRound(Player winner) {
		this.rounds++;
		
		this.cleanUp(winner);
		String variation = "None";
		if (this instanceof WarVariation1) {
			variation = "one";
			this.logger.winRound(winner, true);
		} else if (this instanceof WarVariation2) {
			variation = "two";
			this.logger.winRound(winner, false);
		} else if (this instanceof WarVariation3) {
			variation = "three";
			this.logger.winRound(winner, false);
		}
		
		LinkedList<Card> hand1 = this.player1.getTotalHand();
		LinkedList<Card> hand2 = this.player2.getTotalHand();
		if (variation.equals("one") || variation.equals("two")) {
			if (hand1.isEmpty() || hand2.isEmpty())
				this.gameOver();
			else
				this.playCards();
		} else if (variation.equals("three")) {
			LinkedList<Card> hand3 = this.player3.getTotalHand();
			if (hand1.isEmpty() || hand2.isEmpty() || hand3.isEmpty())
				this.gameOver();
			else
				this.playCards();
		}
	}
	
	protected abstract void cleanUp(Player winner);
	
	protected void war() {
		this.logger.war();
		Card card1 = null, card2 = null;
		
		try {
			card1 = this.player1.getCardFromHand();
			card2 = this.player2.getCardFromHand();
		} catch (Exception e) {
			this.gameOver();
			return;
		}
		this.player1.pushCardToDownPile(card1);
		this.player2.pushCardToDownPile(card2);
		
		Card[] cards = new Card[2];
		cards[0] = this.player1.lookAtCardFromHand();
		cards[1] = this.player2.lookAtCardFromHand();
		if (cards[0] == null || cards[1] == null) {
			this.gameOver();
			return;
		}
			
		this.player1.pushCardToUpPile(this.player1.getCardFromHand());
		this.player2.pushCardToUpPile(this.player2.getCardFromHand());
		this.logger.play(cards);
		this.compareCards();
	}
	
	protected abstract void gameOver();
	
	public Player getWinningPlayer() {
		return this.winner;
	}	
	
	public boolean isTie () {
		return this.tie;
	}
}
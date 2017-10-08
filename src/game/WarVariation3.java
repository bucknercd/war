package game;


import cards.Player;
import cards.Card;
import cards.Deck;
import log.WarLogger;

public class WarVariation3 extends War {

	public WarVariation3(Player player1, Player player2, Player player3, Deck deck) {
		super(player1, player2, deck);
		this.logger = new WarLogger(player1, player2, player3);
		this.player3 = player3;
	}
	
	@Override
	public void play() {
		this.setupGame();
		this.deck.deal(this.player1, this.player2, this.player3);
		this.playCards();
	}

	@Override
	protected void playCards() {
		Card[] cards = new Card[3];
		cards[0] = this.player1.getCardFromHand();
		cards[1] = this.player2.getCardFromHand();
		cards[2] = this.player3.getCardFromHand();
		this.player1.pushCardToUpPile(cards[0]);
		this.player2.pushCardToUpPile(cards[1]);
		this.player3.pushCardToUpPile(cards[2]);
		this.logger.play(cards);
		this.compareCards();
	}
	
	@Override
	protected void compareCards() {
		int cardValue1 = this.player1.lookAtCardFromUpPile().getRank().ordinal();
		int cardValue2 = this.player2.lookAtCardFromUpPile().getRank().ordinal();
		int cardValue3 = this.player3.lookAtCardFromUpPile().getRank().ordinal();
		if (cardValue1 > cardValue2 && cardValue1 > cardValue3)
			this.winRound(this.player1);
		else if (cardValue2 > cardValue1 && cardValue2 > cardValue3)
			this.winRound(this.player2);
		else if (cardValue3 > cardValue1 && cardValue3 > cardValue2)
			this.winRound(this.player3);
		else
			this.war();
	}

	@Override
	protected void cleanUp(Player winner) {
		while (!this.player1.getUpPile().empty())
			winner.pushCardToPointsPile(this.player1.getCardFromUpPile());
		
		while (!this.player1.getDownPile().empty())
			winner.pushCardToPointsPile(this.player1.getCardFromDownPile());
		
		while (!this.player2.getUpPile().empty())
			winner.pushCardToPointsPile(this.player2.getCardFromUpPile());
		
		while (!this.player2.getDownPile().empty())
			winner.pushCardToPointsPile(this.player2.getCardFromDownPile());
		
		while (!this.player3.getUpPile().empty())
			winner.pushCardToPointsPile(this.player3.getCardFromUpPile());
		
		while (!this.player3.getDownPile().empty())
			winner.pushCardToPointsPile(this.player3.getCardFromDownPile());
	}
	
	@Override
	protected void war() {
		this.logger.war();
		Card card1 = null, card2 = null, card3 = null;
		
		try {
			card1 = this.player1.getCardFromHand();
			card2 = this.player2.getCardFromHand();
			card3 = this.player3.getCardFromHand();
		} catch (Exception e) {
			this.gameOver();
			return;
		}
		this.player1.pushCardToDownPile(card1);
		this.player2.pushCardToDownPile(card2);
		this.player3.pushCardToDownPile(card3);
		
		Card[] cards = new Card[3];
		cards[0] = this.player1.lookAtCardFromHand();
		cards[1] = this.player2.lookAtCardFromHand();
		cards[2] = this.player3.lookAtCardFromHand();
		if (cards[0] == null || cards[1] == null || cards[2] == null) {
			this.gameOver();
			return;
		}
		
		this.player1.pushCardToUpPile(this.player1.getCardFromHand());
		this.player2.pushCardToUpPile(this.player2.getCardFromHand());
		this.player3.pushCardToUpPile(this.player3.getCardFromHand());
		this.logger.play(cards);
		this.compareCards();
	}

	@Override
	protected void gameOver() {
		int player1points = this.player1.getPointsPile().size();
		int player2points = this.player2.getPointsPile().size();
		int player3points = this.player3.getPointsPile().size();
		if (player1points > player2points && player1points > player3points)
			this.winner = this.player1;
		else if(player2points > player1points && player2points > player3points)
			this.winner = this.player2;
		else if (player3points > player1points && player3points > player2points)
			this.winner = this.player3;
		else
			this.tie = true;
		this.logger.logWinner(this.winner);
		this.logger.writeToFile();
	}
}

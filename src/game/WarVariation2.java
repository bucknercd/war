package game;


import cards.Deck;
import cards.Player;

public class WarVariation2 extends War {
	
	public WarVariation2(Player player1, Player player2, Deck deck) {
		super(player1, player2, deck);
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
	}

	@Override
	protected void gameOver() {
		int player1points = this.player1.getPointsPile().size();
		int player2points  = this.player2.getPointsPile().size();
		if (player1points > player2points)
			this.winner = this.player1;
		else if (player2points > player1points)
			this.winner = this.player2;
		else
			this.tie = true;
		this.logger.logWinner(this.winner);
		this.logger.writeToFile();
	}
}
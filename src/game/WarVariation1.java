package game;


import cards.Deck;
import cards.Player;

public class WarVariation1 extends War {
	
	public WarVariation1(Player player1, Player player2, Deck deck) {
		super(player1, player2, deck);
	}
	
	@Override
	protected void cleanUp(Player winner) {
		while (!this.player1.getUpPile().empty())
			winner.addCardToHand(this.player1.getCardFromUpPile());
		
		while (!this.player1.getDownPile().empty())
			winner.addCardToHand(this.player1.getCardFromDownPile());
		
		while (!this.player2.getUpPile().empty())
			winner.addCardToHand(this.player2.getCardFromUpPile());
		
		while (!this.player2.getDownPile().empty())
			winner.addCardToHand(this.player2.getCardFromDownPile());
	}
	
	protected void gameOver() {
		this.logger.writeToFile();
		int player1sum = this.player1.getTotalHand().size();
		int player2sum  = this.player2.getTotalHand().size();
		if (player1sum > player2sum)
			this.winner = this.player1;
		else if (player2sum > player1sum)
			this.winner = this.player2;
		else
			this.tie = true;
		this.logger.logWinner(this.winner);
		System.out.println("Rounds Played: " + this.rounds);
	}
}

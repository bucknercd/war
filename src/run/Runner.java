package run;

import cards.Deck;
import cards.Player;
import game.War;
import game.WarVariation1;
import game.WarVariation2;
import game.WarVariation3;

public class Runner {

	public static void main(String[] args) {
		playGame(1);
		//playGame(2);
		//playGame(3);
	}
	
	public static void playGame(int version) {
		Player p1 = new Player("Chris");
		Player p2 = new Player("Nathan");
		Player p3 = new Player("Miguel");
		Deck deck = new Deck();
		
		War game;
		if (version == 1)
			game = new WarVariation1(p1, p2, deck);
		else if (version == 2)
			game = new WarVariation2(p1, p2, deck);
		else
			game = new WarVariation3(p1, p2, p3, deck);
		System.out.println("=====================================================");
		game.play();
	}
}

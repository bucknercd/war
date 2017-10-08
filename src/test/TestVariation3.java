package test;

import static org.junit.Assert.*;

import org.junit.Test;
import cards.Card;
import cards.Deck;
import cards.Player;
import cards.Rank;
import cards.Suit;
import game.War;
import game.WarVariation3;

	
public class TestVariation3 {
	@Test
	public void testBobWinsNoWar() {
		Player bob = new Player("Bob");
		Player chris = new Player("Chris");
		Player jack = new Player("Jack");
		Deck deck = new Deck();
		deck.addCard(new Card(Rank.TWO, Suit.CLUB));
		deck.addCard(new Card(Rank.TEN, Suit.DIAMOND));
		deck.addCard(new Card(Rank.ACE, Suit.HEART));
		War game = new WarVariation3(bob, chris, jack,  deck);
		game.play();
		assertEquals(bob, game.getWinningPlayer());
		System.out.println();
	}
	
	@Test
	public void testBobLosesNoWar() {
		Player bob = new Player("Bob");
		Player chris = new Player("Chris");
		Player jack = new Player("Jack");
		Deck deck = new Deck();
		deck.addCard(new Card(Rank.ACE, Suit.CLUB));
		deck.addCard(new Card(Rank.TEN, Suit.DIAMOND));
		deck.addCard(new Card(Rank.TWO, Suit.HEART));
		War game = new WarVariation3(bob, chris, jack,  deck);
		game.play();
		assertEquals(jack, game.getWinningPlayer());
		System.out.println();
	}
	
	@Test
	public void testBobWinsWar() {
		Player bob = new Player("Bob");
		Player chris = new Player("Chris");
		Player jack = new Player("Jack");
		Deck deck = new Deck();
		deck.addCard(new Card(Rank.TWO, Suit.CLUB));
		deck.addCard(new Card(Rank.TWO, Suit.HEART));
		deck.addCard(new Card(Rank.TWO, Suit.SPADE));
		
		deck.addCard(new Card(Rank.TEN, Suit.HEART));
		deck.addCard(new Card(Rank.TEN, Suit.HEART));
		deck.addCard(new Card(Rank.TEN, Suit.HEART));
		
		deck.addCard(new Card(Rank.TWO, Suit.HEART));
		deck.addCard(new Card(Rank.NINE, Suit.HEART));
		deck.addCard(new Card(Rank.ACE, Suit.HEART));
		War game = new WarVariation3(bob, chris, jack, deck);
		game.play();
		assertEquals(bob, game.getWinningPlayer());
		System.out.println();
	}
	
	@Test
	public void testBobLosesWar() {
		Player bob = new Player("Bob");
		Player chris = new Player("Chris");
		Player jack = new Player("Jack");
		Deck deck = new Deck();
		deck.addCard(new Card(Rank.TWO, Suit.CLUB));
		deck.addCard(new Card(Rank.TWO, Suit.HEART));
		deck.addCard(new Card(Rank.TWO, Suit.HEART));
		
		deck.addCard(new Card(Rank.TEN, Suit.HEART));
		deck.addCard(new Card(Rank.TEN, Suit.HEART));
		deck.addCard(new Card(Rank.TEN, Suit.HEART));
		
		deck.addCard(new Card(Rank.NINE, Suit.HEART));
		deck.addCard(new Card(Rank.ACE, Suit.HEART));
		deck.addCard(new Card(Rank.TWO, Suit.HEART));
		War game = new WarVariation3(bob, chris,jack, deck);
		game.play();
		assertEquals(chris, game.getWinningPlayer());
		System.out.println();
	}
	
	@Test
	public void testTieWar() {
		Player chris = new Player("Bob");
		Player nathan = new Player("Chris");
		Player jack = new Player("Jack");
		Deck deck = new Deck();
		deck.addCard(new Card(Rank.TWO, Suit.CLUB));
		deck.addCard(new Card(Rank.TWO, Suit.HEART));
		deck.addCard(new Card(Rank.TWO, Suit.DIAMOND));
		War game = new WarVariation3(nathan, chris,jack, deck);
		game.play();
		assertEquals(true, game.isTie());
		System.out.println();
	}
}

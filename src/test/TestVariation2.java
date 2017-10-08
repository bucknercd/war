package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.Card;
import cards.Deck;
import cards.Player;
import cards.Rank;
import cards.Suit;
import game.War;
import game.WarVariation2;

	
public class TestVariation2 {
	@Test
	public void testBobWinsNoWar() {
		Player bob = new Player("Bob");
		Player chris = new Player("Chris");
		Deck deck = new Deck();
		deck.addCard(new Card(Rank.TWO, Suit.CLUB));
		deck.addCard(new Card(Rank.ACE, Suit.HEART));
		War game = new WarVariation2(bob, chris, deck);
		game.play();
		assertEquals(bob, game.getWinningPlayer());
		System.out.println();
	}
	
	@Test
	public void testBobLosesNoWar() {
		Player bob = new Player("Bob");
		Player chris = new Player("Chris");
		Deck deck = new Deck();
		deck.addCard(new Card(Rank.ACE, Suit.CLUB));
		deck.addCard(new Card(Rank.TWO, Suit.HEART));
		War game = new WarVariation2(bob, chris, deck);
		game.play();
		assertEquals(chris, game.getWinningPlayer());
		System.out.println();
	}
	
	@Test
	public void testBobWinsWar() {
		Player bob = new Player("Bob");
		Player chris = new Player("Chris");
		Deck deck = new Deck();
		deck.addCard(new Card(Rank.TWO, Suit.CLUB));
		deck.addCard(new Card(Rank.TWO, Suit.HEART));
		
		deck.addCard(new Card(Rank.TEN, Suit.HEART));
		deck.addCard(new Card(Rank.TEN, Suit.HEART));
		
		deck.addCard(new Card(Rank.TWO, Suit.HEART));
		deck.addCard(new Card(Rank.ACE, Suit.HEART));
		War game = new WarVariation2(bob, chris, deck);
		game.play();
		assertEquals(bob, game.getWinningPlayer());
		System.out.println();
	}
	
	@Test
	public void testBobLosesWar() {
		Player bob = new Player("Bob");
		Player chris = new Player("Chris");
		Deck deck = new Deck();
		deck.addCard(new Card(Rank.TWO, Suit.CLUB));
		deck.addCard(new Card(Rank.TWO, Suit.HEART));
		
		deck.addCard(new Card(Rank.TEN, Suit.HEART));
		deck.addCard(new Card(Rank.TEN, Suit.HEART));
		
		deck.addCard(new Card(Rank.ACE, Suit.HEART));
		deck.addCard(new Card(Rank.TWO, Suit.HEART));
		War game = new WarVariation2(bob, chris, deck);
		game.play();
		assertEquals(chris, game.getWinningPlayer());
		System.out.println();
	}
	
	@Test
	public void testTieWar() {
		Player chris = new Player("Bob");
		Player nathan = new Player("Chris");
		Deck deck = new Deck();
		deck.addCard(new Card(Rank.TWO, Suit.CLUB));
		deck.addCard(new Card(Rank.TWO, Suit.HEART));
		War game = new WarVariation2(nathan, chris, deck);
		game.play();
		assertEquals(true, game.isTie());
		System.out.println();
	}
}

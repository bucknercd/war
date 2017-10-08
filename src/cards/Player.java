package cards;

import java.util.LinkedList;
import java.util.Stack;

public class Player {
	private String name;
	private LinkedList<Card> hand;
	private Stack<Card> upPile;
	private Stack<Card> downPile;
	private Stack<Card> pointsPile;
	
	public Player(String name) {
		this.hand  = new LinkedList<Card>();
		this.upPile  = new Stack<Card>();
		this.downPile  = new Stack<Card>();
		this.pointsPile = new Stack<Card>();
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Card getCardFromHand() {
		return this.hand.pop();
	}
	
	public LinkedList<Card> getTotalHand() {
		return this.hand;
	}
	
	public Card getCardFromUpPile() {
		return this.upPile.pop();
	}
	
	public Stack<Card> getUpPile() {
		return this.upPile;
	}
	
	public Card getCardFromDownPile() {
		return this.downPile.pop();
	}
	
	public Stack<Card> getDownPile() {
		return this.downPile;
	}
	
	public Card getCardFromPointsPile() {
		return this.pointsPile.pop();
	}
	
	public Stack<Card> getPointsPile() {
		return this.pointsPile;
	}
	
	public void addCardToHand(Card card) {
		this.hand.addFirst(card);
	}
	
	public void pushCardToUpPile(Card card) {
		this.upPile.push(card);
	}
	
	public void pushCardToDownPile(Card card) {
		this.downPile.push(card);
	}
	
	public void pushCardToPointsPile(Card card) {
		this.pointsPile.push(card);
	}
	
	public Card lookAtCardFromUpPile() {
		return this.upPile.peek();
	}
	
	public Card lookAtCardFromDownPile() {
		return this.downPile.peek();
	}
	
	public Card lookAtCardFromHand() {
		return this.hand.peek();
	}
	
	public int getPointsScore() {
		return this.pointsPile.size();
	}
	
	public String toString() {
		return this.name;
	}
}

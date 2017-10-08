package log;

import java.io.IOException;
import java.io.PrintWriter;

import cards.Card;
import cards.Player;

public class WarLogger {
	private String totalOutput = "";
	private int playerNum;
	private Player player1;
	private Player player2;
	private Player player3;
	
	public WarLogger(Player player1, Player player2) {
		this(player1, player2, null);
		this.playerNum = 2;
	}
	public WarLogger(Player player1, Player player2, Player player3) {
		this.player1 = player1;
		this.player2 = player2;
		this.player3 = player3;
		this.playerNum = 3;
	}
	
	public void play(Card[] cards) {
		String output = "";
		output += this.player1 + " plays " + cards[0] + " as up card\n";
		output += this.player2 + " plays " + cards[1] + " as up card\n";
		if (this.playerNum == 3)
			output += this.player3 + " plays " + cards[2] + " as up card\n";
		System.out.print(output);
		this.totalOutput += output;
	}
		
	public void writeToFile() {
		try{
		    PrintWriter writer = new PrintWriter("WarLogfile.txt", "UTF-8");
		    writer.println(this.totalOutput);
		    writer.close();
		} catch (IOException e) {
			System.err.println("Could not write to WarLogfile.txt");
			e.printStackTrace();
		}
	}

	public void war() {
		String output = "War!\n";
		System.out.print(output);
		this.totalOutput += output;
	}
		
	public void winRound(Player winner, Boolean isVariation1) { // need to implement Var1 score
		String output = winner + " wins the round\n";
		int p1Score, p2Score;
		if (isVariation1) {
			p1Score = this.player1.getTotalHand().size();
			p2Score = this.player2.getTotalHand().size();
		} else {
			p1Score = this.player1.getPointsScore();
			p2Score = this.player2.getPointsScore();
		}
		output += "Score is " + this.player1 + " " + p1Score;
		output += ", " + this.player2 + " " + p2Score;
		if (this.playerNum == 2)
			output += "\n";
		else if (this.playerNum == 3)
			output += ", " + this.player3 + " " + this.player3.getPointsScore() + "\n";
		
		System.out.print(output);
		this.totalOutput += output;
	}
	
	public void logWinner(Player winner) {
		String output = "";
		if (winner.getName().equals("default"))
			output = "Tie game!\n";
		else
			output = winner + " wins the game!\n";
		System.out.print(output);
		this.totalOutput += output;
	}
}

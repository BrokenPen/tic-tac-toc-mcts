package tic_tac_toc_mcts;

import java.util.Random;

public class GameControl {
	
	private Board b = null;
	private Player[] players = null;
	private Random randomGenerator;
	
	
	GameControl(Board b) {
		setB(b);
		randomGenerator = new Random();
		Player[] players = {new HumanPlayer("Human", Chess.CIRCLE), new StupidPlayer("Angela Baby" , Chess.CROSS)};
		if(randomGenerator.nextInt(2) == 0) {
			players[0] = new StupidPlayer("Angela Baby" , Chess.CROSS);
			players[1] = new HumanPlayer("Human", Chess.CIRCLE);
		} 				
		
		setPlayers(players);
		//this.player[0] = new HumanPlayer("KingKong", Chess::CIRCLE);
		//this.player[1] = new StupidPlayer("Angela Baby" , Chess::CROSS);
	}

	public void play() {
		int whoTurn;
		String chessCh = null;

		for(int playSide = 0; ; ++playSide) {
			
			whoTurn = (playSide % 2 == 0)? 1 : 0;
			chessCh = (players[whoTurn].getChess().equals(Chess.CIRCLE)) ? "o" : "x";
			System.out.println("Now is Player " + players[whoTurn].getPlayerName() + "'s turn, keep " + chessCh);
			//showBoard();
			
			takeTurn(players[whoTurn]);
			showBoard();
			if(b.isGameOver()) {
				System.out.printf("Winner is " + players[whoTurn].getPlayerName() + "\n");
				showBoard();
				System.exit(0);
			}
		} // end for
		
	} // end function



	private void takeTurn(Player player) {
		//player.takeMove(b);
		b.putChess(player.takeMove(b));
		//showBoard();
	}



	private void showBoard() {
		b.print();
	}
	
	
	public Player findWinner(Chess chess) {
		b.getWinningChess();
		for (Player player : getPlayers()) 
			if(player.getChess().equals(chess)) 
				return player;
		
		return null; // should never go here

	} // end function



	public Board getB() {
		return b;
	}


	private void setB(Board b) {
		this.b = b;
	}



	public Player[] getPlayers() {
		return players;
	}


	private void setPlayers(Player[] players) {
		this.players = players;
	}
	
	

}

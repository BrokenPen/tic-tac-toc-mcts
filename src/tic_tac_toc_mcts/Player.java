package tic_tac_toc_mcts;

public abstract  class Player {
	
	private Chess chess;
	private String playerName;
	
	Player(String name, Chess chess) {
		setChess(chess);
		setPlayerName(name);
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Chess getChess() {
		return chess;
	}
	
	public void setChess(Chess chess) {
		this.chess = chess;
	}
	
	public Chess getOpponentChess() {
		if(getChess() == Chess.CIRCLE) 
			return Chess.CROSS;
		else
			return Chess.CIRCLE;
	}

	public Move takeMove(Board b) {
		return new Move();
	}





}

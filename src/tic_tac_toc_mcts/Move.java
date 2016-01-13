package tic_tac_toc_mcts;

public class Move {

	private int x;
	private int y;
	private int score;
	private Chess chess;
	
	public Move() {
		this(0,0,0,Chess.EMPTY);
	}
	
	public Move(int x, int y, Chess chess) {
		this(x,y,0,chess);
	}
	
	public Move(int x, int y, int score,Chess chess) {
		setX(x);
		setY(y);
		setScore(score);
		setChess(chess);
	}
	
	public int getX() {
		return x;
	}

	private final void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	private final void setY(int y) {
		this.y = y;
	}

	public Chess getChess() {
		return chess;
	}

	public int getScore() {
		return score;
	}

	final void setScore(int score) {
		this.score = score;
	}

	final void setChess(Chess chess) {
		this.chess = chess;
	}
	
	public final Chess getOpponentChess() {
		if(getChess().equals(Chess.CIRCLE))
			return Chess.CROSS;
		else
			return Chess.CIRCLE;
	}

}

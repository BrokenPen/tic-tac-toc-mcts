package tic_tac_toc_mcts;

import java.util.ArrayList;

public class MinMaxPlayer extends Player {

	MinMaxPlayer(String name, Chess chess) {
		super(name, chess);
		// TODO Auto-generated constructor stub
	}
	
	private int getScore(final Board b, final int depth) {
		if (b.getWinningChess() == this.getChess()) 
			return 10 - depth;
		else if (b.getWinningChess() == this.getOpponentChess()) 
			return depth - 10;
		else 
			return 0;
		}
	
	public Move takeMove(Board b) {
		return minmax(b, 0);
	}

	private Move minmax(Board b, int depth) { 
		Move previousMove = b.getLastMove();
		if (b.isGameOver()) {
			previousMove.setScore(getScore(b, depth));
			return previousMove;
		}
		
		depth++;
		
		ArrayList<Move> availableMoves = b.getAvailableMove();
		Chess currentChessType = previousMove.getOpponentChess();
		for (int i=0;i<availableMoves.size();i++) {
			Move m = availableMoves.get(i);
			m.setChess(currentChessType);
			Board virtualBoard = b.cloneBoard();
			virtualBoard.putChess(m);
			Move bestMove = minmax(virtualBoard, depth);
			m.setScore(bestMove.getScore());
		}
		
		int index =0 ;
		int threshold = availableMoves.get(index).getScore();
		boolean judge; // to determine to choose min or max
		
		for (int i=1;i<availableMoves.size();i++) {
			judge = (this.getChess() == currentChessType) ? availableMoves.get(i).getScore() > threshold : availableMoves.get(i).getScore() < threshold;
			if (judge) {
				index = i;
				threshold = availableMoves.get(index).getScore();
			}
		}
		
		return availableMoves.get(index);
	}

	
}

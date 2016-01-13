package tic_tac_toc_mcts;

import java.util.ArrayList;

public class Board {
	
	private Game boardStatus = null;
	private Chess winningChess = null;
	//private int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
	private int[][] board = null;
	private ArrayList<Move> history = new ArrayList<Move>();
	
	Board() {
		// initial the board all point set empty
		board = new int[3][3];
		for(int x = 0; x < 3; ++x) {
			for(int y = 0; y < 3; ++y)
				setChessAt(x,y, Chess.EMPTY);
		}
		
		setBoardStatus(Game.IN_PLAY);	// game just starting now
		setWinningChess(Chess.EMPTY);	// empty board no chess
	}
	
	public final Game getBoardStatus() {
		return boardStatus;
	}

	private final void setBoardStatus(Game boardStatus) {
		this.boardStatus = boardStatus;
	}
	
	public final Chess getWinningChess() {
		return winningChess;
	}

	public final void setWinningChess(Chess winningChess) {
		this.winningChess = winningChess;
	}
	
	public final Chess getChessAt(int x, int y) {
		return Chess.values()[board[x][y]];
	}

	private final void setChessAt(int x, int y, Chess chess) {
		board[x][y] = chess.getValue();
	}
	
	public final int[][] getBoard() {
		return board;
	}

	private final void setBoard(int[][] board) {
		this.board = board;
	}
	
	public final ArrayList<Move> getHistory() {
		return history;
	}

	private final void setHistory(ArrayList<Move> history) {
		this.history = history;
	}
	
	public final Board cloneBoard() {
		Board cb = new Board();
		cb.setBoardStatus(this.getBoardStatus());
		cb.setWinningChess(this.getWinningChess());
		cb.setBoard(this.getBoard());
		cb.setHistory(this.getHistory());
		return cb;
	}
	
	public final void putChess(Move m) {
		setChessAt(m.getX(), m.getY(), m.getChess());
		updateBoardStatus();
	}
	
	private final void updateBoardStatus() {
		for(int x = 0; x < 3; ++x) {
			if( getChessAt(x,0).equals(getChessAt(x,1)) && getChessAt(x,1).equals(getChessAt(x,2)) )
				if(!getChessAt(x,0).equals(Chess.EMPTY)) {
					setWinningChess(getChessAt(x,0));
					setBoardStatus(Game.END);
				}
			if( getChessAt(0,x).equals(getChessAt(1,x)) && getChessAt(1,x).equals(getChessAt(2,x)) )
				if(!getChessAt(0,x).equals(Chess.EMPTY)) {
					setWinningChess(getChessAt(0,x));
					setBoardStatus(Game.END);
				}
		}
		
		if( getChessAt(0,0).equals(getChessAt(1,1)) && getChessAt(1,1).equals(getChessAt(2,2)) )
			if(!getChessAt(1,1).equals(Chess.EMPTY)) {
				setWinningChess(getChessAt(1,1));
				setBoardStatus(Game.END);
			}
		
		if( getChessAt(0,2).equals(getChessAt(1,1)) && getChessAt(1,1).equals(getChessAt(2,0)) )
			if(!getChessAt(1,1).equals(Chess.EMPTY)) {
				setWinningChess(getChessAt(1,1));
				setBoardStatus(Game.END);
			}
		
		if(getWinningChess().equals(Chess.EMPTY)) {	// still nobody win
			for(int x = 0; x < 3; ++x) 
				for(int y = 0; y < 3; ++y) 
					if(getChessAt(x,y).equals(Chess.EMPTY)) {// have empty block
						setBoardStatus(Game.IN_PLAY);
						return;	// exit function
					}	
					else 
						setBoardStatus(Game.DRAW);
		} // end if

	} // end function
	
	public final boolean isGameOver() {
		if(getBoardStatus().equals(Game.IN_PLAY)) {
			return false;
		}else
			return true;
	} // end function
	
	public final ArrayList<Move> getAvailableMove() {
		if(history != null)
			history.clear();	// reset be4 check
		//Move m;
		for(int x = 0; x < 3; ++x)
            for(int y = 0; y < 3; ++y) 
            	if( getChessAt(x, y).equals(Chess.EMPTY)) {
                //if( !getChessAt(x, y).equals(Chess.EMPTY)) {
                    //m = new Move(x, y, Chess.EMPTY);
                    history.add(new Move(x, y, Chess.EMPTY));
                } // end if
		return history;
	} // end function

	

	public void print() {
		String chessCh = "";
		 for(int x = 0; x < 3; ++x)
	            for(int y = 0; y < 3; ++y) {
	                chessCh = " ";
	                if( getChessAt(x, y).equals(Chess.CIRCLE)) chessCh = "O";
	                if( getChessAt(x, y).equals(Chess.CROSS)) chessCh = "X";
	                System.out.printf("|%s%s", chessCh, y == 2 ? "|\n" : "");
	            } // end inner for
		 
		 System.out.printf("=========\n");		
	} // end function
	

	public final Move getLastMove() {
		return history.get(history.size() - 1);
	}

}

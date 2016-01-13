package tic_tac_toc_mcts;

import java.util.Random;

public class StupidPlayer extends Player {

	private Random randomGenerator;

	StupidPlayer(String name, Chess chess) {
		super(name, chess);
		// TODO Auto-generated constructor stub
	}
	

	public final Move takeMove(Board b) {
		randomGenerator = new Random();
		int fin = randomGenerator.nextInt(b.getAvailableMove().size());
		if(fin < 0)
			fin = 0;
		//int fin = (int) Math.round(Math.random()*b.getAvailableMove().size());
		
		return new Move(b.getAvailableMove().get(fin).getX(),b.getAvailableMove().get(fin).getY(), getChess());
	}

}

package tic_tac_toc_mcts;

import java.util.Scanner;



public class HumanPlayer extends Player {

	private Scanner sc;


	HumanPlayer(String name, Chess chess) {
		super(name, chess);
		// TODO Auto-generated constructor stub
	}
	

	public Move takeMove(Board b) {
		b.print();
		System.out.println("Available Move : ");
		for(Move m : b.getAvailableMove()) {
			System.out.println("(" + m.getX() + ", " + m.getY() + ")" );
		}
		
		System.out.println("Enter next move : (example 0,0)");
		sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] pointStr = input.split(",");
		int[] point = {0, 0};
		point[0] = Integer.parseInt(pointStr[0].trim());
		point[1] = Integer.parseInt(pointStr[1].trim());
		//int x = sc.nextInt();
		//int y = sc.nextInt();
		//s2c.close();
		return new Move(point[0], point[1], getChess());
		//return new Move(x, y, getChess());
	}

}

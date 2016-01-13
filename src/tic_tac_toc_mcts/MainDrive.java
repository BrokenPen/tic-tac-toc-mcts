package tic_tac_toc_mcts;

@Author(
		   name = "Alan Kung(Brokenpen)",
		   date = "2016-01-09"
		)

public class MainDrive {
	public static void main(String[] args) {
		GameControl game = new GameControl(new Board());
		game.play();
	}
}
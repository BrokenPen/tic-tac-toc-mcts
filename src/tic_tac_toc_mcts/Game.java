package tic_tac_toc_mcts;

public enum Game {
	 END(0) , IN_PLAY(1) , DRAW(2);
	
	private final int value;
    private Game(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

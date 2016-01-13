package tic_tac_toc_mcts;

public enum Chess {
	EMPTY(0) , CIRCLE(1) , CROSS(2);

 	private final int value;
    private Chess(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}


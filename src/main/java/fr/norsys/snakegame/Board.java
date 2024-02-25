package fr.norsys.snakegame;

public class Board {

    private final int B_WIDTH ;
    private final int B_HEIGHT ;

    public Board(int boardWidth, int boardHeight) {
        this.B_WIDTH = boardWidth;
        this.B_HEIGHT = boardHeight;
    }

    public int getHeight() {
        return B_HEIGHT;
    }

    public int getWidth() {
        return B_WIDTH;
    }
}


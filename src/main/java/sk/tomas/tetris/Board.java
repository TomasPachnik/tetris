package sk.tomas.tetris;

public interface Board {

    boolean move(Input input);

    void printBoard();

    int score();

    double [] boardInfo();
}

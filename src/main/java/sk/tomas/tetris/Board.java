package sk.tomas.tetris;

public interface Board {

    void move(Input input);

    void printBoard();

    int score();

    double [] boardInfo();
}

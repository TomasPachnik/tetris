package sk.tomas.tetris;

import sk.tomas.ga.Strategy;
import sk.tomas.neural.Network;

public class StrategyImpl implements Strategy {

    @Override
    public double run(Network network) {
        Board board = new BoardImpl();
        boolean alive = true;
        while (alive) {
            Input input = Input.map(network.run(board.boardInfo()));
            alive = board.move(input);
          /*  board.printBoard();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(board.score());*/
            if (board.score() < -40) {
                alive = false;
            }
        }
        return board.score();
    }
}

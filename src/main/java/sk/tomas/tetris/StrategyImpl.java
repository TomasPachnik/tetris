package sk.tomas.tetris;

import sk.tomas.ga.Strategy;
import sk.tomas.neural.Network;

public class StrategyImpl implements Strategy {

    @Override
    public double run(Network network) {
        Board board = new BoardImpl();
        boolean alive = true;
        while (alive) {
            Input input = Input.map(network.run(board.boardInfoLite()));
            //System.out.println(input);
            alive = board.move(input);
            if (board.score() < -100) {
              //  System.out.println("slo to tadialto");
                alive = false;
            }
        }

        return board.score();
    }
}

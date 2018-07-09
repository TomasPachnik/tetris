package sk.tomas.tetris;

import org.junit.Test;
import sk.tomas.ga.Genetic;
import sk.tomas.ga.GeneticImpl;
import sk.tomas.ga.Strategy;
import sk.tomas.neural.FileException;
import sk.tomas.neural.Network;
import sk.tomas.neural.NetworkImpl;

public class RotationTest {


    @Test
    public void writeTest() throws FileException {
        Strategy strategy = new StrategyImpl();

        Genetic genetic = new GeneticImpl(14, 10, 4, strategy);
        //genetic.loadState();
        genetic.setNetworkRuns(10);
        genetic.setGenerations(100);
        genetic.autoSave(true);
        Network best = genetic.run();

        best.saveState("best");
    }

    @Test
    public void readTest() throws FileException, InterruptedException {
        Network network = new NetworkImpl(14, 10, 4);
        network.loadState("best");
        Board board = new BoardImpl();
        board.printBoard();
        boolean alive = true;
        while (alive) {
            alive = board.move(Input.map(network.run(board.boardInfo())));
            board.printBoard();
            Thread.sleep(300);
        }
        System.out.println(board.score());
    }

}

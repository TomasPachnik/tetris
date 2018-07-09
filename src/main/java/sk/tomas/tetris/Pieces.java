package sk.tomas.tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * array of tetris pieces
 */
class Pieces {

    private List<Integer[][]> array;
    private Random random;

    Pieces() {
        this.array = init();
        random = new Random();
    }

    private List<Integer[][]> init() {
        List<Integer[][]> array = new ArrayList<>();

        //Z piece
        Integer[][] zPiece = new Integer[][]{
                {1, 1, 0},
                {0, 1, 1},
                {0, 0, 0}
        };

        //reverted Z piece
        Integer[][] zReverted = new Integer[][]{
                {0, 2, 2},
                {2, 2, 0},
                {0, 0, 0}
        };

        //I piece
        Integer[][] iPiece = new Integer[][]{
                {0, 0, 0, 0},
                {3, 3, 3, 3},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        //L piece
        Integer[][] lPiece = new Integer[][]{
                {0, 0, 4},
                {4, 4, 4},
                {0, 0, 0}
        };

        //reverted L piece
        Integer[][] lReverted = new Integer[][]{
                {5, 0, 0},
                {5, 5, 5},
                {0, 0, 0}
        };

        //O piece
        Integer[][] oPiece = new Integer[][]{
                {6, 6},
                {6, 6}
        };

        //T piece
        Integer[][] tPiece = new Integer[][]{
                {0, 7, 0},
                {7, 7, 7},
                {0, 0, 0}
        };

        array.add(zPiece);
        array.add(zReverted);
        array.add(lPiece);
        array.add(lReverted);
        array.add(iPiece);
        array.add(oPiece);
        array.add(tPiece);

        return array;
    }

    Integer[][] getRandom() {
        return array.get(random.nextInt(array.size()));
    }

}

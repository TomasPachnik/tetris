package sk.tomas.tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * tetris pieces
 */
class Pieces {

    private List<Piece> pieces;
    private Random random;

    Pieces() {
        this.pieces = init();
        random = new Random();
    }

    private List<Piece> init() {
        //Z piece
        List<Integer[][]> zPiece = new ArrayList<>();
        zPiece.add(new Integer[][]{{1, 1, 0}, {0, 1, 1}, {0, 0, 0}});
        zPiece.add(new Integer[][]{{0, 1, 0}, {1, 1, 0}, {1, 0, 0}});
        zPiece.add(new Integer[][]{{1, 1, 0}, {0, 1, 1}, {0, 0, 0}});
        zPiece.add(new Integer[][]{{0, 1, 0}, {1, 1, 0}, {1, 0, 0}});

        //reverted Z piece
        List<Integer[][]> zReverted = new ArrayList<>();
        zReverted.add(new Integer[][]{{0, 1, 1}, {1, 1, 0}, {0, 0, 0}});
        zReverted.add(new Integer[][]{{1, 0, 0}, {1, 1, 0}, {0, 1, 0}});
        zReverted.add(new Integer[][]{{0, 1, 1}, {1, 1, 0}, {0, 0, 0}});
        zReverted.add(new Integer[][]{{1, 0, 0}, {1, 1, 0}, {0, 1, 0}});

        //I piece
        List<Integer[][]> iPiece = new ArrayList<>();
        iPiece.add(new Integer[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}});
        iPiece.add(new Integer[][]{{0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}});
        iPiece.add(new Integer[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}});
        iPiece.add(new Integer[][]{{0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}});


        //L piece
        List<Integer[][]> lPiece = new ArrayList<>();
        lPiece.add(new Integer[][]{{1, 0, 0}, {1, 1, 1}, {0, 0, 0}});
        lPiece.add(new Integer[][]{{0, 1, 0}, {0, 1, 0}, {1, 1, 0}});
        lPiece.add(new Integer[][]{{1, 1, 1}, {0, 0, 1}, {0, 0, 0}});
        lPiece.add(new Integer[][]{{1, 1, 0}, {1, 0, 0}, {1, 0, 0}});

        //reverted L piece
        List<Integer[][]> lReverted = new ArrayList<>();
        lReverted.add(new Integer[][]{{0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
        lReverted.add(new Integer[][]{{1, 1, 0}, {0, 1, 0}, {0, 1, 0}});
        lReverted.add(new Integer[][]{{1, 1, 1}, {1, 0, 0}, {0, 0, 0}});
        lReverted.add(new Integer[][]{{1, 0, 0}, {1, 0, 0}, {1, 1, 0}});

        //O piece
        List<Integer[][]> oPiece = new ArrayList<>();
        oPiece.add(new Integer[][]{{1, 1}, {1, 1}});
        oPiece.add(new Integer[][]{{1, 1}, {1, 1}});
        oPiece.add(new Integer[][]{{1, 1}, {1, 1}});
        oPiece.add(new Integer[][]{{1, 1}, {1, 1}});

        //T piece
        List<Integer[][]> tPiece = new ArrayList<>();
        tPiece.add(new Integer[][]{{0, 1, 0}, {1, 1, 1}, {0, 0, 0}});
        tPiece.add(new Integer[][]{{0, 1, 0}, {1, 1, 0}, {0, 1, 0}});
        tPiece.add(new Integer[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}});
        tPiece.add(new Integer[][]{{1, 0, 0}, {1, 1, 0}, {1, 0, 0}});

        //all together
        List<Piece> result = new ArrayList<>();
        result.add(new Piece(zPiece, 1));
        result.add(new Piece(zReverted, 2));
        result.add(new Piece(iPiece, 3));
        result.add(new Piece(lPiece, 4));
        result.add(new Piece(lReverted, 5));
        result.add(new Piece(oPiece, 6));
        result.add(new Piece(tPiece, 7));

        return result;
    }

    Integer[][] rotate(int pieceType, int index) {
        return getPiece(pieceType).getPiece().get(index);
    }

    private Piece getPiece(int pieceType) {
        for (Piece piece : pieces) {
            if (piece.getType() == pieceType) {
                return piece;
            }
        }
        throw new RuntimeException("wrong index");
    }

    Piece getRandom() {
        return getPiece(random.nextInt(pieces.size()));
    }

}
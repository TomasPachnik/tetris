package sk.tomas.tetris;

import java.util.List;

class Piece {

    private List<Integer[][]> piece;
    private int type;

    Piece(List<Integer[][]> piece, int pieceType) {
        this.piece = piece;
        this.type = pieceType;
    }

    List<Integer[][]> getPiece() {
        return piece;
    }

    int getType() {
        return type;
    }
}

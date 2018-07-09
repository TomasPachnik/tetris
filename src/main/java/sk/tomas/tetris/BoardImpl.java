package sk.tomas.tetris;

import java.util.ArrayList;
import java.util.List;

/**
 * game board
 */
public class BoardImpl implements Board {

    private final int boardWidth = 10;
    private final int boardHeight = 22;
    private final int invisibleHeight = 2;

    private Pieces pieces;

    private int[][] board;
    private Integer[][] spawnedPiece;
    private int pieceType = 0;
    private Integer[] spawnedLocation;

    BoardImpl() {
        board = new int[boardWidth][boardHeight];
        pieces = new Pieces();
        spawnPiece();
    }

    private void spawnPiece() {
        spawnedPiece = pieces.getRandom();
        pieceType = 0;
        //x axis, y axis, rotation
        spawnedLocation = new Integer[]{0, (boardWidth / 2) - (spawnedPiece.length / 2), 0};
    }

    private Integer[] clone(Integer[] input) {
        Integer[] result = new Integer[input.length];
        System.arraycopy(input, 0, result, 0, input.length);
        return result;
    }

    @Override
    public void move(Input input) {
        State state;
        Integer[] clone;
        switch (input) {
            case LEFT:
                clone = clone(spawnedLocation);
                clone[1]--;
                state = calculateNewPosition(clone, false);
                break;
            case RIGHT:
                clone = clone(spawnedLocation);
                clone[1]++;
                state = calculateNewPosition(clone, false);
                break;
            case ROTATE:
                clone = clone(spawnedLocation);
                clone[2]++;
                state = calculateNewPosition(clone, false);
                break;
            case DOWN:
            default:
                clone = clone(spawnedLocation);
                clone[0]++;
                state = calculateNewPosition(clone, true);
                break;
        }

        switch (state) {
            case DOWN:
                addToBoard(calculateNewPosition(spawnedLocation));
                break;
            case BLOCKED:
                //do nothing
                break;
            default:
            case AVAILABLE:
                spawnedLocation = clone;
                break;
        }
    }

    private List<Integer[]> calculateNewPosition(Integer[] location) {
        List<Integer[]> array = new ArrayList<>();

        switch (location[2] % 4) {
            case 0:
            default:
                for (int i = 0; i < spawnedPiece.length; i++) {
                    for (int j = 0; j < spawnedPiece[0].length; j++) {
                        if (spawnedPiece[i][j] > 0) {
                            pieceType = spawnedPiece[i][j];
                            array.add(new Integer[]{location[0] + i, location[1] + j});
                        }
                    }
                }
                break;
            case 1:
                for (int j = 0; j < spawnedPiece[0].length; j++) {
                    for (int i = 0; i < spawnedPiece.length; i++) {
                        if (spawnedPiece[i][j] > 0) {
                            pieceType = spawnedPiece[i][j];
                            array.add(new Integer[]{location[0] + j, location[1] + i});
                        }
                    }
                }
                break;
            case 2:
                for (int i = spawnedPiece[0].length - 1; i >= 0; i--) {
                    for (int j = 0; j < spawnedPiece.length; j++) {
                        if (spawnedPiece[i][j] > 0) {
                            pieceType = spawnedPiece[i][j];
                            array.add(new Integer[]{location[0] + spawnedPiece[0].length - i - 1, location[1] + j});
                        }
                    }
                }
                break;

            case 3:
                for (int j = 0; j < spawnedPiece[0].length; j++) {
                    for (int i = spawnedPiece[0].length - 1; i >= 0; i--) {
                        if (spawnedPiece[i][j] > 0) {
                            pieceType = spawnedPiece[i][j];
                            array.add(new Integer[]{location[0] + j, location[1] + spawnedPiece[0].length - i - 1});
                        }
                    }
                }
                break;
        }
        return array;
    }

    private State calculateNewPosition(Integer[] location, boolean down) {

        for (Integer[] integer : calculateNewPosition(location)) {
            if (integer[0] >= boardHeight) {
                return State.DOWN;
            }
            if (integer[1] >= boardWidth || integer[1] < 0) {
                return State.BLOCKED;
            }
            if (board[integer[1]][integer[0]] > 0) {
                if (down) {
                    return State.DOWN;
                } else {
                    return State.BLOCKED;
                }
            }
        }

        return State.AVAILABLE;
    }

    private void addToBoard(List<Integer[]> list) {
        for (Integer[] array : list) {
            board[array[1]][array[0]] = pieceType;
        }
        checkFullLine();
        spawnPiece();
    }

    //TODO implement
    private void checkFullLine() {

    }

    public void printBoard() {
        List<Integer[]> list = calculateNewPosition(spawnedLocation);

        for (int i = invisibleHeight; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                boolean found = false;
                for (Integer[] array : list) {
                    if (array[0] == i && array[1] == j) {
                        found = true;
                    }
                }
                if (found) {
                    //System.out.print(pieceType);
                    System.out.print("x");
                } else {
                    //System.out.print(board[j][i]);
                    if (board[j][i] > 0) {
                        System.out.print("x");
                    } else {
                        System.out.print(".");
                    }
                }

            }
            System.out.println();
        }
        System.out.println();
    }

}

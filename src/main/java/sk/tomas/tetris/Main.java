package sk.tomas.tetris;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BoardImpl board = new BoardImpl();

        Scanner keyboard = new Scanner(System.in);
        boolean alive = true;
        while (alive) {
            board.printBoard();
            String input = keyboard.nextLine();
            if (input != null) {
                if ("p".equals(input)) {
                    alive = false;
                } else
                    switch (input) {
                        case "w":
                            alive = board.move(Input.ROTATE);
                            break;
                        case "a":
                            alive = board.move(Input.LEFT);
                            break;
                        case "s":
                            alive = board.move(Input.DOWN);
                            break;
                        case "d":
                            alive = board.move(Input.RIGHT);
                            break;
                    }

            }
        }
        keyboard.close();
    }

}

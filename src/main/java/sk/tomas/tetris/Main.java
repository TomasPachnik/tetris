package sk.tomas.tetris;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BoardImpl board = new BoardImpl();

        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            board.printBoard();
            String input = keyboard.nextLine();
            if (input != null) {
                if ("p".equals(input)) {
                    exit = true;
                } else
                    switch (input) {
                        case "w":
                            board.move(Input.ROTATE);
                            break;
                        case "a":
                            board.move(Input.LEFT);
                            break;
                        case "s":
                            board.move(Input.DOWN);
                            break;
                        case "d":
                            board.move(Input.RIGHT);
                            break;
                    }

            }
        }
        keyboard.close();
    }

}

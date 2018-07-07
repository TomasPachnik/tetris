package sk.tomas.tetris;

import org.junit.Test;

public class RotationTest {

    @Test
    public void rotationTest() {
        Pieces pieces = new Pieces();
        Integer[][] random = pieces.getRandom();

        for (int i = 0; i < random.length; i++) {
            for (int j = 0; j < random[0].length; j++) {
                if (random[i][j] > 0) {
                    System.out.print("1");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int j = 0; j < random[0].length; j++) {
            for (int i = 0; i < random.length; i++) {
                if (random[i][j] > 0) {
                    System.out.print("1");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = random[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < random.length; j++) {
                if (random[i][j] > 0) {
                    System.out.print("1");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int j = 0; j < random[0].length; j++) {
            for (int i = random[0].length - 1; i >= 0; i--) {
                if (random[i][j] > 0) {
                    System.out.print("1");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }

    }


}

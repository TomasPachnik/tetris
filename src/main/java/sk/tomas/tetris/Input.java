package sk.tomas.tetris;

public enum Input {

    LEFT, RIGHT, DOWN, ROTATE;

    public static Input map(double[] input) {
        double max = Math.max(Math.max(Math.max(input[0], input[1]), input[2]), input[3]);
        for (int i = 0; i < input.length; i++) {
            if (max == input[i]) {
                return getById(i);
            }
        }
        throw new RuntimeException("this should not happen at all");
    }

    public static Input getById(int input) {
        switch (input) {
            case 0:
                return LEFT;
            case 1:
                return RIGHT;
            case 2:
                return DOWN;
            case 3:
                return ROTATE;
        }
        return DOWN;
    }

}

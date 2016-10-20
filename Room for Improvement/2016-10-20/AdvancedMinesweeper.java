import java.util.Random;

public class AdvancedMinesweeper {

    public static final char EMPTY_FIELD = '.';
    public static final char MINE = '*';
    private char[][] field;
    public static final int[][] DIRECTIONS = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 },
            { 1, -1 }, { 1, 0 }, { 1, 1 } };

    public MineSweeper(int fieldLength) {
        field = new char[fieldLength][];
        generateMineField();
        fillField();
    }

    public char[][] getField() {
        return field;
    }

    public void scanField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == EMPTY_FIELD) {
                    int mineCount = countNeighbours(i, j);
                    if (mineCount > 0) {
                        field[i][j] = Integer.toString(mineCount).charAt(0);
                        // field[i][j] = Character.forDigit(mineCount, 10);
                        // field[i][j] = (char) (mineCount + 48);
                    }
                }
            }
        }
    }

    private int countNeighbours(int i, int j) {
        int count = 0;

        for (int[] d : DIRECTIONS) {
            int di = d[0] + i;
            int dj = d[1] + j;

            if (di >= 0 && di < field.length && dj >= 0 && dj < field[di].length && field[di][dj] == MINE) {
                count++;
            }
        }

        return count;
    }

    private void fillField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = Math.random() > 0.5 ? MINE : EMPTY_FIELD;
            }
        }
    }

    private void generateMineField() {
        Random rand = new Random();
        for (int i = 0; i < field.length; i++) {
            int rowLength = rand.nextInt(9);
            field[i] = new char[rowLength + 1];
        }
    }

    public static void main(String[] args) {
        AdvancedMinesweeper ams = new MineSweeper(10);
        ams.scanField();
        char[][] field = ams.getField();

        for (char[] is : field) {
            for (char c : is) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
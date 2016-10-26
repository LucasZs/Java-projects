import java.util.Arrays;

public class MatrixRotater {
	/*
	Example:
	input matrix:	count 1 = 90°:	count 2 = 180°:		count 3 = 270°:
			1 2 3			4 1				6 5 4				3 6
			4 5 6			5 2				3 2 1				2 5
							6 3									1 4
*/
	public static int[][] rotateOnce(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            result[i] = reverse(getColumn(matrix, i));
        }
        return result;
    }
    public static int[][] rotateTwice(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = reverse(matrix[matrix.length - 1 - i]);
        }
        return result;
    }
    public static int[][] rotateThreeTimes(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            result[i] = getColumn(matrix, matrix[0].length - 1 - i);
        }
        return result;
    }
    public static int[][] rotate(int[][] matrix, int n) {
        if (matrix == null) {
            return null;
        }
        n %= 4;
        if (n == 0) {
            return matrix;
        }
        int[][] result;
        if (n == 1) {
            result = rotateOnce(matrix);
        } else if (n == 2) {
            result = rotateTwice(matrix);
        } else {
            result = rotateThreeTimes(matrix);
        }
        return result;
    }
    public static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[i][columnIndex];
        }
        return result;
    }
    public static int[] reverse(int[] array) {
        int[] result = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            result[array.length - 1 - i] = array[i];
        }
        // for (int i = 0; i < array.length; i++) {
        // result[i] = array[array.length - 1 - i];
        // }
        return result;
    }
    public static void main(String[] args) {
        int[][] result = { { 1, 2, 3 }, { 4, 5, 6 } };
        result = rotate(result, -111);
        for (int[] i : result) {
            System.out.println(Arrays.toString(i));
        }
    }

	
}

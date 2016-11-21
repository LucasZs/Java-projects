import java.util.Arrays;

public class MatrixRotater
{
	public static int[][] rotate(int[][] matrix, int n)
	{
		if(n % 4 == 0)
		{
			return matrix;
		}
		
		else if(n % 4 == 1)
		{
			return rotateWith90(matrix);
		}
		
		else if(n % 4 == 2)
		{
			return rotateWith90(rotateWith90(matrix));
		}
		return rotateWith90(rotateWith90(rotateWith90(matrix)));
	
	}
	
	public static int[][] rotateWith90(int[][] matrix)
	{
		int[][] result = new int[matrix[0].length][matrix.length];
		for(int i = 0; i < matrix[0].length; i++)
		{
			result[i] = reverse(getColumn(matrix, i));
			
		}
		return result;
	}
	
	public static int[] getColumn(int[][] matrix, int n)
	{
		int[] column = new int[matrix.length];
		for(int i = 0; i < matrix.length; i++)
		{
			column[i] = matrix[i][n];
		}
		return column;
	}
	
	public static int[] reverse(int[] a)
	{
		int[] result = new int[a.length];
		for(int i = 0; i < result.length; i++)
		{
			result[i] = a[a.length-i-1];
		}
		return result;
	}
	
	public static void printMatrix(int[][] matrix)
	{
		for(int[] row : matrix)
		{
			System.out.println(Arrays.toString(row));
		}
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {
			{1, 2, 3},
			{4, 5, 6}
		};
		
		int[][] rotate1 = rotate(matrix, 1);
		int[][] rotate2 = rotate(matrix, 2);
		int[][] rotate3 = rotate(matrix, 3);
		int[][] rotate4 = rotate(matrix, 4);
		
		printMatrix(rotate1);
		printMatrix(rotate2);
		printMatrix(rotate3);
		printMatrix(rotate4);
	
	}
}
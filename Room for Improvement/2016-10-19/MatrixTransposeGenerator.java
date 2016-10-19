/*
Write a method which is able to generate the transpose of a matrix.
The number of rows and number of columns are not equal!
Example:
[1, 2, 3]   ->      [1, 4]
[4, 5, 6]           [2, 5]
                    [3, 6]
Usage of the followings are FORBIDDEN:
- internet
- IDE
- classes outside of java.lang package
- boxing classes like java.lang.Integer, etc.
*/                  

class MatrixTransposeGenerator
{
	public static int[][] generateTranspose(int[][] matrix)
	{
		if(matrix == null){
			return null;
		}
		
		if(matrix.length == 0)
		{
			return null;
		}
		
		if(matrix[0] == null)
		{
			return null;
		}
		
		int firstRowLength = matrix[0].length;
		
		for (int i = 1; i < matrix.length; i++) {
			if(matrix[i] == null || firstRowLength != matrix[i].length){
				return null;
			}
		}
		
		int[][] result = new int[matrix[0].length][matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				result[j][i] = matrix[i][j];
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] inputMatrix = new int[][]{{1, 2, 3}, {4, 5, 6}};
		int[][] resultMatrix = generateTranspose(inputMatrix);
		for (int[] row : resultMatrix) {
			System.out.println();
			for (int i : row) {
				System.out.println(i);
				
			}
			
		}
	}
}
import java.util.Arrays;

public class MultiplierWithMinusOneOfTheEvenRowsAndColumnsInTheArray {

	public int[][] multiplyTheEvenRowsWithMinusOne(int[][] array){
		for (int i = 0; i < array.length; i++) {
			if(!(i%2==0)){
				for (int j = 0; j < array[i].length; j++) {
					array[i][j] = -array[i][j];
				}
			}
		}
		return array;
	}
	
	public int[][] multiplyTheEvenColumnsWithMinusOne(int[][] array){
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++){
				if(!(j%2==0)){
					array[i][j] = -array[i][j];
				}
			}
		}
		return array;
	}
	
	public int[][] combineTheTwoMultiplyMethods(int[][] array){
		multiplyTheEvenRowsWithMinusOne(array);
		multiplyTheEvenColumnsWithMinusOne(array);
		return array;
	}
	
	public static void main(String[] args) {
		
		int[][] array = new int[][]{
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 16}
		};
		
		MultiplierWithMinusOneOfTheEvenRowsAndColumnsInTheArray m = new MultiplierWithMinusOneOfTheEvenRowsAndColumnsInTheArray();
		int[][] result = m.combineTheTwoMultiplyMethods(array);
		for (int[] i : result) {
			System.out.println(Arrays.toString(i));
			
		}
		
	}
}
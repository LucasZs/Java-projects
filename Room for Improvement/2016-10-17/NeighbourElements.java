import java.util.ArrayList;
import java.util.List;

public class NeighbourElements {
	public final int[][] DIRECTIONS = new int[][] {
		{-1, -1}, {-1, 0}, {-1, 1},
		{0, -1}, {0, 1},
		{1, -1}, {1, 0}, {1, 1}
	};
	
	public int[] getNeighbours(int[][] array, int i, int j)
	{
		List<Integer> resultAsList = new ArrayList<>();
		for(int[] d : DIRECTIONS)
		{
			int di= i + d[0];
			int dj = j + d[1];
			if(di >= 0 && dj >= 0 && di < array.length && dj < array[di].length){
				resultAsList.add(array[di][dj]);
			}
		}
		int[] result = new int[resultAsList.size()];
		for (int k = 0; k < resultAsList.size(); k++) {
			result[k] = resultAsList.get(k);
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		int[][] array = new int[][]{
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 16}
		};
		NeighbourElements ne = new NeighbourElements();
		int[] result = ne.getNeighbours(array, 2, 3);
		for (int integer : result) {
			System.out.println(integer);
		}
	}
}
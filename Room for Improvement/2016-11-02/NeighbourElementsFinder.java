public class NeighbourElementsFinder
{
	public static final int[][] DIRECTIONS = {
		{-1, -1}, {-1, 0}, {-1, 1},
		{0, -1}, {0, 1},
		{1, -1}, {1, 0}, {1, 1}
			
	};
	public static int[] getNeighbourElements(int[][] input, int i, int j){
		
		List<Integer> result = new ArrayList<>();
		for(int[] d : DIRECTIONS){
			int di = d[0] + i;
			int dj = d[1] + j;
			if(di >= 0 && di < input.length && dj >= 0 && dj < input[di].length)
			result.add(input[di][dj]);
		}
		int[] neighbours = new int[result.size()];
		for(int i = 0; i < result.size(); i++){
			neighbours[i] = result.get(i);
		}
		return neighbours;
	}
	
	public static void main(String[] args){
		int[][] field = {
			{1, 2, 3},
			{4, 5, 6, 7},
			{8, 9, 10},
			{11}
		};
		
		int[] neighbours = getNeighbourElements(field, 1, 2);
		System.out.println(Arrays.toString(neighbours);
	}
}
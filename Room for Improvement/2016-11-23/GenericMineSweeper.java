import java.util.Arrays;
public class GenericMineSweeper <T> {
    
    T[][] field;
    static final int [][] DIRECTIONS = new int[][]{
        {-1, -1}, {-1, 0}, {-1, 1}, {0, -1},
        {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };
        
    T emptyField;
    T mine;
    
	public GenericMineSweeper(T[][] field, T emptyField, T mine) {
		this.field = field;
		this.emptyField = emptyField;
		this.mine = mine;
	}

	public int[][] detect(){
		int[][] result = new int[field.length][field[0].length];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                int count = 9;
            	if(field[i][j] == emptyField){
                    count = countNeighbours(i, j);
                }
            	result[i][j] = count;
            }
        }
        return result;
    }
    
    public int countNeighbours(int i, int j){
        
        int count = 0;
        for (int[] dir : DIRECTIONS) {
            int di = i + dir[0];
            int dj = j + dir[1];
            if (di >= 0 && di < field.length && dj >= 0 && dj < field[di].length && field[di][dj] == mine )
            {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
    	Integer[][] field = new Integer[][]{
            {0, 0,0, 0,0, 0,1, 0},
            {0, 0,0, 0,0, 0,0, 0},
            {1, 1,0, 0,0, 0,1, 0},
            {0, 0,0, 1,0, 0,0, 0},
            {0, 0,0, 0,1, 1,0, 0},
            {0, 0,1, 0,0, 0,1, 0},
            {0, 0,0, 0,1, 0,0, 0},
            {0, 0,0, 0,0, 0,0, 0}
        };
    	
        GenericMineSweeper<Integer> m = new GenericMineSweeper<>(field, 0, 1);
        int[][] result = m.detect();
        for (int[] cs : result) {
            System.out.println(Arrays.toString(cs));
        }
    }
}
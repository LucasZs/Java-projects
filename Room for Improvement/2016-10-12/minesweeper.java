import java.util.Arrays;
public class MineSweeper {
    
    char[][] field = new char[][]{
        {'.', '.','.', '.','.', '.','*', '.'},
        {'.', '.','.', '.','.', '.','.', '.'},
        {'*', '*','.', '.','.', '.','*', '.'},
        {'.', '.','.', '*','.', '.','.', '.'},
        {'.', '.','.', '.','*', '*','.', '.'},
        {'.', '.','*', '.','.', '.','*', '.'},
        {'.', '.','.', '.','*', '.','.', '.'},
        {'.', '.','.', '.','.', '.','.', '.'}
    };
    static final int [][] DIRECTIONS = new int[][]{
        {-1, -1}, {-1, 0}, {-1, 1}, {0, -1},
        {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };
        
    
    public char[][] detect(){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if(field[i][j] == '.'){
                    int count = countNeighbours(i, j);
                    if (count > 0){
                        field[i][j] = Character.forDigit(count, 10);
                    }
                }
            }
        }
        return field;
    }
    
    public int countNeighbours(int i, int j){
        
        int count = 0;
        for (int[] dir : DIRECTIONS) {
            int di = i + dir[0];
            int dj = j + dir[1];
            if (di >= 0 && di < field.length && dj >= 0 && dj < field[di].length && field[di][dj] == '*' )
            {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        MineSweeper m = new MineSweeper();
        char[][] result = m.detect();
        for (char[] cs : result) {
            System.out.println(Arrays.toString(cs));
        }
    }
}
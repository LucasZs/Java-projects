import java.util.Arrays;

public class GenericPickLocker {
    // static String[] KEYS = new String[] { "a", "b", "c" };
    static Integer[] KEYS = new Integer[] { 0, 1, 2, 3 };
    public static <T> T[][] crack(int num, T[] input) {
        Object[][] result = new Object[(int) Math.pow(input.length, num)][];
        int[] actualIndexArr = new int[num];
        for (int j = 0; j < result.length; j++) {
            Object[] actualArr = new Object[num];
            for (int i = 0; i < actualIndexArr.length; i++) {
                actualArr[i] = (T) input[actualIndexArr[i]];
            }
            result[j] = (T[]) actualArr;
            for (int i = actualIndexArr.length - 1; i >= 0; i--) {
                actualIndexArr[i]++;
                if (actualIndexArr[i] != input.length) {
                    break;
                }
                actualIndexArr[i] = 0;
            }
        }
        return (T[][]) result;
    }
	
    // public static boolean isLast(int[] actual) {
    // for (int i : actual) {
    // if (KEYS[i] != KEYS[KEYS.length - 1]) {
    // return false;
    // }
    // }
    // return true;
    // }
	
    public static void main(String[] args) {
        // 0000, 0001, 0002, 0003, 0010, 0011....3333
        Object[][] result = crack(4, KEYS);
        for (Object[] string : result) {
            System.out.println(Arrays.toString(string));
        }
    }
}
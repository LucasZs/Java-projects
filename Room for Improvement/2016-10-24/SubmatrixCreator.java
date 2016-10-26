/*
 * adott egész számokból álló kétdimenziós tömb
 * egy elemének koordinátáit megkapja egy metódus
 * megkap egy másik számot, amely azt fogja jelenteni, hogy egy adott méretû mezõ
 * körül milyen rádiuszban nézze a szomszédokat
 * egy mátrixszal tér vissza, amely a szomszédokból és a központi mezõbõl áll az
 * eredeti elrendezésben
 */
import java.util.Arrays;

public class SubmatrixCreator
{
	/*
	 * 35 --> 90
	 * i >= 2; i <= inputArray.length - 1
	 * j >= 4; j <= inputArray[i].length - 1
	 * 35 --> 57
	 * i >= 2; i <= inputArray.length - 1
	 * j >= 4; j <= inputArray[i].length - 1
	 */

	// 46-os számú mezõ koordinátái: X = 5, Y = 3  
	public int[][] getEnvironment(int[][] inputArray, int y, int x, int radius)
	{
		int[][] result = new int[radius * 2 + 1][radius * 2 + 1];

		for (int i = y - radius; i <= y + radius; i++)
		{
			for (int j = x - radius; j <= x + radius; j++)
			{
				if (i >= 0 && i < inputArray.length &&
					j >= 0 && j < inputArray[i].length)
				{
					result[i - y + radius][j - x + radius] = inputArray[i][j];
				}
			}
		}

		return result;
	}

	public static void main(String[] args)
	{
		int[][] inputArray = new int[][] {
		        //00  01  02  03  04  05  06  07  08  09 X		 Y
		        { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },   // 0
		        { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 },   // 1
		        { 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 },   // 2
		        { 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 },   // 3
		        { 51, 52, 53, 54, 55, 56, 57, 58, 59, 60 },   // 4
		        { 61, 62, 63, 64, 65, 66, 67, 68, 69, 70 },   // 5
		        { 71, 72, 73, 74, 75, 76, 77, 78, 79, 80 },   // 6
		        { 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 } };   // 7
		int indexI = 3;
		int indexJ = 5;
		int radius = 4;

		SubmatrixCreator subMatrix = new SubmatrixCreator();
		int[][] resultSubMatrix = subMatrix.getEnvironment(inputArray, indexI, indexJ, radius);
		
		for (int[] row : resultSubMatrix)
		{
			System.out.println(Arrays.toString(row));
		}

		/*
		 * 33, 34, 35
		 * 43, 44, 45
		 * 53, 54, 55
		 */
	}
}
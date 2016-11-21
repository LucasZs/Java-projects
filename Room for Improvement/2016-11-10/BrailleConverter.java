import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

 //https://py.checkio.org/mission/braille-translator/

public class BrailleConverter
{
	private static final int MAX_LINE_LENGTH = 29;
	private static final Integer[][][] BRAILLE_ARRAY = new Integer[][][] {
	{ { 1, 0 }, { 0, 0 }, { 0, 0 } }, // 'a'
	{ { 1, 0 }, { 1, 0 }, { 0, 0 } }, // 'b'
	{ { 1, 1 }, { 0, 0 }, { 0, 0 } }, // 'c'
	{ { 1, 1 }, { 0, 1 }, { 0, 0 } }, // 'd'
	{ { 1, 0 }, { 0, 1 }, { 0, 0 } }, // 'e'
	{ { 1, 1 }, { 1, 0 }, { 0, 0 } }, // 'f'
	{ { 1, 1 }, { 1, 1 }, { 0, 0 } }, // 'g'
	{ { 1, 0 }, { 1, 1 }, { 0, 0 } }, // 'h'
	{ { 0, 1 }, { 1, 0 }, { 0, 0 } }, // 'i'
	{ { 0, 1 }, { 1, 1 }, { 0, 0 } }, // 'j'
	{ { 1, 0 }, { 0, 0 }, { 1, 0 } }, // 'k'
	{ { 1, 0 }, { 1, 0 }, { 1, 0 } }, // 'l'
	{ { 1, 1 }, { 0, 0 }, { 1, 0 } }, // 'm'
	{ { 1, 1 }, { 0, 1 }, { 1, 0 } }, // 'n'
	{ { 1, 0 }, { 0, 1 }, { 1, 0 } }, // 'o'
	{ { 1, 1 }, { 1, 0 }, { 1, 0 } }, // 'p'
	{ { 1, 1 }, { 1, 1 }, { 1, 0 } }, // 'q'
	{ { 1, 0 }, { 1, 1 }, { 1, 0 } }, // 'r'
	{ { 0, 1 }, { 1, 0 }, { 1, 0 } }, // 's'
	{ { 0, 1 }, { 1, 1 }, { 1, 0 } }, // 't'
	{ { 1, 0 }, { 0, 0 }, { 1, 1 } }, // 'u'
	{ { 1, 0 }, { 1, 0 }, { 1, 1 } }, // 'v'
	{ { 0, 1 }, { 1, 1 }, { 1, 1 } }, // 'w'
	{ { 1, 1 }, { 0, 0 }, { 1, 1 } }, // 'x'
	{ { 1, 1 }, { 0, 1 }, { 1, 1 } }, // 'y'
	{ { 1, 0 }, { 0, 1 }, { 1, 1 } }, // 'z'
	{ { 0, 0 }, { 1, 0 }, { 0, 0 } }, // ','
	{ { 0, 0 }, { 1, 1 }, { 0, 1 } }, // '.'
	{ { 0, 0 }, { 1, 1 }, { 0, 0 } }, // '-'
	{ { 0, 0 }, { 1, 0 }, { 1, 1 } }, //'?'
	{ { 0, 0 }, { 0, 0 }, { 1, 1 } }, // '_'
	{ { 0, 0 }, { 1, 1 }, { 1, 0 } }, // '!'
	{ { 0, 0 }, { 0, 0 }, { 0, 1 } }, // capital
	{ { 0, 1 }, { 0, 1 }, { 1, 1 } } // number
	};
	private static final String chars = "abcdefghijklmnopqrstuvwxyz,.-?_!CN";
	public static final Map<Character, Integer[][]>	BRAILLE_MAP	= new HashMap<Character, Integer[][]>();
	public Integer[][] brailleArray;

	static
	{
		for (int i = 0; i < BRAILLE_ARRAY.length; i++) {
			BRAILLE_MAP.put(chars.charAt(i), BRAILLE_ARRAY[i]);
		}
	}

	public void tanslate(String input)
	{
		brailleArray = new Integer[calculateRowNumber(input)][MAX_LINE_LENGTH];

		for (int i = 0; i < brailleArray.length; i++)
		{
			for (int j = 0; j < brailleArray[i].length; j++)
			{
				brailleArray[i][j] = 0;
			}
		}

		int insertionIndexI = 0;
		int insertionIndexJ = 0;

		for (int i = 0; i < input.length(); i++)
		{
			char actualChar = input.charAt(i);
			String actualStringLowerCase = Character.toString((Character.toLowerCase(input.charAt(i))));

			if (BRAILLE_MAP.containsKey(actualChar) || BRAILLE_MAP.containsKey(actualStringLowerCase)
			        || Character.isDigit(actualChar))
			{
				if (insertionIndexJ < MAX_LINE_LENGTH)
				{
					if (Character.isUpperCase(actualChar) && insertionIndexJ + 4 < MAX_LINE_LENGTH)
					{
						insertSymbolToArray(BRAILLE_MAP.get('C'), insertionIndexI, insertionIndexJ);
						insertionIndexJ += 3;
						insertSymbolToArray(BRAILLE_MAP.get(actualStringLowerCase), insertionIndexI, insertionIndexJ);
						insertionIndexJ += 3;
					}
					else if (Character.isDigit(actualChar) && insertionIndexJ + 4 < MAX_LINE_LENGTH)
					{
						insertSymbolToArray(BRAILLE_MAP.get('N'), insertionIndexI, insertionIndexJ);
						insertionIndexJ += 3;
						insertSymbolToArray(BRAILLE_MAP.get(digitCharToString(actualChar)), insertionIndexI,
						        insertionIndexJ);
						insertionIndexJ += 3;
					}
					else if (insertionIndexJ + 1 < MAX_LINE_LENGTH)
					{
						insertSymbolToArray(BRAILLE_MAP.get(actualChar), insertionIndexI, insertionIndexJ);
						insertionIndexJ += 3;
					}
				}
				else
				{
					insertionIndexI += 4;
					insertionIndexJ = 0;
					i--;
				}
			}
			else
			{
				if (insertionIndexJ < MAX_LINE_LENGTH && insertionIndexJ + 1 < MAX_LINE_LENGTH)
				{
					insertionIndexJ += 3;
				}
				else
				{
					insertionIndexI += 4;
					insertionIndexJ = 0;
					i--;
				}
			}
		}
	}

	public char digitCharToString(char actualChar)
	{
		return actualChar == '0' ? 'j' : (char) (actualChar + 48);
	}

	public void insertSymbolToArray(Integer[][] arrayToInsert, int insertionIndexI, int insertionIndexJ)
	{
		int indexJ = insertionIndexJ;
		for (int i = 0; i < arrayToInsert.length; i++)
		{
			for (int j = 0; j < arrayToInsert[i].length; j++)
			{
				brailleArray[insertionIndexI][insertionIndexJ] = arrayToInsert[i][j];
				insertionIndexJ++;
			}
			insertionIndexI++;
			insertionIndexJ = indexJ;
		}
	}

	public int calculateRowNumber(String input)
	{
		int letterHeightPlusLineSpace = 4;
		int rowCounter = 3;
		int columnCounter = 0;

		for (int i = 0; i < input.length(); i++)
		{
			char actualChar = input.charAt(i);
			if (columnCounter == 0)
			{
				columnCounter += 2;
				if (Character.isTitleCase(actualChar) || Character.isDigit(actualChar))
				{
					columnCounter += 3;
				}
			}
			else if (columnCounter > 0)
			{
				if ((Character.isTitleCase(actualChar) || Character.isDigit(actualChar))
				        && columnCounter + 6 <= MAX_LINE_LENGTH - 1)
				{
					columnCounter += 6;
				}
				else if (!Character.isTitleCase(actualChar) && !Character.isDigit(actualChar)
				        && columnCounter + 3 <= MAX_LINE_LENGTH - 1)
				{
					columnCounter += 3;
				}
				else
				{
					columnCounter = 0;
					rowCounter += letterHeightPlusLineSpace;
				}
			}
		}
		return rowCounter;
	}

	public static void main(String[] args)
	{
		BrailleConverter brailleConverter = new BrailleConverter();
		brailleConverter.tanslate("hello 1st World!");

		for (Integer[] row : brailleConverter.brailleArray)
		{
			System.out.println(Arrays.toString(row));
		}
	}
}
public class ArrayHandler {
	
/*
Usage of the followings are FORBIDDEN:
- internet
- IDE
- classes outside of java.lang package
- boxing classes like java.lang.Integer, etc.
Write a method which can insert (NOT update) an int value into an array of integers (int[]) at a given index
and returns with the new array. Throw an ArrayIndexOutOfBoundsException where it is necessary !
Write a method which can delete an element from an array of integers (int[]) at a given index and returns with the
new array. Throw an ArrayIndexOutOfBoundsException where it is necessary !
*/	
	public static int[] insertIntoArray(int intToInsert, int index, int[] array)
	{
		if(index>array.length || index<0)
		{
			new ArrayIndexOutOfBoundsException();
		}
		
		boolean inserted = false;
		int[]result = new int[array.length+1];
		
		for (int i = 0; i < array.length; i++) {
			if(i == index && !inserted)
			{
				result[i] = intToInsert;
				inserted = true;
				i--;
			}
			else if(inserted)
			{
				result[i+1] = array[i];
			}
			else
			{
				result[i] = array[i];
			}
		}
		
		return result;
	}

	public static int[] deleteFromArray(int index, int numberToDelete, int[] array)
	{
		if(index>array.length || index<0)
		{
			new ArrayIndexOutOfBoundsException();
		}
		
		boolean skipped = false;
		int[]result = new int[array.length-1];
		
		for (int i = 0; i < result.length; i++) {
			if(index == i && numberToDelete == array[i])
			{
				i++;
				result[i-1] = array[i];
				skipped = true;
			}
			else if(skipped)
			{
				result[i-1] = array[i];
			}
			else
			{
				result[i] = array[i];
			}
			
		}
		if(skipped)
		{
			result[result.length-1] = array[array.length-1];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] intArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		/*intArray = insertIntoArray(4, 4, intArray);
		for (int i : intArray) {
			System.out.println(i);
		}*/
		intArray = deleteFromArray(1, 1, intArray);
		for (int i : intArray) {
			System.out.println(i);
		}
	}

}

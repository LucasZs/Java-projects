public class Arrayhandler
{
	
	public static char[] fillArray(char[] input)
	{
		for (int i = 0; i < input.length; i++)
		{
			input[i] = 'a';
		}
		return input;

	}
	
	public static char[] modifyArrayContent(char[] input)
	{
		for(int i = 0; i < input.length; i++)
		{
			if(i % 2 != 0)
			{
				input[i] = 'b';
			}
		}
		return input;
	}
	
	public static void showArray(char[] input)
	{
		for(int i = 0; i < input.length; i++)
		{
			System.out.print(input[i] + " ");
		}
	}
	
	public static void main(String[] args)
	{
		char[] array = new char[20];
		fillArray(array);
		modifyArrayContent(array);
		showArray(array);
	}
}
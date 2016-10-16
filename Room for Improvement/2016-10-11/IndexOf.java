String input = "blabla blabla blabla"

public class IndexOf
{
	public int findIndexOf(char c)
	{
		return findIndexOf(c, 0);
	}
	
	public int findIndexOf(char c, int fromCharIndex)
	{
		for(int charIndex = fromCharIndex; charIndex < input.length(); charIndex++)
			if(charindex == input.charAt(charIndex))
			{
				return charIndex;
			}
			else
			{
				return -1;
			}
	}
}
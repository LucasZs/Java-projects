import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Description:

Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1
which are substrings of strings of a2.
Example 1:
a1 = ["arp", "live", "strong"]
a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
returns ["arp", "live", "strong"]
Example 2:
a1 = ["tarp", "mice", "bull"]
a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
returns []
Notes:
Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
Beware: r must be without duplicates.
https://www.codewars.com/kata/which-are-in
*/

public class SubstringOrderer
{
	public String[] matchArrays(String[] a1, String[] a2)
	{
		String[] result = null;
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < a2.length; i++)
		{
			for (int j = 0; j < a1.length; j++)
			{
				if (a2[i].contains(a1[j]))
				{
					stringBuilder.append(a1[j] + ",");
				}
			}
		}

		result = stringBuilder.toString().split(",");
		result = removeDuplicates(result);
		result = sortAlphabethically(result);

		return result;
	}

	public String[] sortAlphabethically(String[] array)
	{
		String[] result = null;
		List<String> stringList = Arrays.asList(array);
		Collections.sort(stringList);
		result = (String[]) stringList.toArray();
		return result;
	}

	public String[] removeDuplicates(String[] array)
	{
		String[] result = null;
		Set<String> hashSet = new HashSet<String>();
		
		for (String string : array)
		{
			hashSet.add(string);
		}
		
		result = hashSet.toArray(new String[hashSet.size()]);
		return result;
	}

	public void displayMatchArrays(String[] a1, String[] a2)
	{
		String[] matchedArray = matchArrays(a1, a2);
		System.out.println(Arrays.toString(matchedArray));
	}
}
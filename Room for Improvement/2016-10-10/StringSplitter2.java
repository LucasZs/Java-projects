import java.util.ArrayList;

public class StringSplitter2
{
	public static String[] splitTheString(String input, int maxLineLength)
	{
		ArrayList<String> resultAsList = new ArrayList<>();
		String[] splitted = input.split(" ");
		StringBuilder line = new StringBuilder();
		int charCount = 0;
		for (String string : splitted) {
			if(charCount + string.length() <= maxLineLength){
				line.append(string);
				if(line.length() < maxLineLength){
					line.append(" ");
					charCount++;
				}
				charCount += string.length();
			}
			else {
				resultAsList.add(line.toString());
				line = new StringBuilder();
				line.append(string);
				charCount = string.length();
				if(line.length() < maxLineLength){
					line.append(" ");
					charCount++;
				}
			}
		}
		
		String[] result = new String[resultAsList.size()];
		result = resultAsList.toArray(result);
		return result;
	}
	
	public static void main(String[] args) {
		String input = "Jyn Erso, a Rebellion soldier and criminal, is about to experience her biggest challenge yet when Mon Mothma sets her out on a mission to steal the plans for the Death Star.";
		String[] wrapped = splitTheString(input, 20);
		for (String line: wrapped){
			System.out.println(line);
		}
	}
}
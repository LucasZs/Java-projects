import java.util.ArrayList;

public class StringSplitter {
	public static String[] splitTheString(String input, int lengthOfLine){
		ArrayList<String> resultAsList = new ArrayList<>();
		int processed = 0;
		int breakpoint = 0;
		while(processed < input.length()){
			while(breakpoint < input.length()){
				int i = input.indexOf(" ", breakpoint + 1);
				if(i < 0) {
					i = input.length();
				}
				if(i - processed < lengthOfLine){
					breakpoint = i;
				}
				else{
					break;
				}
			}
			resultAsList.add(input.substring(processed, breakpoint));
			processed = breakpoint + 1;
		}
		return resultAsList.toArray(new String[resultAsList.size()]);
	}
	
	public static void main(String[] args) {
		String a = "If MoveNext passes the end of the collection, the enumerator is positioned after the last element in the collection and MoveNext returns false. When the enumerator is at this position, subsequent calls to MoveNext also return false. If the last call to MoveNext returned false, calling Current throws an exception.";
		for (String line: splitTheString(a, 20)){
			System.out.println(line);
		}
		
	}
}

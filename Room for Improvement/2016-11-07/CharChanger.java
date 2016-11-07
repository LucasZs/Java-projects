public class CharChanger {
	public static final char[] const1 = {'a', 'b', 'c'};
	public static final char[] const2 = {'d', 'e', 'f'};
	
	public static String changeChars(String input){
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char actual = input.charAt(i);
			for (int j = 0; j < const1.length; j++) {
				if(actual==const1[j]){
					actual = const2[j];
				}
			}
			result.append(actual);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String input = "aba samuel";
		System.out.println(CharChanger.changeChars(input));
	}
}
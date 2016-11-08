public class BracketValidator {
	public static boolean validate(String input){
		int opened = 0;
		for (int i = 0; i < input.length(); i++) {
			/*if(input.charAt(i)=='('){
				opened++;
			}
			else{
				opened--;
				if(opened<0){
					return false;
				}
			}*/
			opened += input.charAt(i) == '(' ? 1 : -1;
		}
		return opened == 0;
	}
	public static void main(String[] args) {
		String test = "()()(()";
		String test2 = "()(()())";
		String test3 = ")))))((((("	;	
		System.out.println(validate(test));
		System.out.println(validate(test2));
		System.out.println(validate(test3));
	}

}
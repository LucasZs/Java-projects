import java.util.Random;

public class TextRandomizer {
	
	public static String shuffle(String input){
		String[] words = input.split(" ");
		StringBuilder result = new StringBuilder();
		for (String word : words) {
			if(word.length() > 3){
				char firstChar = word.charAt(0);
				char lastChar = word.charAt(word.length()-1);
				word = shuffleWord(word.substring(1, word.length()-1));
				word = firstChar + word + lastChar;
			}
			result.append(word);
			result.append(" ");
		}
		return result.toString();
	}

	public static String shuffleWord(String word){
		Random rand = new Random();
		String result = word;
		for (int i = 0; i < result.length(); i++) {
			result = swapChars(result, i, rand.nextInt(result.length()));
		}
		return result;
	}
	
	public static String swapChars(String word, int i, int j)
	{
		if(i==j){
			return word;
		}
		char[] chars = word.toCharArray();
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
		String result = new String(chars);
		return result;
	}
	
	public static void main(String[] args) {
		String text = "A belv�ros sz�v�ben kellemes k�rnyezetben, l�gkondicion�lt �tterm�nkbe v�rjuk az �tkezni �s sz�rakozni v�gy� kedves vend�geinket:";
		System.out.println(shuffle(text));
	}
}
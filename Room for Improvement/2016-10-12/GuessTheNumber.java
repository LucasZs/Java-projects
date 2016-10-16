import java.util.Scanner;

public class GuessTheNumber {
	static final int randIntBetween0and100 = (int) (Math.random() * 100);
	static int enteredNumber = 0;
	
		public static void startTheGame()
		{
			System.out.println("I have an integer between 0 and 100. Guess it, so enter an integer in this interval!");
			storeTheEnteredNumber();
		}
	
		public static int storeTheEnteredNumber(){
			Scanner s = new Scanner(System.in);
			try{
				enteredNumber = s.nextInt();
				numberChecker(randIntBetween0and100, enteredNumber);
				s.close();
			}
			catch (Exception e){
				e.printStackTrace();
			}
			return enteredNumber;
		}
		
	public static void numberChecker(int randIntBetween0and100, int tryIfNumber)
	{
		if(randIntBetween0and100 < tryIfNumber){
			System.out.println("The number you entered is higher! Enter a lower number!");
			storeTheEnteredNumber();
		}
		else if(randIntBetween0and100 > tryIfNumber){
			System.out.println("The number you entered is lower! Enter a higher number!");
			storeTheEnteredNumber();
		}
		else{
			System.out.println("Congratulations! You guessed the number!");
		}
	}
	
	public static void main(String[] args) {
		startTheGame();		
	}
}

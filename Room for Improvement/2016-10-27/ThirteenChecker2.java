public class ThirteenChecker2 
{
	public static boolean checkIfContainsThirteen(int number){
		String numberAsString = String.valueOf(number);
		return numberAsString.indexOf('1') > -1 && numberAsString.indexOf('3', numberAsString.indexOf('1')) > numberAsString.indexOf('1');
	}
	
	public static void main(String[] args) {
		System.out.println(checkIfContainsThirteen(300044413));

	}
}
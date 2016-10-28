class ThirteenChecker
{
	public static boolean CheckIfContainsThirteen(int number){
		String numberAsString = String.valueOf(number);
		char[] numberAsCharArray = numberAsString.toCharArray();
		boolean result = false;
		for(int i = 0; i < numberAsCharArray.length; i++){
			for(int j = 1; j < numberAsCharArray.length; j++){
				if(numberAsCharArray[i] == '1' && numberAsCharArray[j] == '3' && i < j){
					result = true;
					break;
				}
			}
		}
		return result;
	}
}
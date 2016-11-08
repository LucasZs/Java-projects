public class HundredDoors {
	static int numberOfDoors = 100;
	static int numberOfSlaves = 100;
	static boolean[] closedDoors = new boolean[numberOfDoors];
	static int openedDoorsCount = 0;

	public static void fillArray() {
		for (int i = 0; i < numberOfDoors; i++) {
			closedDoors[i] = true;	//All doors are closed in the beginning.
		}
	}

	public static void changeDoorsState() {
		//The first slave changes the state of every door,
		// the second slave changes the state of every second door etc.
		for (int i = 1; i <= numberOfSlaves; i++) {
			for (int j = 1; j <= numberOfDoors; j++) {
				if (j % i == 0) {
					closedDoors[j - 1] = !closedDoors[j - 1];
				}
			}
		}
		for (int i = 0 ; i < closedDoors.length; i++) {
			int doorNumber = i + 1;  //The first door usually is called 'room 1' instead of 'room zero'.
			if(closedDoors[i]==false){
				System.out.println("Door " + doorNumber + " is opened");
				openedDoorsCount++;
				System.out.println("The number of opened doors is " + openedDoorsCount);
			}
			else{
				System.out.println("Door " + doorNumber + " is closed.");

			}
		}
	}

	public static void main(String[] args) {
		HundredDoors.fillArray();
		HundredDoors.changeDoorsState();
	}
}
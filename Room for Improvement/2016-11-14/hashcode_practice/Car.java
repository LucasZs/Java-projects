package hashcode_practice;

public class Car implements Comparable<Car>{
    private String registrationNumber;
    private int kmRunned = 0;

    Car(String registrationNumber, int kmRunned) {
          this.registrationNumber = registrationNumber;
          this.kmRunned = kmRunned;
    }

    public String toString() {
          return "Registration number: " + registrationNumber + ", Runned km: " + kmRunned;
    }

    public boolean equals(Object obj) { //Two cars are "contently" equal, if their registration number equals.
          return (obj instanceof Car) && ((Car) obj).registrationNumber.equals(registrationNumber);
    }

    public int hashCode() {
          //return 15; //This is one of the weakest solvings. But it works.
          //return registrationNumber.length(); // This is better.
          return registrationNumber.hashCode(); // In this case there is the simplest and best solving.
    }
   
    public int compareTo(Car anotherCar) {                    
          return this.registrationNumber.compareTo(((Car) anotherCar).registrationNumber);
    }
}
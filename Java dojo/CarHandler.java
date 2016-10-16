package test_new;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class CarHandler {

	public static void main(String[] args) {
		Color c = new Color(128, 128, 128);
		Car ford = new Car("Ford", 180, c, 1300, 8.5, 2001);
		Car opel = new Car("Opel", 150, Color.blue, 1400, 9.2, 2006);
		Car skoda = new Car("Skoda", 170, Color.green, 1500, 5.5, 2009);
		/*System.out.println(ford);
		System.out.println(opel);
		System.out.println(skoda);*/
		
		List<Car> cars = new ArrayList<>();
		cars.add(ford);
		cars.add(opel);
		cars.add(skoda);
		
		cars.sort(new MaxSpeedComparator());
		//cars.sort(new MaxSpeedComparator(false));
		
		for (Car car: cars) {
			System.out.println(car);
		}
		cars.sort(new CarComparator());
		
		for (Car car: cars) {
			System.out.println(car);
		}
	}
}

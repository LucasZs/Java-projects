package coinsV2developed;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Circle circle = new Circle(5);
		Circle circle2 = new Circle(10);
		Rectangle rect = new Rectangle(20, 4);
		Triangle triangle = new Triangle(12, 10, 16);
		Triangle triangle2 = new Triangle(1, 1, 1);
		CoinCalculator cc = new CoinCalculator();

		Set<Shape> shapes = new HashSet<>();
		shapes.add(triangle);
		shapes.add(triangle2);
		shapes.add(rect);
		shapes.add(circle2);
		shapes.add(circle);
		shapes.add(triangle);
		
		Set<Shape> testSet = new HashSet<>();
		testSet.add(triangle);
		testSet.add(triangle2);
		testSet.add(rect);
		testSet.add(circle2);
		testSet.add(circle);

		for (Shape shape : testSet) {
			System.out.println(shape);
		}

		System.out.println("-----------------------------");
		double testAmount = cc.calculate(testSet);

		Shape[] shapearr = cc.getCoins(testAmount, shapes);
		for (Shape shape : shapearr) {
			System.out.println(shape);
		}
	}
}
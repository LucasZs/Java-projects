package coinsV2developed;

import static java.lang.Math.PI;

public class Circle extends Shape {
	private double radius;
	private final static double VALUE = 2;

	public Circle(double radius) {
		this.value = VALUE;
		this.radius = radius;
	}

	public double area() {
		double area = PI * Math.pow(radius, 2);
	    return Math.floor(1000 * area) / 1000;
	}

	public double perimeter() {
		 double perimeter = 2 * PI * radius;
		 return Math.floor(1000 * perimeter) / 1000;
	 }

	@Override
	public String toString() {
		return "Circle [ area()=" + area() + "REAL VALUE= " + calculateRealValue() + "]";
	}

}
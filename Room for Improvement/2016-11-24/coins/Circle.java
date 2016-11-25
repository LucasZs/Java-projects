package coins;

public class Circle implements Shape {
	private final int value = 2;
	private double radius;
	final double pi = Math.PI;
	 
	public Circle(double radius) {
		this.radius = radius;
	}
	
	 public double area() {
	    double area = pi * Math.pow(radius, 2);
	    return Math.floor(1000 * area) / 1000;
	 }
	 
	 public double perimeter() {
		 double perimeter = 2 * pi * radius;
		 return Math.floor(1000 * perimeter) / 1000;
	 }
	
	 public double getRealValue() {
		double realValue = value * area() - perimeter();
		return Math.floor(1000 * realValue) / 1000;
	 }
	 
	 @Override
		public String toString() {
			return "CircleCoin [area: " + area() + ", perimeter: " + perimeter() + ", real value: " + getRealValue() + " ]";
		}
}
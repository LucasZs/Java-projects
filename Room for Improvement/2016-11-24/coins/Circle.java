package coins;

public class Circle implements Shape {
	private final int value = 2;
	private double radius;
	final double pi = Math.PI;
	 
	public Circle(double radius) {
		this.radius = radius;
	}
	
	 public double area() {
	        return pi * Math.pow(radius, 2);
	 }
	 
	 public double perimeter() {
		 return 2 * pi * radius;
	 }
	
	 public double getRealValue() {
		 return value * area() - perimeter();
	 }
	 
	 @Override
		public String toString() {
			return "CircleCoin [area: " + area() + ", perimeter: " + perimeter() + ", real value: " + getRealValue() + " ]";
		}
}

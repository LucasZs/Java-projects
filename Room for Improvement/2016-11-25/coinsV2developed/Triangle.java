package coinsV2developed;

public class Triangle extends Shape {

	private final double VALUE = 1;
	private double sideA;
	private double sideB;
	private double sideC;

	public Triangle(double sideA, double sideB, double sideC) {
		this.value = VALUE;
		if (!isValid(sideA, sideB, sideC)) {
			throw new IllegalArgumentException("This scale of the sides is not allowed in case of a triangle!");
		}

		else {
			this.sideA = sideA;
			this.sideB = sideB;
			this.sideC = sideC;		}
	}

	protected boolean isValid(double a, double b, double c) {
		return ((a + b > c) && (a + c > b) && (b + a > c));
	}

	public double area() {
		double halfOfPerimeter = (sideA + sideB + sideC) / 2;
		double area = Math.sqrt(halfOfPerimeter * (halfOfPerimeter - sideA) * (halfOfPerimeter - sideB) * (halfOfPerimeter - sideC));
		return Math.floor(1000 * area) / 1000;
	 }
	 
	 public double perimeter() {
			 double perimeter = sideA + sideB + sideC;
			 return Math.floor(1000 * perimeter) / 1000;
	 }
	@Override
	public String toString() {
		return "Triangle [ area()=" + area() + "REAL VALUE= " + calculateRealValue() + "]";
	}
}
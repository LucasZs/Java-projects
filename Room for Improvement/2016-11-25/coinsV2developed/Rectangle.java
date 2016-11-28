package coinsV2developed;

public class Rectangle extends Shape {

	private double sideA;
	private double sideB;
	public static final double VALUE = 5;

	public double getValue() {
		return VALUE;
	}

	public Rectangle(double sideA, double sideB) {
		this.value = VALUE;
		this.sideA = sideA;
		this.sideB = sideB;
	}

	public double area() {
        double area = sideA * sideB;
        return Math.floor(1000 * area) / 1000;
    }

	public double perimeter() {
        double perimeter =  2 * (sideA + sideB);
        return Math.floor(1000 * perimeter) / 1000;
    }

	@Override
	public String toString() {
		return "Rectangle [ area()=" + area()  + "REAL VALUE= "
				+ calculateRealValue() + "]";
	}

}
package coinsV2developed;

public abstract class Shape {
	
	double value;
	
	public abstract double area();
	public abstract double perimeter();
	public double calculateRealValue() {
		return value * area() - perimeter();
	}

}
package coins;

public class Rectangle implements Shape{
	private final int value = 5;
	private double sideA, sideB;
	
	public Rectangle(double sideA, double sideB) {
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
    
	 public double getRealValue() {
		 double realValue = value * area() - perimeter();
		 return Math.floor(1000 * realValue) / 1000;
	 }
	 
	 @Override
		public String toString() {
			return "RectangleCoin [area: " + area() + ", perimeter: " + perimeter() + ", real value: " + getRealValue() + " ]";
		}
}
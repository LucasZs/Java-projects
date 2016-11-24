package coins;

public class Rectangle implements Shape{
	private final int value = 5;
	private double sideA, sideB;
	
	public Rectangle(double sideA, double sideB) {
		this.sideA = sideA;
		this.sideB = sideB;
	}
	
    public double area() {
        return sideA * sideB;
    }

    public double perimeter() {
        return 2 * (sideA + sideB);
    }
    
	 public double getRealValue() {
		 return value * area() - perimeter();
	 }
	 
	 @Override
		public String toString() {
			return "RectangleCoin [area: " + area() + ", perimeter: " + perimeter() + ", real value: " + getRealValue() + " ]";
		}
}

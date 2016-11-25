package coins;

public class Triangle implements Shape{
	private final int value = 1;
	private double sideA, sideB, sideC;

	public boolean isValidTriangle(double sideA, double sideB, double sideC){
		return (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA);
	}
	
	public Triangle(double sideA, double sideB, double sideC) {
		if(isValidTriangle(sideA, sideB, sideC)){
			this.sideA = sideA;
			this.sideB = sideB;
			this.sideC = sideC;
		}
		else{
			 throw new IllegalArgumentException("This scale of the sides is not allowed in case of a triangle!");
		 }
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
	
	 public double getRealValue() {
		 double realValue = value * area() - perimeter();
		if(Math.floor(1000 * realValue) / 1000 <=0){
			return 0;
		}
		else{
			return Math.floor(1000 * realValue) / 1000;
		}
	 }
	 
	 @Override
		public String toString() {
			return "TriangleCoin [area: " + area() + ", perimeter: " + perimeter() + ", real value: " + getRealValue() + " ]";
		}
}
package coins;

public class Triangle implements Shape{
	private final int value = 1;
	private double sideA, sideB, sideC;
	
	public Triangle(double sideA, double sideB, double sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}
	
	public boolean isValidTriangle(){
		return (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA);
	}
	
	 public double area() {
		 if(isValidTriangle()){
			 double halfOfPerimeter = (sideA + sideB + sideC) / 2;
			 return Math.sqrt(halfOfPerimeter * (halfOfPerimeter - sideA) * (halfOfPerimeter - sideB) * (halfOfPerimeter - sideC));
		 }
		 else{
			 throw new IllegalArgumentException("This scale of the sides is not allowed in case of a triangle!");
		 }
	 }
	 
	 public double perimeter() {
		 if(isValidTriangle()){
			 return sideA + sideB + sideC;
		 }
		 else{
			 throw new IllegalArgumentException("This scale of the sides is not allowed in case of a triangle!");
		 }
	 }
	
	 public double getRealValue() {
		 if(isValidTriangle()){
			 if(value * area() - perimeter()<=0){
				 return 0;
			 }
			 else{
				 return value * area() - perimeter();
			 }
		 }
		 else{
			 throw new IllegalArgumentException("This scale of the sides is not allowed in case of a triangle!");
		 }
	 }
	 
	 @Override
		public String toString() {
			return "TriangleCoin [area: " + area() + ", perimeter: " + perimeter() + ", real value: " + getRealValue() + " ]";
		}
}

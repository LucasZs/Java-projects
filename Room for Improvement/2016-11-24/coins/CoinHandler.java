package coins;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class CoinHandler {
	
	public static int valueCalculator(ArrayList<? extends Shape> myMoney){
		int sumValue = 0;
		for (int i = 0; i < myMoney.size(); i++) {
			sumValue += myMoney.get(i).getRealValue();
		}
		return sumValue;
	}
	
	public static ArrayList<HashSet<? extends Shape>> setDifferentTypes(HashSet<? extends Shape> input){
		ArrayList<HashSet<? extends Shape>> result = new ArrayList<>();
		HashSet<Circle> circles = new HashSet<>();
		HashSet<Triangle> triangles = new HashSet<>();
		HashSet<Rectangle> rectangles = new HashSet<>();
		result.add(circles);
		result.add(triangles);
		result.add(rectangles);
		for (Shape s : input) {
			if(s instanceof Circle){
				circles.add((Circle)s);
			}
			else if(s instanceof Triangle){
				triangles.add((Triangle)s);
			}
			else if(s instanceof Rectangle){
				rectangles.add((Rectangle)s);
			}
			else{
				throw new IllegalArgumentException("Unsupported input type!");
			}
		}
		return result;
	}
	
	public static SortedSet<Shape> sortCoinsByArea (HashSet<Shape> input){
		SortedSet<Shape> sortedByArea = new TreeSet<>(Comparator.comparing(Shape::area));
		sortedByArea.addAll(input);
		return sortedByArea;
	}

	public static SortedSet<Shape> sortCoinsByPerimeter (HashSet<Shape> input){
		SortedSet<Shape> sortedByPerimeter = new TreeSet<>(Comparator.comparing(Shape::perimeter));
		sortedByPerimeter.addAll(input);
		return sortedByPerimeter;
	}
	
	public static void main(String[] args) {
		Circle circle1 = new Circle(3);
		System.out.println(circle1.area());
		System.out.println(circle1.perimeter());
		System.out.println(circle1.getRealValue());
		
		Circle circle2 = new Circle(10.5);
		System.out.println(circle2.area());
		System.out.println(circle2.perimeter());
		System.out.println(circle2.getRealValue());
		
		Triangle triangle1 = new Triangle(2, 3, 4);
		System.out.println(triangle1.area());
		System.out.println(triangle1.perimeter());
		System.out.println(triangle1.getRealValue());
		
		Triangle triangle2 = new Triangle(15.3, 20.4, 25.5);
		System.out.println(triangle2.area());
		System.out.println(triangle2.perimeter());
		System.out.println(triangle2.getRealValue());
		
		Rectangle rectangle1 = new Rectangle(10, 20);
		System.out.println(rectangle1.area());
		System.out.println(rectangle1.perimeter());
		System.out.println(rectangle1.getRealValue());
		
		Rectangle rectangle2 = new Rectangle(15.8, 4.2);
		System.out.println(rectangle2.area());
		System.out.println(rectangle2.perimeter());
		System.out.println(rectangle2.getRealValue());
		
		List<Shape> myMoneyList = new ArrayList<>();
		myMoneyList.add(rectangle1);
		myMoneyList.add(triangle1);
		myMoneyList.add(triangle2);
		myMoneyList.add(circle1);
		System.out.println(valueCalculator((ArrayList<? extends Shape>) myMoneyList));
		
		Set<Shape> hashSet = new HashSet<>();
		hashSet.add(circle1);
		hashSet.add(circle2);
		hashSet.add(triangle1);
		hashSet.add(triangle2);
		hashSet.add(rectangle1);
		hashSet.add(rectangle2);
		System.out.println(sortCoinsByArea((HashSet<Shape>) hashSet).toString());
		System.out.println(sortCoinsByPerimeter((HashSet<Shape>) hashSet).toString());
		
		Triangle invalidTriangle = new Triangle(1, 1, 2); //stop running with IllegalArgumentException
		hashSet.add(invalidTriangle);
		System.out.println(hashSet.size());
	}
}
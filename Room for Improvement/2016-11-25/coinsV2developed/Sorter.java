package coinsV2developed;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Sorter {

	public Set<Shape> sortByPerimeter(Set<Shape> set) {
		SortedSet<Shape> sorted = new TreeSet<>(new Comparator<Shape>() {

			@Override
			public int compare(Shape o1, Shape o2) {
				return (int) (o1.perimeter() -  o2.perimeter());
			}
		});
		sorted.addAll(set);

		return sorted;
	}

	public Set<Shape> sortByArea(Set<Shape> set) {
		SortedSet<Shape> result = new TreeSet<>(new Comparator<Shape>() {

			@Override
			public int compare(Shape o1, Shape o2) {
				return (int) (o1.area() -  o2.area());
			}
		});
		result.addAll(set);

		return result;
	}

}
import java.util.Arrays;
import java.util.List;

public class GenericBubbleSort {

	public static <T extends Comparable<T>> T[] sort(T[] list){
		boolean wasSwap = true;
		while(wasSwap){
			wasSwap = false;
			for (int i = 0; i < list.length-1; i++) {
				if(list[i].compareTo(list[i+1]) > 0)
				{
					T temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
					wasSwap = true;
				}
			}
		}
		return list;
	}
	
	public static <T extends Comparable<T>> List<T> sort(List<T> list){
		boolean wasSwap = true;
		while(wasSwap){
			wasSwap = false;
			for (int i = 0; i < list.size()-1; i++) {
				if(list.get(i).compareTo(list.get(i+1)) > 0)
				{
					T temp = list.get(i);
					list.set(i, list.get(i+1));
					list.set(i+1, temp);
					wasSwap = true;
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		Integer[] numbers = {3, 1, 4, 8, 6, 5};
		Integer[] sorted = sort(numbers);
		System.out.println(Arrays.toString(sorted));
	}
}
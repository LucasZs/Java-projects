package repeating_variation_generic_version_and_reflection;

import java.util.Arrays;
import java.util.Iterator;

public class RepeatingVariations<T> implements Iterator<T[]> {
    private T[] elements;
    private int[] actualIndexArray;
    private T[] results;
    public RepeatingVariations(T[] elements, int n) {
        this.elements = elements;
        actualIndexArray = new int[n];
    }
    @Override
    public boolean hasNext() {
        for (int i : actualIndexArray) {
            if (elements[i] != elements[elements.length - 1]) {
                return true;
            }
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    @Override
    public T[] next() {
        if (results != null) {
            for (int i = actualIndexArray.length - 1; i >= 0; i--) {
                actualIndexArray[i]++;
                if (actualIndexArray[i] != elements.length) {
                    break;
                }
                actualIndexArray[i] = 0;
            }
        } else {
            results = (T[]) new Object[actualIndexArray.length];
        }
        for (int i = 0; i < actualIndexArray.length; i++) {
            results[i] = elements[actualIndexArray[i]];
        }
        return results;
    }
    public static void main(String[] args) {
        //String[] testString = { "one", "two" };
        Integer[] testInteger = { 0, 1 };
        //Character[] testCharacter = {'a', 'b' };
        
        RepeatingVariations<Integer> rv = new RepeatingVariations<>(testInteger, 10);
        for (Iterator<Integer[]> iterator = rv; iterator.hasNext();) {
            
            Object[] actualVariation = iterator.next();
            
            System.out.println(Arrays.toString(actualVariation));
        }
    }
}
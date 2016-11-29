package repeating_variation_generic_version_and_reflection;

import java.lang.reflect.Constructor;
import java.lang.annotation.Annotation;s
import java.util.Arrays;
import java.util.Iterator;

public class Reflection {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("repeating_variation_generic_version_and_reflection.RepeatingVariations");
    
            Constructor[] methods = c.getDeclaredConstructors();
            Integer[] testInteger = { 0, 1 };
            
            for (Constructor method : methods) {
                System.out.print(method.getName() + " ");
                RepeatingVariations<Integer> rv = (RepeatingVariations<Integer>) method.newInstance(testInteger, 10);
                
                for (Iterator<Integer[]> iterator = rv; iterator.hasNext();) {
                    
                    Object[] actualVariation = iterator.next();
                    
                    System.out.println(Arrays.toString(actualVariation));
                }
            }
            
//          Annotation[] a = c.getAnnotations();
//          
//          for (Annotation annotation : a) {
//              System.out.println(annotation);
//          }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
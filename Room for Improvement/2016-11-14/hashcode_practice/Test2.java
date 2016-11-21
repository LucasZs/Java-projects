package hashcode_practice;

import java.util.*;

public class Test2 {
 
      public static void main(String[] args) {
            Car a1 = new Car("FDB435", 21342);
            Car a2 = new Car("UIJ234", 12323);
            Car a3 = a1;
            Car a4 = new Car("FDB435", 45634);
            Car a5 = new Car("AAA435", 2343);
 
            System.out.println("----List----");
            List<Car> list = new ArrayList<>();
            list.add(a1);
            list.add(a2);
            list.add(a3);
            list.add(a4);
            list.add(a5);          
           
            Iterator<Car> i = list.iterator();
            while(i.hasNext()){
                  System.out.println(i.next());
            }
           
           
            System.out.println("\n-----Set-----");                          
            Set<Car> set = new TreeSet<>();
            set.add(a1);
            set.add(a2);
            set.add(a3);
            set.add(a4);
            set.add(a5);           
           
            i = set.iterator();
            while(i.hasNext()){
                  System.out.println(i.next());
            }
           
            System.out.println("\n-----Map-----");
            
            Person pisti = new Person("Pisti");
            Person laci = new Person("Laci");
            Person geza = new Person("Geza");
            
            Map<Person, Car> map = new TreeMap<Person, Car>();
            map.put(pisti, a1);
            map.put(laci, a2);
            map.put(geza, a3);         
           
            for (Map.Entry<Person, Car> entry : map.entrySet()) {
                System.out.println("Person: " + entry.getKey() + ", Car = " + entry.getValue());
            }
      }
 
}
 
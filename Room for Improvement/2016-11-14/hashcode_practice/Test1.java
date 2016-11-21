package hashcode_practice;

public class Test1 {
    public static void main(String[] args) {
          Car a1 = new Car("FDB435", 21342);
          Car a2 = new Car("UIJ234", 12323);
          Car a3 = a1;
          Car a4 = new Car("FDB435", 45634);

          System.out.println("a1 : " + a1);
          System.out.println("a2 : " + a2);
          System.out.println("a3 : " + a3);
          System.out.println("a4 : " + a4);

          System.out.println("a1 == a2 : " + (a1 == a2));
          System.out.println("a1 == a3 : " + (a1 == a3));
          System.out.println("a1 == a4 : " + (a1 == a4));

          System.out.println("a1.equals(a2) : " + (a1.equals(a2)));
          System.out.println("a1.equals(a3) : " + (a1.equals(a3)));
          System.out.println("a1.equals(a4) : " + (a1.equals(a4)));
         
          System.out.println("a1.compareTo(a2) : " + (a1.compareTo(a2)));
          System.out.println("a1.compareTo(a3) : " + (a1.compareTo(a3)));
          System.out.println("a1.compareTo(a4) : " + (a1.compareTo(a4)));
    }
}
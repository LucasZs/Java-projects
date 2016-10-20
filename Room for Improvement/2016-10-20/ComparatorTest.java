import java.util.ArrayList;
import java.util.List;

public class ComparatorTest {

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Pista", 40));
        persons.add(new Person("Joska", 30));

        persons.sort((o1, o2) -> (o1.age - o2.age));
        System.out.println(persons.toString());
        /*
         * persons.sort(new Comparator<Person>() {
         * 
         * @Override public int compare(Person o1, Person o2) { return o1.age -
         * o2.age; } });
         */
    }

}
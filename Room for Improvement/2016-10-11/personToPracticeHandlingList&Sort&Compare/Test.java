package person;

import java.util.ArrayList;
import java.util.List;

public class Test
{
    public static void main(String[] args)
    {
        Person orsi = new Person("Orsolya", 26, 1.7, Gender.FEMALE);
        Person milan = new Person("Milan", 24, 1.87, Gender.MALE);
        Person krisztian = new Person("Krisztian", 23, 1.6, Gender.MALE);
        Person balazs = new Person("Balazs", 28, 1.7, Gender.MALE);
        Person pista = new Person("Pista", 28, 1.4, Gender.MALE);

        List<Person> personList = new ArrayList<>();
        personList.add(orsi);
        personList.add(pista);
        personList.add(milan);
        personList.add(krisztian);
        personList.add(balazs);

        System.out.println(personList.indexOf(balazs));
        System.out.println(personList.indexOf(pista));
//        personList.sort(new HeightComparator());
//        personList.sort(new Comparator<Person>()
//        {
//            @Override
//            public int compare(Person o1, Person o2)
//            {
//                return o1.getAge() - o2.getAge();
//            }
//        });
//        Collections.sort(personList);
        for (Person person : personList)
        {
            System.out.println(person.toString());
        }
    }
}

package person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Splitter {

	public static Person parse(String input) {
		String[] values = input.split(",");
		String name = values[0];
		Integer age = Integer.parseInt(values[1]);
		return new Person(name, age);
	}

	public static ArrayList<Person> createPersonList(String path) {

		ArrayList<Person> personList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			while (br.ready()) {
				personList.add(parse(br.readLine()));
			}
			personList.sort(new Comparator<Person>() {

				@Override
				public int compare(Person o1, Person o2) {
					if (o1.getName().compareTo(o2.getName()) == 0) {
						return o1.getAge().compareTo(o2.getAge());
					} else {
						return o1.getName().compareTo(o2.getName());
					}
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		return personList;
	}

	public static void main(String[] args) {

		System.out.println(createPersonList("src//names.txt").toString());
	}
}
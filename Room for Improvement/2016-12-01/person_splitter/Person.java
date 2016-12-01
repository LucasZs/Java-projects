package person_splitter;

public class Person {
	
	public String name;
	public Integer age;
	
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

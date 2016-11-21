package hashcode_practice;

public class Person implements Comparable<Person>{
	
	private String name;
	
	public Person(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public int compareTo(Person anotherPerson) {                    
        return this.name.compareTo(((Person) anotherPerson).name);
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}



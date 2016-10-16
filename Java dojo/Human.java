package test_new;

public class Human {
	String name;
	int age;
	double height;
	
	public Human(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Age: " + age + "Name: " + name + "Heigth: " + height;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Human) {
			Human objHuman = (Human) obj;
			return objHuman.getName().length() == name.length();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return name.length();
		//return -1;
	}
}

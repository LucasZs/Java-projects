package movies_v3;

import java.io.Serializable;

abstract class Product implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	//variables:
	String id;
	String title;
	Person person;
	
	//methods:
	public String getTitle() {
		return title;
	}
	
	public Person getPerson() {
		return person;
	}
	

	abstract long getInvestment();
	
	//constructor:
	public Product(String title, Person person)
	{
		this.id = IdGenerator.generate(this);
		this.title = title;
		this.person = person;
	}
}


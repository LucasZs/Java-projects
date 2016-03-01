package movies_v2;

class Book extends Product {

	//variables:
	Person author;
	
	//methods:
	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}
	
	//constructor:
	public Book(String title, Person person) {
		super(title, person);
	}
	
	@Override
	public long getInvestment() {
		return author.getSalary();
	}
}

package movies_v3;


import java.util.List;

class Game extends Product implements Buyable {

	//variables:
	boolean preOrdered;
	List<Person> staff;
	int price;
	
	//methods:
	public boolean isPreOrdered() {
		return preOrdered;
	}
	public void setPreOrdered(boolean preOrdered) {
		this.preOrdered = preOrdered;
	}
	public List<Person> getStaff() {
		return staff;
	}
	public void setStaff(List<Person> staff) {
		this.staff = staff;
	}
	public int getPrice() {
		 if (preOrdered) {
			 return price - (price / 5);
			 }
		 else {
			 return price;
		 }
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	long getInvestment() {
		long gameInvestment = 0;
		for (Person name: staff) {
			gameInvestment = gameInvestment + name.getSalary();
		}
		return gameInvestment;
	}
	
	//constructor:
	public Game(String title, Person person) {
		super(title, person);
	}
}

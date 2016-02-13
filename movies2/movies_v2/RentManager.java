package movies_v2;

import java.util.ArrayList;
import java.util.List;

public class RentManager {
	
	public static int summarizeIncome(List<Buyable> products)
	{
		int income = 0;
		for (Buyable item: products)
			income += item.getPrice();
		return income;
	}

	public static void main(String[] args) {

		Movie uvegtigris = new Movie("Uvegtigris", new Person());
		Person customer = uvegtigris.getPerson();
		customer.setFirstName("Adam");
		customer.setFirstName("Vegh");
		customer.setGender(Gender.MALE);
		uvegtigris.setCast(new ArrayList<Person>());
		List<Person> cast = uvegtigris.getCast();
		Person rudolf = new Person();
		rudolf.setFirstName("Peter");
		rudolf.setLastName("Rudolf");
		rudolf.setGender(Gender.MALE);
		rudolf.setSalary(5000);
		cast.add(rudolf);
		Person reviczky = new Person();
		reviczky.setFirstName("Gabor");
		rudolf.setLastName("Reviczky");
		rudolf.setGender(Gender.MALE);
		rudolf.setSalary(4500);
		uvegtigris.setGenre(Genre.COMEDY);
		uvegtigris.setCast(cast);
		uvegtigris.setDuration(104L);
		uvegtigris.setPrice(55);
		
		System.out.println(uvegtigris.getInvestment());
		
		Book azEmberTragediaja = new Book("Az ember tragediaja", uvegtigris.getPerson());
		Person author = new Person();
		author.setFirstName("Imre");
		author.setLastName("Madach");
		author.setGender(Gender.MALE);
		author.setSalary(0);
		azEmberTragediaja.setAuthor(author);
		
		System.out.println(azEmberTragediaja.getInvestment());
		
		Game princeOfPersia = new Game("Prince of Persia", new Person());
		Person customerG1 = new Person();
		customerG1 = princeOfPersia.getPerson();
		customerG1.setFirstName("Lukacs");
		customerG1.setFirstName("Zsori");
		customerG1.setGender(Gender.MALE);
		List<Person> staff1 = princeOfPersia.getStaff();
		Person john = new Person();
		john.setFirstName("John");
		john.setLastName("Ubisoft");
		john.setGender(Gender.MALE);
		john.setSalary(50000);
		staff1.add(john);
		Person jane = new Person();
		jane.setFirstName("Jane");
		jane.setLastName("Ubisoft");
		jane.setGender(Gender.FEMALE);
		jane.setSalary(45000);
		staff1.add(jane);
		princeOfPersia.setStaff(staff1);
		princeOfPersia.setPrice(14);
		
		System.out.println(princeOfPersia.getInvestment());
	}

}

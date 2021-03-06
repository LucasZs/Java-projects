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
		
		List<Product> demodata = generateData();
		printData(demodata);
	}

	public static List<Product> generateData() {
		
		Movie uvegtigris = new Movie("Uvegtigris", new Person());
		Person customerM1 = uvegtigris.getPerson();
		customerM1.setFirstName("Adam");
		customerM1.setFirstName("Vegh");
		customerM1.setGender(Gender.MALE);
		uvegtigris.setCast(new ArrayList<Person>());
		List<Person> cast1 = uvegtigris.getCast();
		Person rudolf = new Person();
		rudolf.setFirstName("Peter");
		rudolf.setLastName("Rudolf");
		rudolf.setGender(Gender.MALE);
		rudolf.setSalary(5000);
		cast1.add(rudolf);
		Person reviczky = new Person();
		reviczky.setFirstName("Gabor");
		reviczky.setLastName("Reviczky");
		reviczky.setGender(Gender.MALE);
		reviczky.setSalary(4500);
		cast1.add(reviczky);
		uvegtigris.setGenre(Genre.COMEDY);
		uvegtigris.setCast(cast1);
		uvegtigris.setDuration(104L);
		uvegtigris.setPrice(55);
		
		Movie valamiAmerika = new Movie("Valami Amerika", new Person());
		Person customerM2 = valamiAmerika.getPerson();
		customerM2.setFirstName("Daniel");
		customerM2.setFirstName("Koics");
		customerM2.setGender(Gender.MALE);
		valamiAmerika.setCast(new ArrayList<Person>());
		List<Person> cast2 = valamiAmerika.getCast();
		Person pindroch = new Person();
		pindroch.setFirstName("Csaba");
		pindroch.setLastName("Pindroch");
		pindroch.setGender(Gender.MALE);
		pindroch.setSalary(4000);
		cast2.add(pindroch);
		Person oroszlan = new Person();
		oroszlan.setFirstName("Szonja");
		oroszlan.setLastName("Oroszlan");
		oroszlan.setGender(Gender.FEMALE);
		oroszlan.setSalary(3000);
		cast2.add(oroszlan);
		valamiAmerika.setGenre(Genre.COMEDY);
		valamiAmerika.setCast(cast2);
		valamiAmerika.setDuration(115L);
		valamiAmerika.setPrice(55);
		
		Book azEmberTragediaja = new Book("Az ember tragediaja", uvegtigris.getPerson());
		Person author1 = new Person();
		author1.setFirstName("Imre");
		author1.setLastName("Madach");
		author1.setGender(Gender.MALE);
		author1.setSalary(0);
		azEmberTragediaja.setAuthor(author1);
		
		Book spaceOdyssey = new Book("2001 - A Space Odyssey", uvegtigris.getPerson());
		Person author2 = new Person();
		author2.setFirstName("Arthur C.");
		author2.setLastName("Clarke");
		author2.setGender(Gender.MALE);
		author2.setSalary(0);
		spaceOdyssey.setAuthor(author2);
		
		Game princeOfPersia = new Game("Prince of Persia", new Person());
		princeOfPersia.setStaff(new ArrayList<Person>());
		List<Person> staff1 = princeOfPersia.getStaff();
		Person customerG1 = new Person();
		customerG1 = princeOfPersia.getPerson();
		customerG1.setFirstName("Lukacs");
		customerG1.setFirstName("Zsori");
		customerG1.setGender(Gender.MALE);
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
		
		Game mortalKombat4 = new Game("Mortal Kombat 4", uvegtigris.getPerson());
		mortalKombat4.setStaff(new ArrayList<Person>());
		List<Person> staff2 = mortalKombat4.getStaff();
		Person johnM = new Person();
		johnM.setFirstName("John");
		johnM.setLastName("Midway");
		johnM.setGender(Gender.MALE);
		johnM.setSalary(48000);
		staff2.add(johnM);
		Person janeM = new Person();
		janeM.setFirstName("Jane");
		janeM.setLastName("Midway");
		janeM.setGender(Gender.FEMALE);
		janeM.setSalary(44000);
		staff2.add(janeM);
		mortalKombat4.setStaff(staff2);
		mortalKombat4.setPrice(3); 
		
		List<Product> data = new ArrayList<>();
		data.add(uvegtigris);
		data.add(valamiAmerika);
		data.add(azEmberTragediaja);
		data.add(spaceOdyssey);
		data.add(princeOfPersia);
		data.add(mortalKombat4);
		return data;
	}

	public static void printData(List<Product> data) {
		
		for (Product product: data) {
			System.out.println("ID:\t" + product.id);
			System.out.println("Investment:\t" + product.getInvestment());
		}
	}
}

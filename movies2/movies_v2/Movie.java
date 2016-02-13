package movies_v2;
import java.util.List;

class Movie extends Product implements Buyable
{
	//variables:
	Genre genre;
	Long duration;
	Double rate;
	List<Person> cast;
	int price;
	

	//getter functions:
	public Genre getGenre()
	{
		return genre;
	}
	
	public long getDuration()
	{
		return duration;
	}
	
	public double getRate()
	{
		return rate;
	}
	
	public List<Person> getCast()
	{
		return cast;
	}

	public int getPrice() {
		return price;
	}
	
	//setter functions:
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public void setCast(List<Person> cast) {
		this.cast = cast;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	//constructor:
	public Movie(String title, Person person) {
		super(title, person);
	}
		
	//method:
	
	@Override
	public long getInvestment() {
		long movieInvestment = 0;
		for (Person name: cast) {
			movieInvestment = movieInvestment + name.getSalary();
		}
		return movieInvestment;
	}
}
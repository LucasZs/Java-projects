import java.util.List;

class Movie
{
	//variables:
	String title;
	Genre genre;
	Long duration;
	Double rate;
	List<Person> cast;
	
	//getter functions:
	public String getTitle()
	{
		return title;
	}
	
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
	
	//setter functions:
	public void setTitle(String a){
		title = a;
	}
	
	public void setGenre(Genre b) {
		genre = b;
	}
	
	public void setDuration(long c) {
		duration = c;
	}
	
	public void setRate(double d) {
		rate = d;
	}
	
	public void setCast(List<Person> e) {
			cast = e;
	}
	
	//method:
	public String toXMLString() {
		String retStr = "";
		retStr += Tools.toXMLTag("title", title);
		retStr += Tools.toXMLTag("genre", genre.toString());
		retStr += Tools.toXMLTag("duration", duration.toString());
		retStr += Tools.toXMLTag("rate", rate.toString());
		String castData = "";
		for (Person actor: cast)
		{
			castData += actor.toXMLString();
		}
		retStr += Tools.toXMLTag("cast", castData);
		return Tools.toXMLTag("movie", retStr);
	}
}

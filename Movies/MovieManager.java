import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;

class MovieManager
{
	static final String PATH_AND_NAME = "C:/DEV/Java/Movies/result.xml";
	
	public static void main(String[] args)
	{
		Person actor = new Person();
		actor.setFirstName("Leonardo");
		actor.setLastName("DiCaprio");
		actor.setGender(Gender.MALE);
		actor.setHasOscar(false);
		actor.setHasGoldenGlobe(true);
		
		System.out.println(Tools.toXMLTag("xml", actor.toXMLString()));
		
		List<Person> titanicCast = new ArrayList<>();
		titanicCast.add(actor);
		
		Movie movie = new Movie();
		movie.setTitle("Titanic");
		movie.setGenre(Genre.DRAMA);
		movie.setDuration(187);
		movie.setRate(4.5);
		movie.setCast(titanicCast);
		
		System.out.println(Tools.toXMLTag("xml", movie.toXMLString()));
		
		try
		{
			FileWriter fileWriter = new FileWriter(PATH_AND_NAME);
			fileWriter.write(Tools.toXMLTag("xml", movie.toXMLString()));
			fileWriter.close();
		}
		catch(java.io.IOException e)
		{
			System.out.println(e.toString());
		}
	}
}
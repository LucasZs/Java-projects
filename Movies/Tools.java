import java.util.List;
import java.util.HashMap;

class Tools
{
	public static String toXMLTag(String tagName, String value)
	{
		return "<" + tagName + ">" + value + "</" + tagName + ">";
	}
	
	public static String[] getMovieTitles(List<Movie> movies)
	{
		String[] titles = new String[movies.size()]; 
		for (int i = 0; i < movies.size(); i++)
		{
			titles[i] = movies.get(i).getTitle();
		}
		return titles;
	}
	
	public static HashMap<Person, Integer> countMoviesPerPerson(List<Movie> movies)
	{
		HashMap<Person, Integer> moviesPerPerson = new HashMap<>();
		for (Movie movie: movies)
		{
			for (Person actor: movie.getCast())
				{
					if (moviesPerPerson.containsKey(actor))
					{
						moviesPerPerson.put(actor, moviesPerPerson.get(actor) + 1);
					}
					else
					{
						moviesPerPerson.put(actor, 1);
					}
				}
		}
		return moviesPerPerson;
	}
}

package movies_v3;

import movies_v3.Book;
import movies_v3.Game;
import movies_v3.Movie;
import movies_v3.Product;

class IdGenerator {
	
	private static int numberOfMovies = 0;
	private static int numberOfBooks = 0;
	private static int numberOfGames = 0;

	public static String generate(Product product) {
		String id = "";
		if (product instanceof Movie) {
			id = "MOV" + String.valueOf(++numberOfMovies);
		}
		
		else if (product instanceof Book) {
			id = "BOO" + String.valueOf(++numberOfBooks);
		}
		else if (product instanceof Game) {
			id = "GAM" + String.valueOf(++numberOfGames);
		}
		return id;

	}
		
}
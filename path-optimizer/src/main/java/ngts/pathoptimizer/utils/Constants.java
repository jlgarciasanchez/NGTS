package ngts.pathoptimizer.utils;

/**
 * Constants class
 *
 */
public class Constants {

	/**
	 * List of cities
	 */
	public static final String[] CITIES = { "Logroño", "Zaragoza", "Teruel", "Madrid", "Lleida", "Alicante",
			"Castellón", "Segovia", "Ciudad Real" };
	
	/**
	 * Matrix with the paths between the cities
	 */
	public static final int[][] CONNECTIONS = { { 0, 4, 6, 8, 0, 0, 0, 0, 0 }, { 4, 0, 2, 0, 2, 0, 0, 0, 0 },
			{ 6, 2, 0, 3, 5, 7, 0, 0, 0 }, { 8, 0, 3, 0, 0, 0, 0, 0, 0 }, { 0, 2, 5, 0, 0, 0, 4, 8, 0 },
			{ 0, 0, 7, 0, 0, 0, 3, 0, 7 }, { 0, 0, 0, 0, 4, 3, 0, 0, 6 }, { 0, 0, 0, 0, 8, 0, 0, 0, 4 },
			{ 0, 0, 0, 0, 0, 7, 6, 4, 0 } };
	
}

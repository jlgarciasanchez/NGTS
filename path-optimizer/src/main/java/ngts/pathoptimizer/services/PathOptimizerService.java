package ngts.pathoptimizer.services;

/**
 * Service interface to calculate the shortest route
 *
 */
public interface PathOptimizerService {

	/**
	 * Method to calculate the shortest path between two cities
	 * @param source city index
	 * @param destination city index
	 * @return the shortest path between two cities
	 */
	public String getPath(int source, int destination);
	
	/**
	 * Method that calculates the shortest path between a city and all the others
	 * @param source city index
	 * @return the shortest path between a city and all the others
	 */
	public String getPath(int source);
	
}

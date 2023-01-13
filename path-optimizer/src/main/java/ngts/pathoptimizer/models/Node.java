package ngts.pathoptimizer.models;

/**
 * Class that stores the index of a city and its distance from the origin
 *
 */
public class Node {

	/**
	 * City index
	 */
	private int index;
	
	/**
	 * Distance from the city to the origin
	 */
	private int dist;
	
	/**
	 * Constructor
	 * @param index
	 * @param dist
	 */
	public Node(int index, int dist) {
		this.index = index;
		this.dist = dist;
	}

	/**
	 * Method that gets the index
	 * @return index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Method that sets the index
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Method that gets the dist
	 * @return dist
	 */
	public int getDist() {
		return dist;
	}

	/**
	 * Method that sets the dist
	 * @param dist
	 */
	public void setDist(int dist) {
		this.dist = dist;
	}
	
}

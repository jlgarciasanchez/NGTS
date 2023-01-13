package ngts.pathoptimizer.models;

import java.util.List;

/**
 * Class that stores the shortest paths from a city and its weight
 *
 */
public class OutputPath {

	/**
	 * List with all the shortest paths from a city of origin ordered by their index.
	 * If only one has been calculated, it is in position 0.
	 */
	List<List<Integer>> paths;
	
	/**
	 * List with all the weights of the shortest paths from a city of origin ordered by their index.
	 * If only one has been calculated, it is in position 0.
	 */
	List<Integer> weights;

	/**
	 * Constructor
	 * @param paths
	 * @param weights
	 */
	public OutputPath(List<List<Integer>> paths, List<Integer> weights) {
		this.paths = paths;
		this.weights = weights;
	}

	/**
	 * Method that gets the paths
	 * @return paths
	 */
	public List<List<Integer>> getPaths() {
		return paths;
	}

	/**
	 * Method that sets the paths
	 * @param paths
	 */
	public void setPaths(List<List<Integer>> paths) {
		this.paths = paths;
	}

	/**
	 * Method that gets the weights
	 * @return weights
	 */
	public List<Integer> getWeights() {
		return weights;
	}

	/**
	 * Method that sets the weights
	 * @param weights
	 */
	public void setWeights(List<Integer> weights) {
		this.weights = weights;
	}
	
}

package ngts.pathoptimizer.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ngts.pathoptimizer.models.Node;
import ngts.pathoptimizer.models.OutputPath;
import ngts.pathoptimizer.utils.Constants;

/**
 * Service class to calculate the shortest route
 *
 */
@Service
public class PathOptimizerServiceImpl implements PathOptimizerService {

	/**
	 * Method to calculate the shortest path between two cities
	 * @param source city index
	 * @param destination city index
	 * @return the shortest path between two cities
	 */
	@Override
	public String getPath(int source, int destination) {
		OutputPath output = pathOptimization(source, destination);
		return generateStringOutput(output, source, destination, 0);
	}

	/**
	 * Method that calculates the shortest path between a city and all the others
	 * @param source city
	 * @return the shortest path between a city and all the others
	 */
	@Override
	public String getPath(int source) {
		OutputPath output = pathOptimization(source, -1);

		String outputString = String.format(
				"Estos son los caminos más cortos entre %s y las demás ciudades: \n", Constants.CITIES[source]);
		for (int i = 0; i < Constants.CITIES.length; i++) {
			//The city of origin is omitted
			if(source != i) {
				outputString += generateStringOutput(output, source, i, i) + "\n";
			}
		}
		return outputString;
	}

	/**
	 * Dijkstra's algorithm is used to calculate the shortest path between two cities or between one and the others.
	 * To indicate that it is going to calculate between a city and the others, the destination index must have a value of -1.
	 * @param source city index
	 * @param destination city index or -1
	 * @return the shortest path between two cities or the shortest path between a city and all the others
	 */
	private OutputPath pathOptimization(int source, int destination) {

		// Init paths.
		Integer[] distances = new Integer[Constants.CONNECTIONS.length];
		int[] predecesors = new int[distances.length];

		for (int i = 0; i < distances.length; i++) {
			distances[i] = Integer.MAX_VALUE;
			predecesors[i] = -1;
		}
		distances[source] = 0;

		boolean[] visited = new boolean[distances.length];

		List<Node> list = new LinkedList<>();

		// Init list with source.
		list.add(new Node(source, 0));

		Node minElement;
		int minDist;

		while (!list.isEmpty()) {

			minElement = null;
			minDist = Integer.MAX_VALUE;

			// Take the path with the least weight in the list.
			for (Node element : list) {
				if (element.getDist() < minDist) {
					minElement = element;
					minDist = element.getDist();
				}
			}
			list.remove(minElement);
			int elementIndex = minElement.getIndex();

			// If the destination city has already been reached, the execution is stopped
			if (elementIndex == destination) {
				break;
			}

			// For each unvisited element its neighbors are checked.
			if (!visited[elementIndex]) {
				visited[elementIndex] = true;
				for (int i = 0; i < distances.length; i++) {

					// If a new shorter path is found, the distance and predecessor are updated.
					if (Constants.CONNECTIONS[elementIndex][i] > 0
							&& distances[i] > distances[elementIndex] + Constants.CONNECTIONS[elementIndex][i]) {
						distances[i] = distances[elementIndex] + Constants.CONNECTIONS[elementIndex][i];
						predecesors[i] = elementIndex;
						list.add(new Node(i, distances[i]));
					}
				}
			}

		}

		// Solution post-processing
		List<List<Integer>> outputPaths = new ArrayList<>();
		List<Integer> outputPath = new ArrayList<>();
		List<Integer> outputWeigths = new ArrayList<>();

		if (destination != -1) {
			// Two cities case
			int pred = destination;
			// Build the path
			while (pred != -1) {
				outputPath.add(pred);
				pred = predecesors[pred];
			}
			Collections.reverse(outputPath);
			outputPaths.add(outputPath);
			//Get the distance
			outputWeigths.add(distances[destination]);
		} else {
			// One to all cities case
			for (int i = 0; i < distances.length; i++) {
				outputPath = new ArrayList<>();
				int pred = i;
				// Build the path
				while (pred != -1) {
					outputPath.add(pred);
					pred = predecesors[pred];
				}
				Collections.reverse(outputPath);
				outputPaths.add(outputPath);
			}
			//Get the distance
			outputWeigths = Arrays.stream(distances).collect(Collectors.toList());
		}

		return new OutputPath(outputPaths, outputWeigths);
	}

	/**
	 * Format the solution text. If the path between two cities is to be formatted, the value of current must be equal to 0.
	 * @param output object with routes and distances
	 * @param source city index
	 * @param destination city index
	 * @param current position in the list of roads and distances. It can have the value 0 or the index of the destination city. 
	 * @return a text with the path between the two cities and its weight.
	 */
	public String generateStringOutput(OutputPath output, int source, int destination, int current) {
		String outputString = String.format("El camino más corto entre %s y %s es: ", Constants.CITIES[source],
				Constants.CITIES[destination]);
		List<Integer> currentPath = output.getPaths().get(current);
		for (Integer i : currentPath) {
			outputString += Constants.CITIES[i] + ", ";
		}
		//The comma and space after the last city are removed
		outputString = outputString.substring(0, outputString.length() - 2);
		outputString += ". Con un peso total de: " + output.getWeights().get(current);
		return outputString;
	}

}

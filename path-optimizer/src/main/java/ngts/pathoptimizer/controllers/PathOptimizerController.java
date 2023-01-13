package ngts.pathoptimizer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ngts.pathoptimizer.services.PathOptimizerService;
import ngts.pathoptimizer.utils.Constants;
import ngts.pathoptimizer.utils.Utils;

/**
 * Controller class to compute shortest routes between cities
 *
 */
@RestController
public class PathOptimizerController {
	
	/**
	 * The service that calculates the route
	 */
	@Autowired
	private PathOptimizerService pathOptimizerService;

	/**
	 * Method that sets the service
	 * @param pathOptimizerService
	 */
	public void setPathOptimizerService(PathOptimizerService pathOptimizerService) {
		this.pathOptimizerService = pathOptimizerService;
	}

	/**
	 * Method to calculate the shortest path between two cities
	 * @param source city
	 * @param destination city
	 * @return the shortest path between two cities
	 */
	@GetMapping("/path/{source}/{destination}")
	public String getPath(@PathVariable("source") String source, @PathVariable("destination") String destination) {
		int sourceIndex = Utils.findIndexIgnoreCaps(source, Constants.CITIES);
		//Checks if the origin city is among the available cities.
		if(sourceIndex<0) {
			return "Lo siento, la ciudad de origen no es válida.";
		}
		//Checks if the destination city is among the available cities.
		int destinationIndex = Utils.findIndexIgnoreCaps(destination, Constants.CITIES);
		if(destinationIndex<0) {
			return "Lo siento, la ciudad de destino no es válida.";
		}
		//Calls the service that calculates the route
		return pathOptimizerService.getPath(sourceIndex, destinationIndex);
	}
	
	/**
	 * Method that calculates the shortest path between a city and all the others
	 * @param source city
	 * @return the shortest path between a city and all the others
	 */
	@GetMapping("/path/{source}")
	public String getPath(@PathVariable("source") String source) {
		//Checks if the origin city is among the available cities.
		int sourceIndex = Utils.findIndexIgnoreCaps(source, Constants.CITIES);
		if(sourceIndex<0) {
			return "Lo siento, la ciudad de origen no es válida.";
		}
		//Calls the service that calculates the routes
		return pathOptimizerService.getPath(sourceIndex);
	}
	
}

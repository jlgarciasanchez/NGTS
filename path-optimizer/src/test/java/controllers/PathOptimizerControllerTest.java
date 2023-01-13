package controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ngts.pathoptimizer.controllers.PathOptimizerController;
import ngts.pathoptimizer.services.PathOptimizerServiceImpl;

/**
 * Test class for PathOptimizerController
 *
 */
public class PathOptimizerControllerTest {

/**
 * PathOptimizerController instance
 */
private PathOptimizerController pathOptimizerController;
	
	/**
	 * Initializes the controller and its service
	 */
	@BeforeEach
    public void setUp() {
		pathOptimizerController = new PathOptimizerController();
		pathOptimizerController.setPathOptimizerService(new PathOptimizerServiceImpl());
    }
	
	/**
	 * Test getPath method with destination
	 */
	@Test
	public void getPathWithDestinationTest() {
		String expectedOutput = "El camino más corto entre Castellón y Teruel es: Castellón, Lleida, Zaragoza, Teruel. Con un peso total de: 8";
		//Valid path test
		assertEquals(expectedOutput,pathOptimizerController.getPath("Castellón", "Teruel"));
		//Valid path ignoring caps and accents test
		assertEquals(expectedOutput,pathOptimizerController.getPath("Castellon", "TERUEL"));
		expectedOutput = "Lo siento, la ciudad de destino no es válida.";
		//Invalid destination city test
		assertEquals(expectedOutput,pathOptimizerController.getPath("Logroño", "Barcelona"));
		//Invalid origin city test
		expectedOutput = "Lo siento, la ciudad de origen no es válida.";
		assertEquals(expectedOutput,pathOptimizerController.getPath("Valencia", "Madrid"));
	}
	
	/**
	 * Test getPath method without destination
	 */
	@Test
	public void getPathWithoutDestinationTest() {
		String expectedOutput = "Estos son los caminos más cortos entre Castellón y las demás ciudades: \n"
				+ "El camino más corto entre Castellón y Logroño es: Castellón, Lleida, Zaragoza, Logroño. Con un peso total de: 10\n"
				+ "El camino más corto entre Castellón y Zaragoza es: Castellón, Lleida, Zaragoza. Con un peso total de: 6\n"
				+ "El camino más corto entre Castellón y Teruel es: Castellón, Lleida, Zaragoza, Teruel. Con un peso total de: 8\n"
				+ "El camino más corto entre Castellón y Madrid es: Castellón, Lleida, Zaragoza, Teruel, Madrid. Con un peso total de: 11\n"
				+ "El camino más corto entre Castellón y Lleida es: Castellón, Lleida. Con un peso total de: 4\n"
				+ "El camino más corto entre Castellón y Alicante es: Castellón, Alicante. Con un peso total de: 3\n"
				+ "El camino más corto entre Castellón y Segovia es: Castellón, Ciudad Real, Segovia. Con un peso total de: 10\n"
				+ "El camino más corto entre Castellón y Ciudad Real es: Castellón, Ciudad Real. Con un peso total de: 6\n";
		//Valid path test
		assertEquals(expectedOutput,pathOptimizerController.getPath("Castellón"));
		//Valid path ignoring caps and accents test
		assertEquals(expectedOutput,pathOptimizerController.getPath("CASTELLON"));
		expectedOutput = "Lo siento, la ciudad de origen no es válida.";
		//Invalid origin city test
		assertEquals(expectedOutput,pathOptimizerController.getPath("Valencia"));
	}

}

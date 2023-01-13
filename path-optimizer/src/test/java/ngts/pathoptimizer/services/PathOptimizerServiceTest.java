package ngts.pathoptimizer.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for PathOptimizerService
 *
 */
public class PathOptimizerServiceTest {

	/**
	 * PathOptimizerService instance
	 */
	private PathOptimizerService pathOptimizerService;
	
	/**
	 * Initializes the service
	 */
	@BeforeEach
    public void setUp() {
		pathOptimizerService = new PathOptimizerServiceImpl();
		
    }
	
	/**
	 * Test getPath method with destination
	 */
	@Test
	public void getPathWithDestinationTest() {
		String expectedOutput = "El camino más corto entre Logroño y Madrid es: Logroño, Madrid. Con un peso total de: 8";
		assertEquals(expectedOutput,pathOptimizerService.getPath(0, 3));
		expectedOutput = "El camino más corto entre Segovia y Castellón es: Segovia, Ciudad Real, Castellón. Con un peso total de: 10";
		assertEquals(expectedOutput,pathOptimizerService.getPath(7, 6));
	}
	
	/**
	 * Test getPath method without destination
	 */
	@Test
	public void getPathWithoutDestinationTest() {
		String expectedOutput = "Estos son los caminos más cortos entre Teruel y las demás ciudades: \n"
				+ "El camino más corto entre Teruel y Logroño es: Teruel, Logroño. Con un peso total de: 6\n"
				+ "El camino más corto entre Teruel y Zaragoza es: Teruel, Zaragoza. Con un peso total de: 2\n"
				+ "El camino más corto entre Teruel y Madrid es: Teruel, Madrid. Con un peso total de: 3\n"
				+ "El camino más corto entre Teruel y Lleida es: Teruel, Zaragoza, Lleida. Con un peso total de: 4\n"
				+ "El camino más corto entre Teruel y Alicante es: Teruel, Alicante. Con un peso total de: 7\n"
				+ "El camino más corto entre Teruel y Castellón es: Teruel, Zaragoza, Lleida, Castellón. Con un peso total de: 8\n"
				+ "El camino más corto entre Teruel y Segovia es: Teruel, Zaragoza, Lleida, Segovia. Con un peso total de: 12\n"
				+ "El camino más corto entre Teruel y Ciudad Real es: Teruel, Alicante, Ciudad Real. Con un peso total de: 14\n"
				+ "";
		assertEquals(expectedOutput,pathOptimizerService.getPath(2));
	}
	
}

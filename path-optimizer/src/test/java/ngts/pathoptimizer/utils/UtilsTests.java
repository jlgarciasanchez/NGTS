package ngts.pathoptimizer.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UtilsTests {

	/**
	 * Test findIndexIgnoreCaps method
	 */
	@Test
	public void findIndexIgnoreCapsTest() {
		String[] array  = {"CAFÉ", "LECHE", "azúcar"};
		assertEquals(Utils.findIndexIgnoreCaps("CAFÉ", array), 0);
		assertEquals(Utils.findIndexIgnoreCaps("cafe", array), 0);
		assertEquals(Utils.findIndexIgnoreCaps("AZUCAR", array), 2);
		assertEquals(Utils.findIndexIgnoreCaps("sacarina", array), -1);
	}
	
	/**
	 * Test removeAccent method
	 */
	@Test
	public void removeAccentTest() {
		assertEquals(Utils.removeAccent("CAFÉ"), "CAFE");
		assertEquals(Utils.removeAccent("café"), "cafe");
		assertEquals(Utils.removeAccent("azúcar"), "azucar");
	}
	
}

package ngts.pathoptimizer.utils;

/**
 * Class with general methods
 *
 */
public class Utils {

	/**
	 * Method to obtain the position in an array of a String ignoring capital letters and accents
	 * @param element
	 * @param array
	 * @return the position in an array of a String ignoring case and accents
	 */
	public static int findIndexIgnoreCaps(String element, String[] array) {
		for (int i = 0; i < array.length; i++) {
			if (removeAccent(array[i]).equalsIgnoreCase(removeAccent(element))) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Method that eliminates the accents in a string.
	 * @param string
	 * @return the string without accents
	 */
	public static String removeAccent(String string) {
		string = string.replaceAll("[á|à|ä|â]", "a");
	    string = string.replaceAll("[é|è|ë|ê]", "e");
	    string = string.replaceAll("[í|ì|ï|î]", "i");
	    string = string.replaceAll("[ó|ò|ö|ô]", "o");
	    string = string.replaceAll("[ú|ù|ü|û]", "u");
	    string = string.replaceAll("[Á|À|Ä|Â]", "A");
	    string = string.replaceAll("[É|È|Ë|Ê]", "E");
	    string = string.replaceAll("[Í|Ì|Ï|Î]", "I");
	    string = string.replaceAll("[Ó|Ò|Ö|Ô]", "O");
	    string = string.replaceAll("[Ú|Ù|Ü|Û]", "U");
	    return string;
	}
	
	

}

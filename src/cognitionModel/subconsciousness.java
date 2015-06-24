package cognitionModel;

public class Subconsciousness {

	/**
	 * 
	 * @param word The Colored word which color should be returned.
	 * @return the color of the given word.
	 */
	public static String getColor(String word){
		String[] wordAndColor = word.split(", ");
		return wordAndColor[1];

	}
	
}

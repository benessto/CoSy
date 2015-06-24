package cognitionModel;

public class Consciousness {

	/**
	 * 
	 * @param word The Colored word which color should be returned.
	 * @return the color of the given word.
	 */
	public static String getColor(String word){
		System.out.println("con: " + word);
		String[] wordAndColor = word.split(", ");
		return wordAndColor[0];

	}
}
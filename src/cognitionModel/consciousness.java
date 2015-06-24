package cognitionModel;

public class Consciousness {

	/**
	 * 
	 * @param word The Colored word which color should be returned.
	 * @return the color of the given word.
	 */
	public String getColor(String word){
		String[] wordAndColor = word.split(", ");
		return wordAndColor[2];

	}
}
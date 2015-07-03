package cognitionModel;

public class MemoryConcept {
	private String word;
	private String category;
	private int familarity;
	private int personalMemory;
	
	public MemoryConcept (String w, String c, int f, int p) {
		setWord(w);
		setCategory(c);
		setFamilarity(f);
		setPersonalMemory(p);
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the familarity
	 */
	public int getFamilarity() {
		return familarity;
	}

	/**
	 * @param familarity the familarity to set
	 */
	public void setFamilarity(int familarity) {
		this.familarity = familarity;
	}

	/**
	 * @return the personalMemory
	 */
	public int getPersonalMemory() {
		return personalMemory;
	}

	/**
	 * @param personalMemory the personalMemory to set
	 */
	public void setPersonalMemory(int personalMemory) {
		this.personalMemory = personalMemory;
	}
	
	
}

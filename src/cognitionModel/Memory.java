package cognitionModel;

import java.util.HashMap;

public class Memory {
	private HashMap<String, Integer> memoryMap;
	
	/**
	 * Initialize the memory
	 */
	public Memory() {
		memoryMap = new HashMap<String, Integer>();	
	}
	
	/**
	 * Is the specified element already in the memory?
	 * @param element An element as String e.g. "Blue Square"
	 * @true There is a memory of this element
	 * @false There is no memory of this element
	 */
	public boolean hasMemory(String element) {
			return memoryMap.containsKey(element);
	}
	
	/**
	 * Saves the element and it's value in the HashMap
	 * @param element The element to be memorized
	 * @param value The amount of found elements
	 */
	public void memorize(String element, int value) {
		if(!hasMemory(element)){
			memoryMap.put(element, value);
		}
	}
	
	/**
	 * Returns the memorized amount of the element 
	 * @param element Form and color of the element
	 * @return Memorized amount
	 * @return -1 No memory found
	 */
	public int getMemory(String element) {
		if (hasMemory(element)) {
			return memoryMap.get(element);
		} else {
			return -1;
		}
	}
}

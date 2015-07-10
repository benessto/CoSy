package cognitionModel;

import java.util.ArrayList;

public class MidMemory {

	private ArrayList<MemoryConcept> memory = new ArrayList<MemoryConcept>();
	
	public void memorize(MemoryConcept toMemorize){
		memory.add(toMemorize);
	}
	
	public ArrayList<MemoryConcept> getMemory(){
		return memory;
	}
}

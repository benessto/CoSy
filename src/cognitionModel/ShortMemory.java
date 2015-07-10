package cognitionModel;

public class ShortMemory {
	private MemoryConcept[] buffer = new MemoryConcept[7];
	int index = 0;
	
	
	public void memorize(MemoryConcept memory){
		if(index>=7){
			index = 0;
		}
		buffer[index] = memory;
		index++;
	}
	
	public MemoryConcept[] getBuffer(){
		return buffer;
	}
	
	public Boolean contains(String word){
		for(int i = 0; i<buffer.length; i++){
			if(buffer[i].equals(word)){
				return true;
			}
		}
		return false;
	}
	
}

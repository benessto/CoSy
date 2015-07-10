package cognitionModel;

public class Human {
	private LongMemory longMem;
	private ShortMemory shortMem;
	private MidMemory midMem;
	private int affectionMax;
	
	public Human() {
		
	}
	
	public boolean answer(Question question){
		// Think about question (process memory)
		MemoryConcept word = longMem.getMemoryConcept(question.getWord();
		String answer = "yes";
		putInShort(word);
		associate();
		processMid();
		printAnswer(answer);
		
		return true;
	}
	
	public void putInShort(MemoryConcept memory) {
		shortMem.memorize(memory);
	}
	
	public void processMid() {
			
		}
	
	public void processLong() {
		
	}
	public void printAnswer(){
		System.out.println("");
	}
}

package cognitionModel;

public class Human {
	private final int AFFECTION_MAX = 2500;
	
	private LongMemory longMem;
	private ShortMemory shortMem;
	private MidMemory midMem;
	private int affection;
	
	public Human() {
		affection = AFFECTION_MAX;
		longMem = new LongMemory(affection);

	}
	
	public boolean answer(Question question){
		// Think about question (process memory)
		MemoryConcept word = longMem.getMemoryConcept(question.getWord());
		String answer = "yes";
		putInShort(word);
		associate(question, word);
		processMid();
		printAnswer(answer);
		
		return true;
	}
	
	public void putInShort(MemoryConcept memory) {
		shortMem.memorize(memory);
	}
	
	public void processMid(MemoryConcept memory) {
			//To-Do: Threshold
		midMem.memorize(memory);
	}
	
	public void processLong() {
		
	}
	public void printAnswer(String answer){
		System.out.println(answer);
	}
}

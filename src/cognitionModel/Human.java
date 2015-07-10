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
		// Get Question
		// Think about question (process memory)
		// Give an answer
		
		return true;
	}
	
	public void processShort() {
		
	}
	
	public void processMid() {
			
		}
	
	public void processLong() {
		
	}
}

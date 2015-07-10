package cognitionModel;

public class Human {
	private final int AFFECTION_MAX = 20000;
	
	private LongMemory longMem;
	private ShortMemory shortMem;
	private MidMemory midMem;
	private int affection;
	
	public Human() {
		affection = AFFECTION_MAX;
		longMem = new LongMemory(affection);
		shortMem = new ShortMemory();
		midMem = new MidMemory();

	}
	
	public boolean answer(Question question){
		// Think about question (process memory)
		System.out.println(question.getQuestion());
		MemoryConcept word = longMem.getMemoryConcept(question.getWord());
		String answer = question.getAnswer();
		memorizeInShort(word);
		associate(question, word);
		processMid(word);
		printAnswer(answer);
		
		return true;
	}
	

	public boolean answerToMemoryTest(String word){
		if(shortMem.contains(word)){
			return true;
		}
		if(midMem.contains(word)){
			return true;
		}
		return false;
	}

	public void associate(Question question, MemoryConcept word){

		
		int expertise = word.getExpertise();
		int catassociate = 10;
		int connectionassociate = word.getFamilarity()/5; 
		
		if (question.getQuestionType() == "upper" || question.getQuestionType() == "lower" ){
			expertise = expertise + 10;
			System.out.println("The temporary Expertise towards the word: " + word.getWord() + " increased by " + expertise + "." );
			word.setExpertise(expertise);
		}	else {
			if (question.getAnswer() == "yes"){
				catassociate = catassociate + 30;
				expertise = expertise + 10 * ((connectionassociate+catassociate)/100)+1;
				System.out.println("The temporary Expertise towards the word: " + word.getWord() + " increased by " + expertise + "." );
				word.setExpertise(expertise);
			} else {
				expertise = expertise + 10 * ((connectionassociate+catassociate)/100)+1;
				System.out.println("The temporary Expertise towards the word: " + word.getWord() + " increased by " + expertise + "." );
				word.setExpertise(expertise);
				}
		}
	}
	
	public void memorizeInShort(MemoryConcept memory) {
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

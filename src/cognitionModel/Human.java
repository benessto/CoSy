package cognitionModel;

import java.util.Random;

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
		double expbonus = 0;
		double catassociate = 10;
		double connectionassociate = word.getFamilarity(); 
		
		if (question.getQuestionType() == "upper" || question.getQuestionType() == "lower" ){
			expbonus = expbonus + 10;
			System.out.println("The temporary Expertise towards the word: " + word.getWord() + " increased by " + (int)expbonus + "." );
			word.setExpertise(expertise+(int)expbonus);
			
		}	else {
			if (question.getAnswer() == "yes"){
				catassociate = catassociate + 30;
				double test = ((((connectionassociate/2)+catassociate)/100)+1);
				System.out.println("|| Familarity: " + connectionassociate + " || Categoryassociation: " + catassociate + " || Multiplicator: " + test + " ||");
				expbonus = expbonus + (30 * ((((connectionassociate/2)+catassociate)/100)+1));
				System.out.println("The temporary Expertise towards the word: " + word.getWord() + " increased by " + (int)expbonus + "." );
				word.setExpertise(expertise+(int)expbonus);
				
			} else {
				double test = ((((connectionassociate/2)+catassociate)/100)+1);
				System.out.println("|| Familarity: " + connectionassociate + " || Categoryassociation: " + catassociate + " || Multiplicator: " + test + " ||");
				expbonus = expbonus + (30 * ((((connectionassociate/2)+catassociate)/100)+1));
				System.out.println("The temporary Expertise towards the word: " + word.getWord() + " increased by " + (int)expbonus + "." );
				word.setExpertise(expertise+(int)expbonus);
				}
		}
	}
	
	public void memorizeInShort(MemoryConcept memory) {
		shortMem.memorize(memory);
	}
	
	public void processMid(MemoryConcept memory) {
		Random random = new Random();
		int pers = random.nextInt(101);
		if(memory.getExpertise()>pers){
			midMem.memorize(memory);
		}
	}
	
	public void processLong() {
		
	}
	public void printAnswer(String answer){
		System.out.println("My Answer is: " + answer + "\n");
		
	}
}

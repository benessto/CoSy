package cognitionModel;

import java.util.ArrayList;
import java.util.Random;

public class Examiner {
	private final int TEST_SIZE = 100;
	private Human human;
	private int correctAnswers = 0;

 	private Question[] test = new Question[TEST_SIZE];
 	private ArrayList<String> memoryTest = new ArrayList<String>();
 	
 	public Examiner(Human human){
 		this.human = human;
 	}
 	
	public void prepareQuestions() {
		for (int i = 0; i < TEST_SIZE; i++) {
			int r = new Random().nextInt(3);
			switch (r) {
			case 0:
				test[i] = getLowerCaseQuestion();
				break;
			case 1:
				test[i] = getUpperCaseQuestion();
				break;
			case 2:
				test[i] = askForCategory();
			}
		}
		for(int j =0; j<150; j++){
			String word = Metaknowledge.getRandomWord();
			while(memoryTest.contains(word)){
				word = Metaknowledge.getRandomWord();
			}
			memoryTest.add(word);
			
		}
		
	}
	
	public void testMemory(){
		for(String word : memoryTest){
			evaluateAnswer(word, human.answerToMemoryTest(word));
		}
	}
	
	private void evaluateAnswer(String word, Boolean answer){
		for(int i = 0; i < test.length; i++){
			if(test[i].getWord().equals(word)){
				if(answer){
					correctAnswers++;
					break;
				} else {
					break;
				}
			}
		}
		if(!answer){
			correctAnswers++;
		}
	}
	
	public void askQuestions(){
		for(int i = 0; i<test.length; i++){
			human.answer(test[i]);
		}
	}
	
	public void printTest() {
		for (int i = 0; i < test.length; i++) {
			System.out.println(i+1+". "+test[i].getQuestion());
			System.out.println(i+1+". "+test[i].getAnswer());
		}
	}
	
	public Question getLowerCaseQuestion() {
		Question question = new Question();
		String q1 = "Is the word ";
		String q2 = " written in lower case?";
		String word = Metaknowledge.getRandomWord().toLowerCase();
		
		question.setWord(word);
		question.setQuestion(q1+word+q2);
		question.setQuestionType("lower");
		question.setAnswer("yes");
		return question;
	}
	
	public Question getUpperCaseQuestion() {
		Question question = new Question();
		String q1 = "Is the word ";
		String q2 = " written in upper case?";
		String word = Metaknowledge.getRandomWord().toUpperCase();
		
		question.setWord(word);
		question.setQuestion(q1+word+q2);
		question.setQuestionType("upper");
		question.setAnswer("yes");
		return question;
	}
	
	public Question askForCategory() {
		Question question = new Question();
		
		Random random = new Random();
		int randomCategory1 = random.nextInt(Metaknowledge.getData().size());
		int randomCategory2 = random.nextInt(Metaknowledge.getData().size());
		String cat1 = null;
		String cat2 = null;
		
		int i = 0;
		for (String category : Metaknowledge.getData().keySet()) {
			if (randomCategory1 == i) {
				cat1 = category;
			}
			
			if (randomCategory2 == i) {
				cat2 = category;
			}
			
			i++;
		}
		
		String[] category1 = Metaknowledge.getData().get(cat1);
		
		String word = category1[random.nextInt(category1.length)];
		
		String q1 = "Is ";
		
		question.setWord(word);
		if (cat2.equals("animal")) {
			question.setQuestion(q1+word+" an "+cat2+"?");
		} else {
			question.setQuestion(q1+word+" a "+cat2+"?");
		}
		
		question.setQuestionType("category");
		question.setCategory(cat2);
		if (cat1.equals(cat2)) {
			question.setAnswer("yes");
		} else {
			question.setAnswer("no");
		}
		
		return question;
	}
}

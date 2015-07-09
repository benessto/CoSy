package cognitionModel;

import java.util.Random;

public class Examiner {
	private final int TEST_SIZE = 100;

 	private Question[] test = new Question[TEST_SIZE];
 	
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
	}
	
	public void printTest() {
		for (int i = 0; i < test.length; i++) {
			System.out.println(i+1+". "+test[i].getQuestion());
		}
	}
	
	public Question getLowerCaseQuestion() {
		Question question = new Question();
		String q1 = "[L] Is the word ";
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
		String q1 = "[U] Is the word ";
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
		int c1 = random.nextInt(Metaknowledge.getCategories().length);
		String[] category1 = Metaknowledge.getCategories()[c1];
		
		String word = category1[random.nextInt(category1.length)];
		
		String q1 = "[C] Is ";
		String category = null;
		
		int c2 = random.nextInt(Metaknowledge.getCategories().length);
		switch (c2) {
		case 0:
			category = "animal";
			break;
		case 1:
			category = "plant";
			break;
		case 2:
			category = "machine";
			break;
		case 3:
			category = "film";
			break;
		case 4:
			category = "furniture";
			break;
		}
		
		question.setWord(word);
		if (c2 == 0) {
			question.setQuestion(q1+word+" an "+category+"?");
		} else {
			question.setQuestion(q1+word+" a "+category+"?");
		}
		
		question.setQuestionType("category");
		question.setCategory(category);
		if (c1 == c2) {
			question.setAnswer("yes");
		} else {
			question.setAnswer("no");
		}
		
		return question;
	}
}

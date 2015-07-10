package cognitionModel;

public class Experiment {
	Human human;
	Examiner examiner;
	
	public Experiment() {
		createHuman();
		createExaminer();
		examiner.prepareQuestions();
		examiner.askQuestions();
		examiner.testMemory();
	}
	
	public Human createHuman() {
		human = new Human();
		return human;
	}
	
	private Examiner createExaminer(){
		examiner = new Examiner(human);
		return examiner;
	}
}

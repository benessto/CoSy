package cognitionModel;

public class Experiment {
	Human human;
	
	public Experiment() {
		
	}
	
	public Human createHuman() {
		human = new Human();
		return human;
	}
}

package cognitionModel;

public class Cognition  {
	public String[] words;
	public int delay = 850; // in millisecond
	public double readability = 95.00;
	public int time;
	
	public void increaseReadability (int percentage) {
		double temp = (percentage + 100) / 100;
		readability = readability * temp;
	}
	
	public void decreaseReadability (int percentage) {
		double temp = percentage / 100;
		readability = readability * temp;
	}
	
	public void setWords (String[] words) {
		this.words = words;
	}
	
	public void resolveConflict () {
		
	}
}

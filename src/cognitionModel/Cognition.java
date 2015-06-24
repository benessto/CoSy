package cognitionModel;

public class Cognition  {
	public String[] words;
	public int delay = 850; // in millisecond
	public double trueSafety = 95.00;
	public double perceivedSafety = 60;
	public int time;
	
	public void increaseTrueSafety (int percentage) {
		double temp = (percentage + 100) / 100;
		trueSafety = trueSafety * temp;
	}
	
	public void decreaseTrueSafety (int percentage) {
		double temp = percentage / 100;
		trueSafety = trueSafety * temp;
	}
	
	public void increasePerceivedSafety(){
		
	}
	
	public void decreasePerceivedSafety(){
		
	}
	
	public void increaseSpeed(){
		
	}
	
	public void decreaseSpeed(){
		
	}
	
	public void setWords (String[] words) {
		this.words = words;
	}
	
	public void resolveConflict () {
		
	}
	
	public boolean rightDecision(){
		return false;
	}
	
	
	
	
}

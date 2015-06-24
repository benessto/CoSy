package cognitionModel;

public class Cognition  {
	public String[] words;
	public final int delay = 350; // in millisecond
	public final int initialSpeed = 850;
	public final int maxSpeed = 600;
	public int speed = 850;
	public double trueSafety = 95.00;
	public double perceivedSafety = 60;
	public int time;
	public int combo = 0; //anzahl richtiger elemente in folge
	
	public void increaseTrueSafety (int percentage) {
		double temp = (percentage + 100) / 100;
		trueSafety = trueSafety * temp;
	}
	
	public void decreaseTrueSafety (int percentage) {
		double temp = percentage / 100;
		trueSafety = trueSafety * temp;
	}
	
	public void increasePerceivedSafety(int percentage){
		double temp = (percentage + 100) / 100;
		perceivedSafety = perceivedSafety * temp;
	}
	
	public void decreasePerceivedSafety(int percentage){
		double temp = percentage / 100;
		perceivedSafety = perceivedSafety * temp;
	}
	public void increaseSpeed(){
		double G = (initialSpeed-maxSpeed)/100; //höchstwert von speed
		double e = 2.71828; //eulersche zahl
		
		
		double speedIncreaseRaw = G*(1/(1+Math.pow(e, (-0.15*G*combo))*(G/0.1-1))); //2,5*(1/(1+2,71828^(-0,15*2,5*x)*(2,5/0,1-1))) http://funktion.onlinemathe.de/
		speedIncreaseRaw = speedIncreaseRaw*100;
		speed += speedIncreaseRaw * (perceivedSafety/4+100)/100;
		
		
		
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

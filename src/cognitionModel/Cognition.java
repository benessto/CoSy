package cognitionModel;

import java.util.Random;

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
	private double speedIncreaseRaw = 0;
	
	public void sight(String[] wordlist){
		for (int x = 0; x < 10; x++){
			String consciousResult = Consciousness.getColor(wordlist[x]);
			String subconsciousResult = Subconsciousness.getColor(wordlist[x]);
			resolveConflict(consciousResult, subconsciousResult);
			increaseTrueSafety();
			decreaseTrueSafety();
			System.out.println("TrueSafety: " + trueSafety + " PerceivedSafety: " + perceivedSafety + "Speed: " + speed);
		}
	}	
	
	public void increaseTrueSafety () {
		if(trueSafety < 98){
			trueSafety += 0.5;
		}
	}
	
	public void decreaseTrueSafety () {
		trueSafety -= speedIncreaseRaw/100;
		speedIncreaseRaw = 0;
	}
	
	public void increasePerceivedSafety(){
		if(perceivedSafety < 98){
			perceivedSafety += 1.5;
		}
	}
	
	public void decreasePerceivedSafety(){
			perceivedSafety = perceivedSafety / 2;
			
	}
	public void increaseSpeed(){
		double G = (double)(initialSpeed-maxSpeed)/100; //höchstwert von speed
		System.out.println(G);
		double e = 2.71828; //eulersche zahl
		
		
		double speedIncreaseRaw = G*(1/(1+Math.pow(e, (-0.15*G*combo))*(G/0.1-1))); //2,5*(1/(1+2,71828^(-0,15*2,5*x)*(2,5/0,1-1))) http://funktion.onlinemathe.de/
		System.out.println("speedIncrease: " + speedIncreaseRaw);
		speedIncreaseRaw = speedIncreaseRaw*100;
		speedIncreaseRaw = speedIncreaseRaw * (perceivedSafety/4+100)/100;
		speed -= speedIncreaseRaw;
		
		
		
	}
	
	public void decreaseSpeed(){
		double speedDecrease = -0.1*Math.pow((double)((speed/100)), 2)+10; // -0,1x^2+10 http://funktion.onlinemathe.de/
		System.out.println("SPEEDDECREASE: " + speedDecrease + "SPEED: " + speed);
		speedDecrease = speedDecrease*100;
		System.out.println("SPEEDDECREASE: " + speedDecrease);
		speed = speed+(int)speedDecrease;
	}
	
	
	public void setWords (String[] words) {
		this.words = words;
	}
	
	public void resolveConflict (String con, String subcon) {
		Random randomGenerator = new Random();
		int randomint = randomGenerator.nextInt(101);
		if (randomint > trueSafety || speed < maxSpeed){//Error-case
			System.out.println("I'm perceiving the color " + subcon + ".");
			combo = 0;
			decreasePerceivedSafety();
			decreaseSpeed();
			
		} else {//Correct-case
			System.out.println("I'm perceiving the color " + con + ".");
			combo++;
			increasePerceivedSafety();
			increaseSpeed();
			
		}
	}
	
	public boolean rightDecision(){
		return false;
	}
	
	
	
	
}

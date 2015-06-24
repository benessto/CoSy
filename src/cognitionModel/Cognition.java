package cognitionModel;

import java.util.Random;
import java.util.Scanner;

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
	double runtime = 0;
	
	public static String again() {
		Scanner scanner = Concentration.SCANNER;
		scanner.reset();
		String input = scanner.nextLine();
		
		Concentration.printLineSeperator();
		System.out.print("Should I do it again? ");
		if(!input.equals("")){
			
			
			return input;
		} else if(scanner.hasNextLine()){
			return scanner.nextLine();
			//System.out.println("next  line:" + input);
		}
		return input;
		
	}
	
	public void sight(String[] wordlist){
		for (int x = 0; x < wordlist.length; x++){
			String consciousResult = Consciousness.getColor(wordlist[x]);
			String subconsciousResult = Subconsciousness.getColor(wordlist[x]);
			resolveConflict(consciousResult, subconsciousResult);
			increaseTrueSafety();
			decreaseTrueSafety();
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("| TrueSafety: " + trueSafety + "% |" + " PerceivedSafety: " + perceivedSafety + " | Speed: " + (double)speed/1000 + "sec per Element |");
			System.out.println("---------------------------------------------------------------------------");
		}
		String again = again();
		if(again.equalsIgnoreCase("yes")){
			RandomArrayGen arrayGen = new RandomArrayGen();
			String[] wordlist2 = arrayGen.getStroop();
			sight(wordlist2);
		}
	}	
	
	public void increaseTrueSafety () {
		if(trueSafety < 98){
			trueSafety += 0.5;
		}
	}
	
	public void decreaseTrueSafety () {
		double trueSafetyDecrease = 10*(1/(1+Math.pow(2.71828, (-0.15*10*(speed/100)))*(10/0.005-1))); //10*(1/(1+2,71828^(-0,15*10*x)*(10/0,005-1))) 
		trueSafety = trueSafetyDecrease*10;
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
		double G = (double)(initialSpeed-maxSpeed)/100; //h�chstwert von speed
		System.out.println(G);
		double e = 2.71828; //eulersche zahl
		if(speed>1200){
			speedIncreaseRaw = G*(1/(1+Math.pow(e, (-0.15*G*10))*(G/0.1-1)));
		}else{		
			speedIncreaseRaw = G*(1/(1+Math.pow(e, (-0.15*G*combo))*(G/0.1-1))); //2,5*(1/(1+2,71828^(-0,15*2,5*x)*(2,5/0,1-1))) http://funktion.onlinemathe.de/
		}
		System.out.println("speedIncrease: " + speedIncreaseRaw);
		speedIncreaseRaw = speedIncreaseRaw*100;
		speedIncreaseRaw = speedIncreaseRaw * (perceivedSafety/4+100)/100;
		speed -= speedIncreaseRaw;
		
		
		
	}
	
	public void decreaseSpeed(){
		double speedDecrease = -0.05*Math.pow((double)((speed/100)), 2)+10; // -0,1x^2+10 http://funktion.onlinemathe.de/
		System.out.println("SPEEDDECREASE: " + speedDecrease + "SPEED: " + speed);
		speedDecrease = speedDecrease*100;
		System.out.println("SPEEDDECREASE: " + speedDecrease);
		if(speedDecrease<0){
			speedDecrease=0;
		}
		speed = speed+(int)speedDecrease;
	}
	
	
	public void setWords (String[] words) {
		this.words = words;
	}
	
	public void resolveConflict (String con, String subcon) {
		Random randomGenerator = new Random();
		int randomint = randomGenerator.nextInt(101);
		if (randomint > trueSafety || speed < maxSpeed){//Error-case
			System.out.println("I perceived the word " + subcon + ", although its color was " + con + ".");
			combo = 0;
			runtime += speed;
			runtime += delay;
			decreasePerceivedSafety();
			decreaseSpeed();
			
		} else {//Correct-case
			System.out.println("I perceived the color of the word, which is " + con + ".");
			combo++;
			runtime += speed;
			increasePerceivedSafety();
			increaseSpeed();
			
		}
	}
	
	public boolean rightDecision(){
		return false;
	}
	
	
	
	
}

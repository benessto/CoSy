package cognitionModel;

import java.util.Scanner;

public class Clock {
	private int ticks=0;
	private int maxTime;

	public int getTicks() {
		return ticks;
	}

	public void addTicks() {
		ticks++;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}
	
	public void resetTicks(){
		ticks = 0;
	}
	
	public int getMaxTimeInput(){
		Scanner scanner = Concentration.SCANNER;
		scanner.reset();
		int input = -1;
		
		printLineSeperator();
		System.out.print("Tell me how much time I have: ");
		if(scanner.hasNextInt()){
			input = scanner.nextInt();
			setMaxTime(input);
			return input;
			
		}
		return input;
	}
	public void printLineSeperator(){
		System.out.println("---------------------------------"); 
		/**if(Concentration.SCANNER.hasNextLine()){
			Concentration.SCANNER.nextLine();
		}**/

	}
	public boolean timeUp(){
		if (ticks>=maxTime){
			return true;
		}else{
			return false;
		}
	}

}

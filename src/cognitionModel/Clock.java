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
	
	public int getMaxTimeInput(){
		Scanner scanner = new Scanner(System.in);
		int input = -1;
		
		lineSeperator();
		System.out.print("Tell me how much time I have: ");
		while(scanner.hasNextInt()){
			input = scanner.nextInt();
			setMaxTime(input);
			return input;
			
		}
		scanner.close();
		return input;
	}
	public void lineSeperator(){
		System.out.println("---------------------------------"); 

	}
	public boolean timeUp(){
		if (ticks>=maxTime){
			return true;
		}else{
			return false;
		}
	}

}

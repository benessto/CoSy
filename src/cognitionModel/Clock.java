package cognitionModel;

import java.util.Scanner;

public class Clock {
	private static int ticks=0;
	private static int maxTime;
	private static javax.swing.JLabel label;

	public static int getTicks() {
		return ticks;
	}

	public static void addTicks() {
		ticks++;
	}

	public static int getMaxTime() {
		return maxTime;
	}

	public static void setMaxTime(int maxTime) {
		Clock.maxTime = maxTime;
	}
	
	public static void resetTicks(){
		ticks = 0;
	}
	
	public static int getMaxTimeInput(){
		Scanner scanner = Concentration.SCANNER;
		scanner.reset();
		int input = -1;
		
		Concentration.printLineSeperator();
		System.out.print("Tell me how much time I have: ");
		if(scanner.hasNextInt()){
			input = scanner.nextInt();
			System.out.println(input);
			setMaxTime(input);
			return input;
			
		}
		return input;
	}

	public static boolean timeUp(){
		if (ticks>=maxTime){
			return true;
		}else{
			return false;
		}
	}

}

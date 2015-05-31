package cognitionModel;

import java.util.Scanner;

public class Examiner {

	
	
	public static boolean isTimeUp(){
		return Clock.getTicks() <= Clock.getMaxTime();
	}
	public static String getNewTasks() {
		Clock.getMaxTimeInput(); //Max time in ticks
		Concentration.searchType = getSearchType();
		String taskInput;
		if(Concentration.searchType.equals("Object")){
			taskInput = getTaskInput(); // Get a new task
		}else{
			taskInput = Concentration.searchType;
		}
		String newTask = taskInput; // Get a new task
		Concentration.useVisual = askToUseVisual();	
		return newTask;
	}
	
	public static String getTaskInput() {
		Scanner scanner = Concentration.SCANNER;
		scanner.reset();
		String input = scanner.nextLine();
		
		Concentration.printLineSeperator();
		System.out.print("What should Dörte look for?: ");
		if(!input.equals("")){
			
			
			return input;
		} else if(scanner.hasNextLine()){
			return scanner.nextLine();
			//System.out.println("next  line:" + input);
		}
		return input;
		
	}
	
	public static Boolean askToUseVisual(){
		Scanner scanner = Concentration.SCANNER;
		scanner.reset();
		
		Concentration.printLineSeperator();
		System.out.print("Should Dörte use the visual?(true/false): ");
		if(scanner.hasNextBoolean()){
			return scanner.nextBoolean();
		}
		return true;
		
		
	}
	
	private static String getSearchType(){
		Scanner scanner = Concentration.SCANNER;
		scanner.reset();
		String input = scanner.nextLine();
		
		Concentration.printLineSeperator();
		System.out.print("Should Dörte search for an Object, \n a Colorgroup, a Proximitygroup or a Formgroup?: ");
		if(!input.equals("")){
			
			
			return input;
		} else if(scanner.hasNextLine()){
			return scanner.nextLine();
			//System.out.println("next  line:" + input);
		}
		return input;
	}
}

package cognitionModel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/**Interface.execute(args);
		Scanner scanner = Concentration.SCANNER;
		scanner.reset();
		int input = -1;
		
		System.out.print("Ready? ");
		if(scanner.hasNextInt()){
			input = scanner.nextInt();			
		}**/
		Concentration con = new Concentration();
		con.getNewTasks();
	}

}

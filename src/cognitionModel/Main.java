package cognitionModel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Concentration con = new Concentration();
		Scanner scanner = new Scanner(System.in);
		 
		System.out.print("Eingabe: ");
		String eingabe = scanner.nextLine();
		scanner.close();
		System.out.println("Ausgabe: " + eingabe);
		
		con.start();
	}

}

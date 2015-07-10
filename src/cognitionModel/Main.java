package cognitionModel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Metaknowledge.initializeHash();
		
		Examiner ex = new Examiner();
		for (int i = 0; i < 10; i++)
			ex.askForCategory();
	}

}

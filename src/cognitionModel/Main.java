package cognitionModel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Examiner ex = new Examiner();
		ex.prepareQuestions();
		ex.printTest();
	}

}

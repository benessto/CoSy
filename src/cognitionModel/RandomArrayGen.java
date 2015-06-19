package cognitionModel;

import java.util.Random;

public class RandomArrayGen {
	
	private String[] translate = { "Blue Square", "Blue Triangle", "Blue Circle", "Blue Polygon", "Yellow Square", 
					"Yellow Triangle", "Yellow Circle", "Yellow Polygon", "Green Square", "Green Triangle", 
					"Green Circle", "Green Polygon", "Red Square", "Red Triangle", "Red Circle", "Red Polygon", "leer" };
	private static String[][] testArray = {
		{"leer", "Red Polygon", "Red Polygon", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "Red Polygon", "Red Polygon", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "Red Polygon", "Red Polygon", "hidden", "hidden", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "leer", "leer", "leer", "hidden", "hidden", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "hidden", "hidden", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "hidden", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "hidden", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "hidden", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "hidden", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "Red Polygon", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "hidden", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "hidden", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "Red Polygon", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "Red Polygon", "Red Polygon", "leer", "leer", "leer", "leer", "hidden", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "Red Polygon", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "hidden", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
	};
	private static String[][] testArray2 = {
		{"leer", "Green Polygon", "Blue Square", "Red Square", "leer", "leer", "leer", "Red Square", "Blue Square", "Green Polygon", "leer", "leer", "leer"},
		{"Yellow Triangle", "Blue Polygon", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "Red Polygon", "Blue Polygon", "Yellow Triangle", "leer", "Yellow Circle"},
		{"leer", "Yellow Circle", "leer", "Blue Square", "Blue Square", "Blue Square", "Yellow Polygon", "leer", "leer", "Yellow Circle", "leer", "leer", "Blue Square"},
		{"leer", "leer", "leer", "Blue Square", "Blue Square", "Blue Square", "Green Triangle", "leer", "Blue Square", "leer", "leer", "Blue Polygon", "leer"},
		{"Green Circle", "leer", "leer", "Blue Square", "Blue Square", "Blue Square", "Red Square", "Blue Polygon", "leer", "leer", "Green Circle", "leer", "leer"},
		{"Red Square", "leer", "Blue Triangle", "Red Circle", "leer", "Red Polygon", "leer", "leer", "Red Square", "leer", "Blue Square", "Red Circle", "leer"},
		{"leer", "Blue Polygon", "leer", "Green Circle", "leer", "leer", "Green Triangle", "leer", "leer", "Blue Polygon", "Blue Square", "Green Circle", "leer"},
		{"leer", "leer", "leer", "leer", "leer", "Red Triangle", "leer", "Yellow Square", "leer", "leer", "Blue Square", "leer", "leer"},
		{"leer", "leer", "leer", "Blue Square", "Red Square", "Blue Square", "Green Polygon", "leer", "leer", "leer", "Blue Square", "leer", "Red Square"},
		{"leer", "Yellow Circle", "leer", "leer", "Blue Square", "Red Polygon", "Blue Polygon", "Yellow Triangle", "leer", "Yellow Circle", "Blue Square", "Blue Square", "leer"},
		{"leer", "leer", "leer", "Blue Square", "Green Polygon", "Blue Square", "Red Square", "leer", "leer", "leer", "Red Square", "Blue Square", "Green Polygon"},
		{"leer", "leer", "leer", "Yellow Triangle", "Blue Polygon", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "Red Polygon", "Blue Polygon"}
	};
	
	public String IntegerToString(int a){
		String word = translate[a];
		return word;
	}
	
	public String[][] RandomIntegerArray(){
		Random randominteger = new Random();
		int ysize = 12; //randominteger.nextInt(17)+3;
		int xsize = 13; //randominteger.nextInt(17)+3;
		
		String[][] randomarray = new String[ysize][xsize];
		
		for(int cy = 0; cy < ysize; ++cy){
			for (int cx = 0; cx < xsize; ++cx){
				int nextField = randominteger.nextInt(34);
				if(nextField>=17){
					nextField = 16;
				}
				randomarray[cy][cx] = IntegerToString(nextField);
				System.out.println("Array Feld : "+ cy + " " + cx + " " + testArray2[cy][cx]);
			}
			
		}
		return testArray2;
	}
	
	public String randomTask(){
		Random randominteger = new Random();
		return IntegerToString(randominteger.nextInt(15));
	}

}

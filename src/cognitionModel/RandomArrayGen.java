package cognitionModel;

import java.util.Random;

public class RandomArrayGen {
	
	private String[] translate = { "Blue Square", "Blue Triangle", "Blue Circle", "Blue Polygon", "Yellow Square", 
					"Yellow Triangle", "Yellow Circle", "Yellow Polygon", "Green Square", "Green Triangle", 
					"Green Circle", "Green Polygon", "Red Square", "Red Triangle", "Red Circle", "Red Polygon", "leer" };
	private static String[][] testArray = {
		{"leer", "Red Polygon", "Red Polygon", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "Red Polygon", "Red Polygon", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "Red Polygon", "Red Polygon", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "Red Polygon", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "Red Polygon", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
		{"leer", "leer", "Red Polygon", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer", "leer"},
	};
	
	public String IntegerToString(int a){
		String word = translate[a];
		return word;
	}
	
	public String[][] RandomIntegerArray(){
		Random randominteger = new Random();
		int ysize = 20; //randominteger.nextInt(17)+3;
		int xsize = 20; //randominteger.nextInt(17)+3;
		
		String[][] randomarray = new String[ysize][xsize];
		
		for(int cy = 0; cy < ysize; ++cy){
			for (int cx = 0; cx < xsize; ++cx){
				int nextField = randominteger.nextInt(34);
				if(nextField>=17){
					nextField = 16;
				}
				randomarray[cy][cx] = IntegerToString(nextField);
				System.out.println("Array Feld : "+ cy + " " + cx + " " + testArray[cy][cx]);
			}
			
		}
		return testArray;
	}
	
	public String randomTask(){
		Random randominteger = new Random();
		return IntegerToString(randominteger.nextInt(15));
	}

}

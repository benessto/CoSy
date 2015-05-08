package cognitionModel;

import java.util.Random;

public class RandomArrayGen {
	
	private String[] translate = { "Blue Square", "Blue Triangle", "Blue Circle", "Blue Polygon", "Yellow Square", 
					"Yellow Triangle", "Yellow Circle", "Yellow Polygon", "Green Square", "Green Triangle", 
					"Green Circle", "Green Polygon", "Red Square", "Red Triangle", "Red Circle", "Red Polygon", "leer" };
	
	public String IntegerToString(int a){
		String word = translate[a];
		return word;
	}
	
	public String[][] RandomIntegerArray(){
		Random randominteger = new Random();
		int ysize = randominteger.nextInt(17)+3;
		int xsize = randominteger.nextInt(17)+3;
		
		String[][] randomarray = new String[ysize][xsize];
		
		for(int cy = 0; cy < ysize; ++cy){
			for (int cx = 0; cx < xsize; ++cx){
				int nextField = randominteger.nextInt(34);
				if(nextField>=17){
					nextField = 16;
				}
				randomarray[cy][cx] = IntegerToString(nextField);
				System.out.println("Array Feld : "+ cy + " " + cx + " " + randomarray[cy][cx]);
			}
			
		}
		return randomarray;
	}
	
	public String randomTask(){
		Random randominteger = new Random();
		return IntegerToString(randominteger.nextInt(15));
	}

}

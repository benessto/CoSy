package cognitionModel;

import java.util.HashMap;

public class Concentration {
	
	private String[][] visual;
	private int numberOfSearched=0;
	private Clock clock=new Clock();
	private String searched;
	private Periphery periphery;
	private int maxX;
	private int maxY;
	private HashMap<Integer, Element> elements;		
	
	public Concentration() {
		elements = new HashMap<Integer, Element>();
		periphery = new Periphery();
	}
	
	public void start() {
		RandomArrayGen arrayGen = new RandomArrayGen();
		setVisual(arrayGen.RandomIntegerArray());
		setSearched(arrayGen.randomTask());
		maxX = visual.length;
		maxY = visual[0].length;
		clock.setMaxTime(50); //Max time in ticks
		search(1,1); // Start search
		printResult(); // Print all found elements in console
	}

	public String[][] getVisual() {
		return visual;
	}
	
	public void printResult() {
		System.out.println("Looking for: " + getSearched());
		System.out.println("Number of found elements: " + elements.size());
		System.out.println("Ticks: "+clock.getTicks()+"/"+clock.getMaxTime());
		for (Element element : elements.values()) {
			System.out.println(((Element) element).getColor() + " " + ((Element) element).getForm() + " ,(x)="+((Element) element).getX() + ",(y)=" + ((Element) element).getY());
		}
	}

	public void setVisual(String[][] visual) {
		this.visual = visual;
		maxX = visual.length;
		maxY = visual[0].length;
	}
	
	private void setCluster(int i, int j){
		String[][] cluster= new String[3][3];
		for(int h=0;h<3;h++){
			for(int k=0;k<3;k++){
				if(i-1+h>=0 && i-1+h<maxX  &&  j-1+k>=0 && j-1+k<maxY){
					cluster[h][k]=visual[i-1+h][j-1+k];
					int test1 = i-1+h;
					int test2 = j-1+k;
					System.out.println("Cluster Feld "+ h + k +" : " + cluster[h][k] + ",ArrayFeld " + test1 +  " " + test2);
				}
			}
		}
		periphery.setCluster(cluster);
	}
	
	private boolean search(int i, int j){
		boolean allSearched = false;
		if(clock.getTicks()<=clock.getMaxTime()){ // Still have time?
			System.out.println("Looking for : " + searched + ", Found:  " + visual[i][j] + " at tick " + clock.getTicks());
			//befindet sich in dem gegebenen Feld das gesuchte Objekt?
			if(visual[i][j].equals(searched)){
				System.out.println("Found an element at"+i+","+j);
				setNumberOfSearched(getNumberOfSearched() + 1);
				String[] colorForm = searched.split(" ");
				Element element = new Element(i,j, colorForm[0], colorForm[1]);
				if(!elements.containsKey(element.getKoordinates())){
					elements.put(element.getKoordinates(), element);
				}
			}
			clock.addTicks();
			//Der Peripherie den aktuellen Cluster geben
			setCluster(i, j);
			//ergebniss der peripherie abfragen
			int hint = periphery.search();
			//wenn etwas gefunden
			if(hint!=5){
				//System.out.println("Start searchAround i="+i+", j="+j + ", hint ="+hint);
				allSearched = searchAround(i, j, hint, 0, 0);
				
			//wenn nichts gefunden
			}else{
				if(i+3<maxX){
					System.out.println("search if(i+3<=maxX)");
					allSearched = search(i+3,j);
				}
				else{
					if(i+2<maxX){
						searchThree(i+1, j);
					}
					if(j+3<maxY){
						System.out.println("search if(j+3<=maxY)");
						allSearched = search(1, j+3);
					}else{
						return true;
					}
				}
			}
		}
		return allSearched;
	}
	
	
	private boolean searchAround(int i, int j, int direction, int alreadytried, int rowsTried){
		System.out.println("Start searchAround i="+i+", j="+j + ", hint ="+direction);
		if(clock.getTicks()<=clock.getMaxTime()){
			if(i+direction<maxX && j-1>=0 && visual[i+direction][j-1].equals(searched)){
				System.out.println("searchArround1: Found an element");
				String[] colorForm = searched.split(" ");
				Element element = new Element(i+direction,j-1, colorForm[0], colorForm[1]);
				if(!elements.containsKey(element.getKoordinates())){
					elements.put(element.getKoordinates(), element);
				}
			}
			if(i+direction<maxX && visual[i+direction][j].equals(searched)){
				System.out.println("searchArround2: Found an element");
				String[] colorForm = searched.split(" ");
				Element element = new Element(i+direction,j, colorForm[0], colorForm[1]);
				if(!elements.containsKey(element.getKoordinates())){
					elements.put(element.getKoordinates(), element);
				}
			}
			if(i+direction<maxX && j+1<maxY && visual[i+direction][j+1].equals(searched)){
				System.out.println("searchArround3: Found an element");
				String[] colorForm = searched.split(" ");
				Element element = new Element(i+direction,j+1, colorForm[0], colorForm[1]);
				if(!elements.containsKey(element.getKoordinates())){
					elements.put(element.getKoordinates(), element);
				}
			}
		
			clock.addTicks();
			int toIgnore=0;
			if(direction<0){
				toIgnore=2 + rowsTried;
			}else if(direction==0){
				toIgnore=3 + rowsTried;
			}else if(direction==1){
				toIgnore=4 + rowsTried;
			}
			int hint = periphery.searchAround(alreadytried+3);
			if(hint!=5){
				System.out.println("Ignore: " + toIgnore +" "+ rowsTried);
				searchAround(i,  j, hint, alreadytried+3, toIgnore+rowsTried);
			}else{
				if(i+3<maxX){
					System.out.println("searchAround if(i+3<=maxX) " + i + " " + j);
					return search(i+3,j);
				}
				else{
					if(i+2<maxX){
						searchThree(i+1, j);
					}
					if(j+3<maxY){
						System.out.println("searchAround if(j+3<=maxY)");
						return search(1, j+3);
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Durchsucht die 3 übereinander liegenden Felder rechts neben dem angegebenen Feld
	 * @param i x-Koordinate des angegebenen Felds
	 * @param j y-Koordinate des angegebenen Felds
	 */
	private void searchThree(int i, int j){
		if(clock.getTicks()<=clock.getMaxTime()){
			System.out.println(i + j + maxX + maxY);
			if(j-1>=0 && i+1<maxX && visual[i+1][j-1].equals(searched)){
				setNumberOfSearched(getNumberOfSearched() + 1);
				String[] colorForm = searched.split(" ");
				Element element = new Element(i+1,j-1, colorForm[0], colorForm[1]);
				if(!elements.containsKey(element.getKoordinates())){
					elements.put(element.getKoordinates(), element);
				}
			}
			if(i+1<maxX && visual[i+1][j].equals(searched)){
				setNumberOfSearched(getNumberOfSearched() + 1);
				String[] colorForm = searched.split(" ");
				Element element = new Element(i+1,j, colorForm[0], colorForm[1]);
				if(!elements.containsKey(element.getKoordinates())){
					elements.put(element.getKoordinates(), element);
				}
			}
			if(j+1<maxY && i+1<maxX && visual[i+1][j+1].equals(searched)){
				setNumberOfSearched(getNumberOfSearched() + 1);
				String[] colorForm = searched.split(" ");
				Element element = new Element(i+1,j+1, colorForm[0], colorForm[1]);
				if(!elements.containsKey(element.getKoordinates())){
					elements.put(element.getKoordinates(), element);
				}
			}
			clock.addTicks();
		}
	}
	
	public String getSearched(){
		return searched;
		
	}
	public void setSearched(String searched){
		this.searched = searched;
		String[] searchedColor = searched.split(" ");
		periphery.setSearchedColor(searchedColor[0]);
	}

	public int getNumberOfSearched() {
		return numberOfSearched;
	}

	public void setNumberOfSearched(int numberOfSearched) {
		this.numberOfSearched = numberOfSearched;
	}
	

}

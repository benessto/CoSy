package cognitionModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Concentration {
	
	public static String[][] visual;
	public static Scanner SCANNER = new Scanner(System.in); 
	public static int groupID = 1;
	
	private int numberOfSearched = 0;
	private String task;
	private Periphery periphery;
	private int maxX;
	private int maxY;
	private static HashMap<Integer, Element> elements;	
	private HashMap<Integer, Element[]> groups;	
	private Memory  memory;
	private Boolean useVisual = true;
	private int sum;
	private boolean canAnswer = true;
	public static String searchType;
	
	public Concentration() {
		elements = new HashMap<Integer, Element>();
		groups = new HashMap<Integer, Element[]>();
		periphery = new Periphery();
		memory = new Memory();
		RandomArrayGen arrayGen = new RandomArrayGen();
		setVisual(arrayGen.RandomIntegerArray());	
		maxX = visual.length;
		maxY = visual[0].length;
	}
	public void memorize(){
		if(!memory.hasMemory(task)){
			memory.memorize(task, elements.size());
		}
	}
	
	public void startTask() {
		elements = new HashMap<Integer, Element>(); // Empty HashMap
		Clock.resetTicks();
		if(!memory.hasMemory(task)&&useVisual){
			search(1,1); // Start search
			sum = sum + elements.size();
			printResult(); // Print all found elements in console
		}else if(memory.hasMemory(task)){
			sum = sum + memory.getMemory(task);
			//printResultFromMemory();
		}else{
			//printLineSeperator();
			//System.out.println("I can't answer that, you schould let me see the visual");
			canAnswer = false;
		}
		
		if (Clock.getTicks() <= Clock.getMaxTime() && useVisual){
			memorize();
		}
	}
	
	public void getNewTasks() {
		Clock.getMaxTimeInput(); //Max time in ticks
		searchType = getSearchType();
		String newTask = getTaskInput(); // Get a new task
		useVisual = askToUseVisual();
		sum = 0;
		splitTasks(newTask);
	}
	
	private void splitTasks (String task) {
		String[] tasks = task.split(", ");
		
		for(int i=0; i<tasks.length;i++){
			if(tasks[i] != null) {
				//System.out.println("Splittask nr."+i);
				setSearched(tasks[i]);
				startTask();
			}
		}
		if(canAnswer){
			printLineSeperator();
			System.out.println("All in all there are " + sum + " of the searched forms.");
		}else{
			printLineSeperator();
			System.out.println("I can't answer that, you should let me see the visual");
		}
		canAnswer = true;
		getNewTasks();
	}
	
	
	public Boolean askToUseVisual(){
		Scanner scanner = SCANNER;
		scanner.reset();
		
		printLineSeperator();
		System.out.print("Should I use the visual?(true/false): ");
		if(scanner.hasNextBoolean()){
			return scanner.nextBoolean();
		}
		return true;
		
		
	}
	
	public String getTaskInput() {
		Scanner scanner = SCANNER;
		scanner.reset();
		String input = scanner.nextLine();
		
		printLineSeperator();
		System.out.print("What should I look for?: ");
		if(!input.equals("")){
			
			
			return input;
		} else if(scanner.hasNextLine()){
			return scanner.nextLine();
			//System.out.println("next  line:" + input);
		}
		return input;
		
	}
	
	private String getSearchType(){
		Scanner scanner = SCANNER;
		scanner.reset();
		String input = scanner.nextLine();
		
		printLineSeperator();
		System.out.print("Should I search for an Object, a Colorgroup, a Proximitygroup or a Formgroup?: ");
		if(!input.equals("")){
			
			
			return input;
		} else if(scanner.hasNextLine()){
			return scanner.nextLine();
			//System.out.println("next  line:" + input);
		}
		return input;
	}
	
	public String[][] getVisual() {
		return visual;
	}
	
	public void printResult() {
		printLineSeperator();
		System.out.println("Number of found elements: " + elements.size());
		System.out.println("Ticks: "+Clock.getTicks()+"/"+Clock.getMaxTime());
		for (Element element : elements.values()) {
			System.out.println(((Element) element).getColor() + " " + ((Element) element).getForm() + ", (x)="+((Element) element).getX() + ", (y)=" + ((Element) element).getY());
		}
		printLineSeperator();
		for (Integer groupID : groups.keySet()) {
			System.out.println("Group ID: " + groupID);
			//for (Element[] element : groups.values()) {
				//if (element[0].getGroupID() == groupID) {
					Element[] elementArr = groups.get(groupID);
					for (int i = 0; i < elementArr.length && elementArr[i] != null; i++) {
						System.out.println ("    "+elementArr[i].getColor() + " " + elementArr[i].getForm() + " ,(x)=" + (elementArr[i].getX() + ", (y)=" + elementArr[i].getY()));
					}
					//}
			//}
		}
	}
	
	public void printResultFromMemory() {
		printLineSeperator();
		System.out.println("I remember! I found " + memory.getMemory(task) + " " + task +"(s) the last time I checked.");
	}
	
	public static void printLineSeperator(){
		System.out.println("---------------------------------"); 
		//if(SCANNER.hasNextLine()){
		//	SCANNER.nextLine();
		//}

	}

	public void setVisual(String[][] visual) {
		Concentration.visual = visual;
		maxX = visual.length;
		maxY = visual[0].length;
	}
	
	private void setCluster(int i, int j){
		String[][] cluster= new String[3][3];
		ArrayList<String> clusterText = new ArrayList<String>();
		//boolean found = false;
		
		for(int h=0;h<3;h++){
			for(int k=0;k<3;k++){
				if(i-1+h>=0 && i-1+h<maxX  &&  j-1+k>=0 && j-1+k<maxY){
					cluster[h][k]=visual[i-1+h][j-1+k];
					int test1 = i-1+h;
					int test2 = j-1+k;
					clusterText.add("Cluster Feld "+ h + k +" : " + cluster[h][k] + ",ArrayFeld " + test1 +  " " + test2);
					if (visual[i-1+h][j-1+k].equals(task)){
						//found = true;
						addElement(i-1+h, j-1+k);
					}
				}
			}
		}
		/**if (found) {
			printLineSeperator();
			for (String clusterString : clusterText) {
				System.out.println(clusterString);
			}
		}**/
		periphery.setCluster(cluster);
	}
	
	private void addElement(int x, int y) {
		setNumberOfSearched(getNumberOfSearched() + 1);
		String[] colorForm = task.split(" ");
		Element element = null;
		if (!elements.containsKey(x*100+y)) {
			element = new Element(x,y, colorForm[0], colorForm[1]);
		} else {
			element = elements.get(x*100+y);
		}
		
		if (!visualRoutine1(x,y, element)){
			visualRoutine2(x,y,element);
		}
	}
	
	private boolean visualRoutine1 (int x, int y, Element element) {
			if (element.getGroupID() != 0) { //Already has a group?
				return true;
			}
			
			boolean foundGroup = VisualRoutines.FIND_GROUP(element);
			elements.put(element.getKoordinates(), element);
			HashMap<Integer, Element> group = VisualRoutines.GROUP;
		
		
			if (foundGroup) {
					
				Element[] elementArray = new Element[group.size()];
				
				int i = 0;
				for (Element e : group.values()) {
					if (/*!elements.containsKey(e.getKoordinates()) &&*/e != null && i < elementArray.length) {
						elements.put(e.getKoordinates(), e);
						elementArray[i] = e;
						System.out.println("New elementArray: "+elementArray[i].getElementAsString());
					}
					i++;
				}
				
					
				
				boolean duplicate = false;
				for (Element[] eArray : groups.values()) {
					for (int f = 0; f < elementArray.length; f++) {
						for (int g = 0; g < eArray.length; g++) {
							if (elementArray[f].getKoordinates() == eArray[g].getKoordinates()) {
								System.out.println("element: "+ element.getElementAsString());
								System.out.println("eArray: "+ elementArray[f].getElementAsString());
								System.out.println("There is "+elements.get(elementArray[f].getKoordinates()).getElementAsString());
								duplicate = true;
								break;
							}
						}
					}
				}
				
				if (!duplicate) {
					groups.put(groupID, elementArray);
					groupID++;
				}
				
				return foundGroup;
		}
		return false;
	}
	
	
	private boolean visualRoutine2(int x, int y, Element element){
			if(VisualRoutine2.findGroup(element)){
				element.setGroupID(groupID);
				
				Element[] elementArray = new Element[VisualRoutine2.group.size()];
				elementArray[0] = element;
				int i = 1;
				
				for(Element e : VisualRoutine2.group){
					if(!elements.containsKey(e.getKoordinates())&& i < elementArray.length){
						elements.put(e.getKoordinates(), e);
						e.setGroupID(groupID);
				    	elementArray[i] = e;
				    	i++;
				    }
					//System.out.println("Element: " + e.getColorAndForm() + " " + e.getKoordinates());
				}
				groups.put(groupID, elementArray);
				groupID++;
				return true;
			}
		
		return false;
	}
	
	
	private boolean searchForGroups(int i, int j){
		boolean allSearched = false;
		if(Clock.getTicks()<=Clock.getMaxTime()){ // Still have time?
			String[] array = visual[i][j].split(" ");
			Element element = new Element(i, j, array[0], array[1]);
			visualRoutine1(i, j, element);
			
			//Der Peripherie den aktuellen Cluster geben
			setCluster(i, j);
			//ergebniss der peripherie abfragen
			int hint = periphery.searchGroup();
			//wenn etwas gefunden
			if(hint!=-1){
				int x = (hint-(hint%100))/100;
				int y = hint%100;
				//System.out.println("Start searchAround i="+i+", j="+j + ", hint ="+hint);
				allSearched = searchAroundGroups(x, y);
				
			//wenn nichts gefunden
			}
		}
		return allSearched;
	}
	
	private boolean searchAroundGroups(int x, int y){
		
		return false;
	}
	
	private boolean search(int i, int j){
		boolean allSearched = false;
		if(Clock.getTicks()<=Clock.getMaxTime()){ // Still have time?
			//System.out.println("Looking for : " + task + ", Found:  " + visual[i][j] + " at tick " + Clock.getTicks());
			//befindet sich in dem gegebenen Feld das gesuchte Objekt?
			if (!elements.containsKey(i*100+j)) {
				if(visual[i][j].equals(task)){
					addElement(i,j);
				}
				Clock.addTicks();
			}
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
					//System.out.println("search if(i+3<=maxX)");
					allSearched = search(i+3,j);
				}
				else{
					if(i+2<maxX){
						searchThree(i+1, j);
					}
					if(j+3<maxY){
						//System.out.println("search if(j+3<=maxY)");
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
		//System.out.println("Start searchAround i="+i+", j="+j + ", hint ="+direction);
		if(Clock.getTicks()<=Clock.getMaxTime()){
			int found = 0;
			
			if (!elements.containsKey((i+direction)*100+j-1)) {
				if(i+direction<maxX && j-1>=0 && visual[i+direction][j-1].equals(task)){
					addElement(i+direction, j-1);
					found++;
				}
			}
			
			if (!elements.containsKey((i+direction)*100+j)) {
				if(i+direction<maxX && visual[i+direction][j].equals(task)){
					addElement(i+direction, j);
					found++;
				}
			}
			if (!elements.containsKey((i+direction)*100+j+1)) {
				if(i+direction<maxX && j+1<maxY && visual[i+direction][j+1].equals(task)){
					addElement(i+direction,j+1);
					found++;
				}
				
			}
			
			if (found > 0) {
				Clock.addTicks();
			}
			
			
			int toIgnore=0;
			if(direction<0){
				toIgnore=2 + rowsTried;
			}else if(direction==0){
				toIgnore=3 + rowsTried;
			}else if(direction==1){
				toIgnore=4 + rowsTried;
			}
			int hint = periphery.searchAround(alreadytried+3);
			if(hint!=50){
//				System.out.println("Ignore: " + toIgnore +" "+ rowsTried);
				searchAround(i,  j, hint, alreadytried+3, toIgnore+rowsTried);
			}else{
				if(i+3<maxX){
//					System.out.println("searchAround if(i+3<=maxX) " + i + " " + j);
					return search(i+3,j);
				}
				else{
					if(i+2<maxX){
						searchThree(i+1, j);
					}
					if(j+3<maxY){
//						System.out.println("searchAround if(j+3<=maxY)");
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
		if(Clock.getTicks()<=Clock.getMaxTime()){
			
			int found = 0;
			
			if (elements.containsKey((i+1)*100+j-1)) {
				if(j-1>=0 && i+1<maxX && visual[i+1][j-1].equals(task)){
					addElement(i+1, j-1);
					found++;
				}
			}
			
			if (elements.containsKey((i+1)*100+j)) {
				if(i+1<maxX && visual[i+1][j].equals(task)){
					addElement(i+1, j);
					found++;
				}
			}
			
			if (elements.containsKey((i+1)*100+j+1)) {
				if(j+1<maxY && i+1<maxX && visual[i+1][j+1].equals(task)){
					addElement(i+1, j+1);
					found++;
				}
			}
			
			if (found > 0) {
				Clock.addTicks();
			}
		}
	}
	
	public String getSearched(){
		return task;
		
	}
	public void setSearched(String task){
		this.task = task;
		String[] searchedColor = task.split(" ");
		periphery.setSearchedColor(searchedColor[0]);
	}

	public int getNumberOfSearched() {
		return numberOfSearched;
	}

	public void setNumberOfSearched(int numberOfSearched) {
		this.numberOfSearched = numberOfSearched;
	}

	public static HashMap<Integer, Element> getElements(){
		return elements;
	}

}

package cognitionModel;

import java.util.ArrayList;

public class VisualRoutines {
	ArrayList<Element> group;
	String[][] visual;
	
	public VisualRoutines(String[][] visual){
		this.visual = visual;
	}
	
	public ArrayList<Element> findGroup(Element element){
		group = new ArrayList<Element>();
		findConnection(element);
		return group;
	}
	private boolean findConnection(Element element){
		//To-DO
		return false;
	}

}

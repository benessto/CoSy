package cognitionModel;

import java.util.ArrayList;
import java.util.HashMap;

public class VisualRoutines {
	HashMap<Integer, Element> group;
	String[][] visual;
	
	public VisualRoutines(String[][] visual){
		this.visual = visual;
	}
	
	public HashMap<Integer, Element> findGroup(Element element){
		group = new HashMap<Integer, Element>();
		findConnection (element, 'X', -1);
		findConnection (element, 'X', 1);
		findConnection (element, 'Y', -1);
		findConnection (element, 'Y', 1);
		return group;
	}
	
	private void findConnection(Element element, char XY, int direction) {
		if(!group.containsValue(element)){
			group.put(element.getKoordinates(), element);
			if (XY == 'X') {
				if(element.getX()+direction>=0&&element.getX()+direction<visual.length){
					String[] colorForm = visual[element.getX()+direction][element.getY()].split(" ");
					Element neighbor = new Element(element.getX()+direction, element.getY(), colorForm[0], colorForm[1]);
					if(neighbor.equals(element.getColor() + " " +element.getForm())){
						element.addConnections();
						neighbor.addConnections();
						findConnection(neighbor, 'X', direction);
						findConnection(neighbor, 'Y', -1);
						findConnection(neighbor, 'Y', 1);
					}
				}
			}
			
			if (XY == 'Y') {
				if(element.getY()+direction>=0&&element.getY()+direction<visual[0].length){
					String[] colorForm = visual[element.getX()][element.getY()+direction].split(" ");
					Element neighbor = new Element(element.getX(), element.getY()+direction, colorForm[0], colorForm[1]);
					if(neighbor.equals(element.getColor() + " " +element.getForm())){
						element.addConnections();
						neighbor.addConnections();
						findConnection(neighbor, 'Y', direction);
						findConnection(neighbor, 'X', -1);
						findConnection(neighbor, 'X', 1);
					}
				}
			}
		}
		
	}

}

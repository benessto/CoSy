package cognitionModel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class VisualRoutines {
	public static HashMap<Integer, Element> GROUP = new HashMap<Integer, Element>();
	
	public static HashMap<Integer, Element> FIND_GROUP(Element element){
		GROUP.clear();
		
		FIND_CONNECTION (element, 'X', -1);
		FIND_CONNECTION (element, 'Y', -1);
		FIND_CONNECTION (element, 'Y', 1);
		FIND_CONNECTION (element, 'X', 1);
		
		for(Iterator<Map.Entry<Integer, Element>> it = GROUP.entrySet().iterator(); it.hasNext(); ) {
	      Map.Entry<Integer, Element> entry = it.next();
	      if ( ((Element) entry.getValue()).getConnections() < 2 ) { //Remove elements that have less than 2 connections
	        it.remove();
	        //System.out.println("Removing: "+((Element) entry.getValue()).getColorAndForm() +", connections: "+((Element) entry.getValue()).getConnections());
	      }
	    }
		
		return GROUP;
	}
	
	private static void FIND_CONNECTION(Element element, char XY, int direction) {
		GROUP.put(element.getKoordinates(), element);
		if (XY == 'X') {
			if(element.getX()+direction >=0 && element.getX() + direction<Concentration.visual.length){
				String[] colorForm = Concentration.visual[element.getX()+direction][element.getY()].split(" ");
				if (colorForm.length > 1) {
					Element neighbor = new Element(element.getX()+direction, element.getY(), colorForm[0], colorForm[1]);
					if(neighbor.getColorAndForm().equals(element.getColorAndForm())){
						element.addConnections();
						neighbor.addConnections();
						FIND_CONNECTION(neighbor, 'Y', -1);
						FIND_CONNECTION(neighbor, 'Y', 1);
						FIND_CONNECTION(neighbor, 'X', direction);
					}
				}
			}
		}
		
		if (XY == 'Y') {
			if(element.getY()+direction>=0&&element.getY()+direction<Concentration.visual[0].length){
				String[] colorForm = Concentration.visual[element.getX()][element.getY()+direction].split(" ");
				if (colorForm.length > 1) {
					Element neighbor = new Element(element.getX(), element.getY()+direction, colorForm[0], colorForm[1]);
					if(neighbor.equals(element.getColor() + " " +element.getForm())){
						element.addConnections();
						neighbor.addConnections();
						FIND_CONNECTION(neighbor, 'X', -1);
						FIND_CONNECTION(neighbor, 'X', 1);
						FIND_CONNECTION(neighbor, 'Y', direction);
					}
				}
			}
		}
		
		Concentration.printLineSeperator();
	}

}

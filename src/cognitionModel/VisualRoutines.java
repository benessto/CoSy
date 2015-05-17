package cognitionModel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class VisualRoutines {
	public static HashMap<Integer, Element> GROUP = new HashMap<Integer, Element>();
	
	public static boolean FIND_GROUP(Element element){
		GROUP.clear();
		GROUP.put(element.getKoordinates(), element);
		FIND_CONNECTION (element, 'Y', -1);
		FIND_CONNECTION (element, 'X', 1);
		FIND_CONNECTION (element, 'Y', 1);
		FIND_CONNECTION (element, 'X', -1);
		
		for(Iterator<Map.Entry<Integer, Element>> it = GROUP.entrySet().iterator(); it.hasNext(); ) {
	      Map.Entry<Integer, Element> entry = it.next();
	      System.out.println(((Element) entry.getValue()).getColorAndForm() + "("+ ((Element) entry.getValue()).getX()+"|"+ ((Element) entry.getValue()).getY()+ "), Connections:" + ((Element) entry.getValue()).getConnections());
	      if ( ((Element) entry.getValue()).getConnections() < 2 //Remove elements that have less than 2 connections
	    		  ||((Element) entry.getValue()).getX()>element.getX()+2
	    		  ||((Element) entry.getValue()).getX()<element.getX()-2
	    		  ||((Element) entry.getValue()).getY()>element.getY()+2
	    		  ||((Element) entry.getValue()).getY()<element.getY()-2) { 
	        it.remove();
	        System.out.println("Removing: "+((Element) entry.getValue()).getElementAsString() +", connections: "+((Element) entry.getValue()).getConnections());
	      } else {
	    	  System.out.println(entry.getValue().getElementAsString()+" has groupID " + entry.getValue().getGroupID());
	    	  System.out.println("Set ID to "+Concentration.groupID);
	    	  entry.getValue().setGroupID(Concentration.groupID);
	      }
	    }
		
		if (GROUP.size() > 2) {
			return true;
		}
		
		return false;
	}
	
	private static void FIND_CONNECTION(Element element, char XY, int direction) {
		
		
		if (XY == 'X') {
			if(element.getX()+direction >= 0 && element.getX() + direction < Concentration.visual.length){
				String[] colorForm = Concentration.visual[element.getX()+direction][element.getY()].split(" ");
				if (colorForm.length > 1) {
					Element neighbor = new Element(element.getX()+direction, element.getY(), colorForm[0], colorForm[1]);
					if(neighbor.getColorAndForm().equals(element.getColorAndForm()) && !GROUP.containsKey(neighbor.getKoordinates())){
						GROUP.put(neighbor.getKoordinates(), neighbor);
						GROUP.get(element.getKoordinates()).addConnections();
						GROUP.get(neighbor.getKoordinates()).addConnections();
						System.out.println("Found connection X between"+" Element("+GROUP.get(element.getKoordinates()).getX()+"|"+GROUP.get(element.getKoordinates()).getY()+")"+" and "+GROUP.get(neighbor.getKoordinates()).getX()+"|"+GROUP.get(neighbor.getKoordinates()).getY());
						FIND_CONNECTION(neighbor, 'Y', -1);
						FIND_CONNECTION(neighbor, 'Y', 1);
						FIND_CONNECTION(neighbor, 'X', direction);
					} else if (neighbor.getColorAndForm().equals(element.getColorAndForm())) {
						GROUP.get(element.getKoordinates()).addConnections();
						//GROUP.get(neighbor.getKoordinates()).addConnections();
						System.out.println("Found connection X between"+" Element("+GROUP.get(element.getKoordinates()).getX()+"|"+GROUP.get(element.getKoordinates()).getY()+")"+" and "+GROUP.get(neighbor.getKoordinates()).getX()+"|"+GROUP.get(neighbor.getKoordinates()).getY());
					}
				}
			}
		}
		
		if (XY == 'Y') {
			if(element.getY()+direction>=0&&element.getY()+direction<Concentration.visual[0].length){
				String[] colorForm = Concentration.visual[element.getX()][element.getY()+direction].split(" ");
				if (colorForm.length > 1) {
					Element neighbor = new Element(element.getX(), element.getY()+direction, colorForm[0], colorForm[1]);
					if(neighbor.getColorAndForm().equals(element.getColorAndForm())  && !GROUP.containsKey(neighbor.getKoordinates())){
						GROUP.put(neighbor.getKoordinates(), neighbor);
						GROUP.get(element.getKoordinates()).addConnections();
						GROUP.get(neighbor.getKoordinates()).addConnections();
						System.out.println("Found connection Y between"+" Element("+GROUP.get(element.getKoordinates()).getX()+"|"+GROUP.get(element.getKoordinates()).getY()+")"+" and "+GROUP.get(neighbor.getKoordinates()).getX()+"|"+GROUP.get(neighbor.getKoordinates()).getY());
						FIND_CONNECTION(neighbor, 'X', -1);
						FIND_CONNECTION(neighbor, 'X', 1);
						FIND_CONNECTION(neighbor, 'Y', direction);
					} else if (neighbor.getColorAndForm().equals(element.getColorAndForm())) {
						GROUP.get(element.getKoordinates()).addConnections();
						//GROUP.get(neighbor.getKoordinates()).addConnections();
						System.out.println("Found connection Y between"+" Element("+GROUP.get(element.getKoordinates()).getX()+"|"+GROUP.get(element.getKoordinates()).getY()+")"+" and "+GROUP.get(neighbor.getKoordinates()).getX()+"|"+GROUP.get(neighbor.getKoordinates()).getY());
					}
				}
			}
		}
	return;
		//Concentration.printLineSeperator();
	}

}

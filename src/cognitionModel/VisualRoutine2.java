package cognitionModel;

import java.util.ArrayList;

public class VisualRoutine2 {

	static ArrayList<Element> group;
	
	public static boolean findGroup(Element element){
		group=new ArrayList<Element>();
		boolean isGroup = false;
		int x = element.getX();
		int y = element.getY();
		group.add(element);
		if(x+1<Concentration.visual.length&&x-1>=0&&x+1<Concentration.visual.length&&x+1>=0&&y-1>=0&&y+1<Concentration.visual[0].length&&y+1>=0&&y+1<Concentration.visual[0].length)
		{
			if(Concentration.visual[x-1][y-1].equals(element.getColorAndForm())){
				if(Concentration.visual[x+1][y+1].equals(element.getColorAndForm())){
					if(Concentration.visual[x+1][y-1].equals(element.getColorAndForm())){
						if(Concentration.visual[x-1][y+1].equals(element.getColorAndForm())){
							Element element1 = new Element(element.getX()-1, element.getY()-1, element.getColor(), element.getForm());
							group.add(element1);
							Element element2 = new Element(element.getX()+1, element.getY()+1, element.getColor(), element.getForm());
							group.add(element2);
							Element element3 = new Element(element.getX()+1, element.getY()-1, element.getColor(), element.getForm());
							group.add(element3);
							Element element4 = new Element(element.getX()-1, element.getY()+1, element.getColor(), element.getForm());
							group.add(element4);
							isGroup = true;
						}
					}
				}
			}
		}
		if(x+2<Concentration.visual.length&&x>=0&&y>=0&&y+2<Concentration.visual[0].length)
		{
			if(Concentration.visual[x][y+2].equals(element.getColorAndForm())){
				if(Concentration.visual[x+1][y+1].equals(element.getColorAndForm())){
					if(Concentration.visual[x+2][y+2].equals(element.getColorAndForm())){
						if(Concentration.visual[x+2][y].equals(element.getColorAndForm())){
							Element element1 = new Element(element.getX(), element.getY()+2, element.getColor(), element.getForm());
							group.add(element1);
							Element element2 = new Element(element.getX()+1, element.getY()+1, element.getColor(), element.getForm());
							group.add(element2);
							Element element3 = new Element(element.getX()+2, element.getY()+2, element.getColor(), element.getForm());
							group.add(element3);
							Element element4 = new Element(element.getX()+2, element.getY(), element.getColor(), element.getForm());
							group.add(element4);
							isGroup = true;
						}
					}
				}
			}
		}
		if(x<Concentration.visual.length&&x-2>=0&&y>=0&&y+2<Concentration.visual[0].length)
		{
			if(Concentration.visual[x-2][y].equals(element.getColorAndForm())){
				if(Concentration.visual[x-2][y+2].equals(element.getColorAndForm())){
					if(Concentration.visual[x][y+2].equals(element.getColorAndForm())){
						if(Concentration.visual[x-1][y+1].equals(element.getColorAndForm())){
							Element element1 = new Element(element.getX()-2, element.getY(), element.getColor(), element.getForm());
							group.add(element1);
							Element element2 = new Element(element.getX()-2, element.getY()+2, element.getColor(), element.getForm());
							group.add(element2);
							Element element3 = new Element(element.getX(), element.getY()+2, element.getColor(), element.getForm());
							group.add(element3);
							Element element4 = new Element(element.getX()-1, element.getY()+1, element.getColor(), element.getForm());
							group.add(element4);
							isGroup = true;
						}
					}
				}
			}
		}
		if(x+2<Concentration.visual.length&&x-1>=0&&y-2>=0&&y<Concentration.visual[0].length)
		{
			if(Concentration.visual[x-1][y-1].equals(element.getColorAndForm())){
				if(Concentration.visual[x][y-2].equals(element.getColorAndForm())){
					if(Concentration.visual[x+2][y-2].equals(element.getColorAndForm())){
						if(Concentration.visual[x+2][y].equals(element.getColorAndForm())){
							Element element1 = new Element(element.getX()-1, element.getY()-1, element.getColor(), element.getForm());
							group.add(element1);
							Element element2 = new Element(element.getX(), element.getY()-2, element.getColor(), element.getForm());
							group.add(element2);
							Element element3 = new Element(element.getX()+2, element.getY()-2, element.getColor(), element.getForm());
							group.add(element3);
							Element element4 = new Element(element.getX()+2, element.getY(), element.getColor(), element.getForm());
							group.add(element4);
							isGroup = true;
						}
					}
				}
			}
		}
		if(x<Concentration.visual.length&&x-2>=0&&y-2>=0&&y<Concentration.visual[0].length)
		{
			if(Concentration.visual[x-1][y-1].equals(element.getColorAndForm())){
				if(Concentration.visual[x-2][y-2].equals(element.getColorAndForm())){
					if(Concentration.visual[x][y-2].equals(element.getColorAndForm())){
						if(Concentration.visual[x-2][y].equals(element.getColorAndForm())){
							Element element1 = new Element(element.getX()-1, element.getY()-1, element.getColor(), element.getForm());
							group.add(element1);
							Element element2 = new Element(element.getX()-2, element.getY()-2, element.getColor(), element.getForm());
							group.add(element2);
							Element element3 = new Element(element.getX(), element.getY()-2, element.getColor(), element.getForm());
							group.add(element3);
							Element element4 = new Element(element.getX()-2, element.getY(), element.getColor(), element.getForm());
							group.add(element4);
							isGroup = true;
						}
					}
				}
			}
		}
		return isGroup;
	}
}

package cognitionModel;

public class Element {
	private int x;
	private int y;
	private int koordinates;
	private String color;
	private String form;
	private int connections = 0;
	private int colorGroupID = 0;
	private int proximityGroupID = 0;
	private int formGroupID = 0;
	private boolean hidden = false;
	
	public Element(int x, int y, String color, String form, boolean hidden){
		setX(x);
		setY(y);
		setKoordinates(x, y);
		setColor(color);
		setForm(form);
		setHidden(hidden);
	}
	
	public String getColorAndForm() {
		return color+" "+form;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setKoordinates(int x, int y){
		koordinates = x*100+y;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public int getKoordinates() {
		return koordinates;
	}

	public int getConnections() {
		return connections;
	}

	public void addConnections() {
		connections++;
	}

	public int getGroupID() {
		switch(Concentration.searchType){
		case "Proximitygroup": return proximityGroupID;
		case "Colorgroup": return colorGroupID;
		case "Formgroup": return formGroupID;
		case "Object" : return proximityGroupID;
		default: return 0;
		}
	}

	public void setGroupID(int groupID) {
		switch(Concentration.searchType){
		case "Proximitygroup": proximityGroupID = groupID;
			break;
		case "Colorgroup": colorGroupID = groupID;
			break;
		case "Formgroup": formGroupID = groupID;
			break;
		case "Object" : proximityGroupID = groupID;
			break;
		}
	}
	
	public String getElementAsString() {
		return color+" "+form+"("+x+"|"+y+")";
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

}

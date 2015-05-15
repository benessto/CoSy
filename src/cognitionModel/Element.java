package cognitionModel;

public class Element {
	private int x;
	private int y;
	private int koordinates;
	private String color;
	private String form;
	private int connections = 0;
	private int groupID;
	
	public Element(int x, int y, String color, String form){
		setX(x);
		setY(y);
		setKoordinates(x, y);
		setColor(color);
		setForm(form);
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
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

}

package cognitionModel;

import java.util.HashMap;

public class Metaknowledge {
	private HashMap<String, String[]> data = new HashMap<String, String[]>();
	
	private String[] animals = {};
	private String[] plants = {};
	private String[] maschines = {};
	private String[] films = {};

	public HashMap getData() {
		return data;
	}
}

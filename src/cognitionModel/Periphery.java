package cognitionModel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Periphery {
	private String[][] cluster;
	private String searchedColor;
	private HashMap preProcessedVisual;

	public String[][] getCluster() {
		return cluster;
	}

	public void setCluster(String[][] cluster) {
		this.cluster = cluster;
	}

	public String getSearchedColor() {
		return searchedColor;
	}

	public void setSearchedColor(String searchedColor) {
		this.searchedColor = searchedColor;
	}
	
	public int getPreProcessing(){
		preProcessedVisual = new HashMap<Integer, String>();
		for(int i=0;i<Concentration.visual.length;i++){
			for(int j=0;j<Concentration.visual[0].length;j++){
				if(!Concentration.visual[i][j].equals("leer")){
					preProcessedVisual.put(i*100+j, Concentration.visual[i][j]);
				}
			}
		}
		int sumX = 0;
		int sumY= 0;
		int amount = 0;
		for(Iterator<Map.Entry<Integer, String>> it = preProcessedVisual.entrySet().iterator(); it.hasNext();){
			Map.Entry<Integer, String> entry = it.next();
			sumX = sumX + (entry.getKey()-(entry.getKey()%100));
			sumY = sumY + entry.getKey()%100;
			amount++;
		}
		sumX = sumX/amount;
		sumY = sumY/amount;
		return sumX*100+sumY;
	}
	
	
	/**
	 * This method searched for the given color in the given Cluster
	 * @return die summe der gefundenen richtigfarbigen objekte ein Objekt in der oberen reihe zählt 3 eins in der mittleren 5 und eins in der unteren 7
	 */
	public int search(){
		int found = 0;
		int oben = 0;
		int unten = 0;
		int equal = 0;
		
		for(int i=0;i<cluster.length;i++){
			for(int j=0;j<cluster[0].length;j++){
				if(!(j==1&&i==1) && cluster[i][j]!=null){
					String[] currentObjekt = cluster[i][j].split(" ");
					if(currentObjekt.length > 0){
						if(currentObjekt[0].equals(searchedColor)){
							if(i==0){
								oben++;
							}else if(i==1){
								equal++;
							}else{
								unten++;
							}
//							System.out.println("Periphery.search() found in cluster at "+i+","+j);
							found++;
						}
					}
				}
			}
		}
		if(found!=0){
			if(oben>equal&&oben>unten){ //oben ist am meisten
				return -1;
			}else if(equal>=unten){ // in der mitte ist am meisten
				return 0;
			}else{ //unten ist am meisten
				return 1;
			}
		}
		return 50;
	}
	
	public int searchAround(int ignore){ //2-oben 3-mitte 4-unten 5-oben und mitte 6-oben und unten 7-mitte und unten
		int found = 0;
		int oben=0;
		int unten=0;
		int equal=0;
		
		for(int i=0;i<cluster[0].length;i++){
			for(int j=0;j<cluster.length;j++){
				if(ignore==2){
					if(!(j==1&&i==1) && cluster[i][j]!=null && i!=0){
						String[] currentObjekt = cluster[i][j].split(" ");
					
						if(currentObjekt[0].equals(searchedColor)){
							if(i==1){
								equal++;
							}else{
								unten++;
							}
							found++;
						}
					}
				}else if(ignore==3){
					if(!(j==1&&i==1) && cluster[i][j]!=null && i!=1){
						String[] currentObjekt = cluster[i][j].split(" ");
					
						if(currentObjekt[0].equals(searchedColor)){
							if(i==0){
								oben++;
							}else{
								unten++;
							}
							found++;
						}
					}
				} else if(ignore==4){
					if(!(j==1&&i==1) && cluster[i][j]!=null && i!=2){
						String[] currentObjekt = cluster[i][j].split(" ");
					
						if(currentObjekt[0].equals(searchedColor)){
							if(i==0){
								oben++;
							}else if(i==1){
								equal++;
							}
							found++;
						}
					}
				}else if(ignore==5){
					if(!(j==1&&i==1) && cluster[i][j]!=null && i!=0 && i!=1){
						String[] currentObjekt = cluster[i][j].split(" ");
					
						if(currentObjekt[0].equals(searchedColor)){
							if(i>1){
								unten++;
							}
							found++;
						}
					}
				}else if(ignore==7){
					if(!(j==1&&i==1) && cluster[i][j]!=null && i!=1 && i!=2){
						String[] currentObjekt = cluster[i][j].split(" ");
					
						if(currentObjekt[0].equals(searchedColor)){
							if(i==0){
								oben++;
							}
							found++;
						}
					}
				}else if(ignore==6){
					if(!(j==1&&i==1) && cluster[i][j]!=null && i!=0 && i!=2){
						String[] currentObjekt = cluster[i][j].split(" ");
					
						if(currentObjekt[0].equals(searchedColor)){
							if(i==1){
								equal++;
							}
							found++;
						}
					}
				}
			}
		}
		if(found!=0){
			if(oben>equal&&oben>unten){
				return -1;
			}else if(equal>=unten){
				return 0;
			}else{
				return 1;
			}
		}
		return 50;
	}

	public int searchGroup(){
		for(int y=0;y<cluster[0].length;y++){
			for(int x=0;x<cluster.length;x++){
				if(!Concentration.getElements().containsKey(x*100+y)&&!Concentration.visual[x][y].equals("leer")){
					return x*100+y;
				}
			}
		}
		return -1;
	}
}

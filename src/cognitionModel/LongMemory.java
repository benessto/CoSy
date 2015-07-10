package cognitionModel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

public class LongMemory {
	MemoryConcept[] memory;
	private int affection;
	
	public LongMemory(int aff) {
		affection = aff;
		initializeMemory();
		provideAffection();
	}
	
	private void initializeMemory() {
		Collection<Entry<String, String[]>> entries = Metaknowledge.getData().entrySet();
		memory = new MemoryConcept[250];
		
		int i = 0;
		for (Entry<String, String[]> entry : entries) {
			for (int j = 0; j < entry.getValue().length; j++) {
				
				MemoryConcept memCon = new MemoryConcept(entry.getValue()[j], entry.getKey(), 0, 0);
				memory[i] = memCon;
				i++;
			}
		}
		
		
	}

	public void provideAffection() {
		Random random = new Random();

		for (int i = 0; i < memory.length; i++) {
			if (affection > 0) {
				if (affection > 150) {
					int pers = random.nextInt(151);
					pers = pers % 100;
					memory[i].setPersonalMemory(pers);
					affection -= pers;
				} else {
					memory[i].setPersonalMemory(affection);
					affection = 0;
				}
				
				if (affection > 150) {
					System.out.println("index: " + i);
					int fam = random.nextInt(151);
					fam = fam % 100;
					System.out.println("fam: " + fam);
					memory[i].setFamilarity(fam);
					affection -= fam;
				} else {
					memory[i].setFamilarity(affection);
					affection = 0;
				}
				System.out.println(affection);
			}
		}
	}
	
	public MemoryConcept getMemoryConcept(String word) {
		for (int i = 0; i < memory.length; i++) {
			if (memory[i].getWord().equalsIgnoreCase(word)) {
				return memory[i];
			}
		}
		
		return null;
	}
}

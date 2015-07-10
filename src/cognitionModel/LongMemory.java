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
				System.out.println(i);
				if (affection > 150) {
					int pers = random.nextInt(201);
					pers = pers % 150;
					memory[i].setPersonalMemory(pers);
					affection -= pers;
				} else {
					memory[i].setPersonalMemory(affection);
					affection = 0;
				}
				
				if (affection > 150) {
					int fam = random.nextInt(201);
					fam = fam % 150;
					memory[i].setFamilarity(fam);
					affection -= fam;
				} else {
					memory[i].setFamilarity(affection);
					affection = 0;
				}
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

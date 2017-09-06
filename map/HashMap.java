package map;

public class HashMap<Type> {
	private int capacity = 10;
	private int[] table = new int[capacity];
	private boolean[] seen = new boolean[capacity];
	private int collision = 0;
	private float full = 0;
	private int count = 0;
	
	public void put(int key, int value) {
		if (full >= 0.75) resize();
		
		int hash = key * 31;
		int index = hash % table.length; // what if table is resized ? it won't get to the same index!
		table[index] = value;
		
		if (seen[index]) collision++; 
		seen[index] = true;
		
		count++;
		full = count / capacity;
	}
	public int get(int key) {
		int hash = key * 31;
		int index = hash % table.length;
		return table[index];
	}
	public int delete(int key) {
		if (full <= 0.2) shrink();
		
		int hash = key * 31;
		int index = hash % table.length;
		int val = table[index];
		table[index] = 0;
		
		count--;
		full = count / capacity;
		return val;
	}
	private void resize() {
		int size = table.length;
		capacity = 2 * size;
		full /= 2;
		
		int[] oldTable = table;
		table = new int[capacity];
		
		seen = new boolean[capacity]; 
		
		for (int i = 0; i < size; i++) {
			table[i] = oldTable[i];
			seen[i] = true;
		}
	}
	private void shrink() {
		int size = table.length;
		capacity = size / 2;
		full *= 2;
		
		int[] oldTable = table;
		table = new int[capacity];
		
		boolean[] oldSeen = seen;
		seen = new boolean[capacity];
		
		for (int i = 0; i < size; i++) {
			if (oldSeen[i]) {
				table[i] = oldTable[i];
				seen[i] = true;
			}
		}
	}
}

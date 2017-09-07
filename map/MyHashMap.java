package map;
import util.Node;

public class MyHashMap {
	private int capacity;
	private Node[] table;
	private boolean[] seen;
	private int collision;
	private double thresold;
	private double thresoldLow; // thresold to shrink table if too empty
	private final float loadFactor = 0.75f;
	private int count;
	
	public MyHashMap(int size) {
		
		this.capacity = size;
		this.table = new Node[capacity];
		this.seen = new boolean[capacity];
		this.collision = 0;
		this.thresold = loadFactor * capacity;
		this.thresoldLow = (1 - loadFactor) * capacity;
		this.count = 0;
	}
	public void put(int key, int value) {
		if (count >= thresold) resize();
		
		int hash = key * 31;
		int index = hash % table.length - 1;
		int index2 = hash & table.length - 1;
		// what if table is resized ? we have to re-index all entries. 1- because table.length has changed. 2- because we do want to use the new available buckets and so try to have less filled buckets.
		
		// or another way int index =  hash & (table.length-1);  
		
		// -1 is very important because an even number as 16 is represented as 10000 in binary
		// so doing an AND with this mask would result either in 16 or 0 -> 2 possibilies for the table indices only. -> high probability of collisions.
		// if you use 15 which will be represented as 1111 in binary, the AND operation with this misk would result in all the indices possibilities from 0 to 15. -> much better indices distribution.
		System.out.println("index = " + index + ", index2 = " + index2);
		
		Node head = table[index];
		if (head == null) {
			head = new Node(key, value);			
		}
		else {
			head.add(key, value); // to do iterate through list to get the right item
			collision++;
		}
		
		if (seen[index]) collision++;
		seen[index] = true;
		
		count++;
	}
	public Integer get(int key) {
		int hash = key * 31;
		int index = hash % table.length;
		
		Node n = table[index];
		Integer val = n.get(key);
		return val;
	}
	public int delete(int key) {
		if (count <= thresoldLow) shrink();
		
		int hash = key * 31;
		int index = hash % table.length;
		
		Node n = table[index];
		//to do iterate through list to get the right item
		Integer val = null;
		n.delete(key);
		
		table[index] = null;
		
		count--;
		return val;
	}
	private void resize() {
		int size = table.length;
		capacity = 2 * size;
		thresold = loadFactor * capacity;
		
		Node[] oldTable = table;
		table = new Node[capacity];
		
		//seen = new boolean[capacity]; 
		
		transferToNewTable(oldTable, table);
		// we have to remap all entries into the new table because old indices are no longer valid as the table size changed
	}
	private void shrink() {
		int size = table.length;
		capacity = size / 2;
		thresold = loadFactor * capacity;
		
		Node[] oldTable = table;
		table = new Node[capacity];
		
		boolean[] oldSeen = seen;
		seen = new boolean[capacity];
		
		for (int i = 0; i < size; i++) {
			if (oldSeen[i]) {
				table[i] = oldTable[i];
				seen[i] = true;
			}
		}
	}
	private void transferToNewTable(Node[] from, Node[] to) {
		for (int i = 0; i < to.length; i++) {
			Node n = from[i];
			// may be more than one node if collisions have occured
			while (n != null) {
				int key = n.key, val = n.val;
				int newHash = key * 31;
				int newIndex = newHash % table.length - 1;
				Node headOfTo = to[newIndex];
				if (headOfTo == null) to[newIndex] = new Node(key, val);
				else headOfTo.add(key, val);
				n = n.next;
			}
		}
	}
	public static void main(String[] args) {
		MyHashMap a = new MyHashMap(4);
		//HashMap b = new HashMap(8);
		
		a.put(10, 100);
		//b.put(4, 100);
	}
}

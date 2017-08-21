package queue;
// usefull to implement priority queues
// it is an abstract representation of a tree but indeed only performs arithmetic on array indices

public class BinaryHeap {
	private  int next;
	private  Integer[] heap;
	
	public BinaryHeap(int capacity) {
		heap = new Integer [capacity+1]; // index 0 not used
		next = 0;
	}
	private Integer[] resize() {
		Integer[] temp = new Integer[2 * heap.length];
		for (int i = 1; i < heap.length; i++) {
			temp[i] = heap[i];
		}
		return temp;
	}
	public void exch(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	public int getMaxChild(int a, int b) {
		if (heap[a] > heap[b]) return a;
		else return b;
	}
	public void insert(int val) {
		if (next + 1 > heap.length - 1) heap = resize();
		heap[++next] = val;
		swim(next);
	}
	public int getMax() {
		return heap[1];
	}
	public int delMax() {
		int val = heap[1];
		exch(1, next);
		sink(1);
		heap[next] = null;
		next--;
		return val;
	}
	public void swim(int k) {
		while(k > 1) {
			if (heap[k] > heap[k/2]){
				exch(k, k/2);
				k = k/2;
			}
			else break;
		}
	}
	public void sink(int k) {
		int i = 2*k;
		while(i+1 < next && (heap[k] < heap[i] || heap[k] < heap[i+1])) {
			exch(k, getMaxChild(i, i+1));
			i = 2*i;
			k = 2*k;
		}
	}
	public static void main(String args[]) {
		BinaryHeap bh = new BinaryHeap(2);
		System.out.println("building heap");
		for (int i = 0; i < 10; i++) {
			int rand = (int) (Math.random() * 10);
			System.out.print(rand + " - ");
			bh.insert(rand);
		}
		System.out.println("");
		System.out.println("going through heap ");
		for (int i = 0; i < 10; i++) {
			System.out.print(bh.delMax() + " - ");
		}
	}
}

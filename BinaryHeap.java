/*
* efficient data structure to implement a priority queue which provides a convenient API such as delMax()
* as the tree is only represented by doing arithmetic on array indices, this requires to keep the tree perfectly balanced 
* (except for the last level which may be incomplete)
* we talk about implicit tree data structure
*
* Priority rule: Parent's key is greater than children keys.
* 
*/
//one more comment 2
public class BinaryHeap {
	private  int next;
	private  int[] heap;
	
	public BinaryHeap(int capacity) {
		heap = new int [capacity+1]; // index 0 not used
		next = 0;
	}
	public void insert(int val) {
		heap[++next] = val;
		swim(next);
	}
	public int delMax() {
		int val = heap[1];
		exch(1, next);
		sink(1);
		heap[next] = Integer.MIN_VALUE;
		next--;
		return val;
	}
	private void exch(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	private int getMaxChild(int a, int b) {
		if (heap[a] > heap[b]) return a;
		else return b;
	}
	private void swim(int k) {
		while(k > 1) {
			if (heap[k] > heap[k/2]){
				exch(k, k/2);
				k = k/2;
			}
			else break;
		}
	}
	private void sink(int k) {
		int i = 2*k;
		while(i+1 < next && (heap[k] < heap[i] || heap[k] < heap[i+1])) {
			exch(k, getMaxChild(i, i+1));
			i = 2*i;
			k = 2*k;
		}
	}
	public static void main(String args[]) {
		BinaryHeap bh = new BinaryHeap(10);
		bh.insert(3);
		bh.insert(9);
		bh.insert(4);
		bh.insert(1);
		bh.insert(7);
		bh.insert(2);
		bh.insert(0);
		bh.insert(8);
		bh.insert(5);
		bh.insert(6);
		bh.delMax();
		bh.insert(11);
	}
}

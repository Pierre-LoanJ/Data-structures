package sort;

import queue.BinaryHeap;
public class HeapSort {

	public static int[] sort(int[] a) {
		BinaryHeap h = new BinaryHeap(10);
		
		for (int i = 0; i < a.length; i++) {
			h.insert(a[i]);
		}
		int[] res = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			res[a.length - i - 1] = h.delMax();
		}
		return res;
	}
	public static void main(String [] args) {
		int n = 10;
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			int rand = (int) (Math.random() * 10);
			System.out.print(rand + " _ ");
			a[i] = rand;
		}
		System.out.println(" - ");
		int[] res = sort(a);
		for (int i = 0; i < n; i++) {
			System.out.print(res[i] + " - ");
		}
		int[] emp = new int[0];
		System.out.print(" end - ");
		
	}
}

package sort;
/*             Tri par sélection - tri non stable
 * 
 * principe:
 *  - on prend le plus petit élément et on l'échange avec le 1er 
 *  - on prend le plus petit élément du sous-tableau restant (tableau initial - 1) et on l'échange avec le 2e
 *  - ainsi de suite
 * 
 */

public class SelectionSort {
	public static void selectionSort(int t[]) {
		int min = 0;
		int temp;
		for (int i = 0; i < t.length; i++) {
			min = t[i];
			for (int j = i+1; j < t.length; j++) { // i+1 sinon compare avec lui-même
				if (t[j] < min) {
					min = t[j];
					//swap t[i] t[j]
					temp = t[i];
					t[i] = min;
					t[j] = temp;
				}
			}
		}
	}
	
	// revision
	public static void sort(int[] a) {
		for (int j = 0; j < a.length - 1; j++) {
			int min = a[j+1];
			int iMin = j + 1;
			for (int i = j + 1; i < a.length; i++) {
				if (a[i] < min) {
					min = a[i];
					iMin = i;
				}
			}
			swap(a, iMin, j);
		}
	}
	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	public static void main(String[] args) {
		int s = 100000;
		int a[] = new int[s];
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 10);
		}
		
		double d = System.currentTimeMillis();
		selectionSort(a);
		double f = System.currentTimeMillis();
		double t = f - d;
		System.out.println("temps = " + t);
		//display(a);
	}
	
	public static void display (int t[]) {
		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
	}
}

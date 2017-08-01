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
	
	public static void main(String[] args) {
		int tableau[] = { 5, 8, 4, 3, 7, 1, 9, 6, 2, 0 };
		selectionSort(tableau);
		display(tableau);
	}
	
	public static void display (int t[]) {
		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
	}
}

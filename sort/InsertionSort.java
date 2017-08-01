package sort;

public class InsertionSort {
	/*       Tri par insertion - tri stable
	 *
	 *principe:
	 * - on prend l'élément i de la partie droite et on le compare avec les éléments (un-à-un) de la partie gauche (partie triée)
	 * - si notre élément est plus petit que celui de la partie de gauche on les échange 
	 * - on continue ainsi en remontant le sous-tableau de gauche vers la gauche
	 * - on s'arrête quand l'élément à sa gauche est plus petit que notre élément courant
	 */
	public static void insertionSort(int t[]) {
		for (int i = 1; i < t.length; i++) {
			int temp = 0;
			int j = i;
				while (j-1 >= 0) {
					if (t[j] < t[j-1]){
						temp = t[j-1];
						t[j-1] = t[j];
						t[j] = temp;
					}
					j--;
				}
			}	
		}

	public static void main(String[] args) {
		int tableau[] = { 5, 8, 4, 3, 7, 1, 9, 6, 2, 0 };
		insertionSort(tableau);
		display(tableau);
	}

	public static void display (int t[]) {
		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
	}
}

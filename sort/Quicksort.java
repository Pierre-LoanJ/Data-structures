package sort;

public class Quicksort {
	  /*
	  * The idea is partition the array recursively:
	  * i goes through to the right
	  * j goes through to the left
	  * for i, keep a[i] < a[k], otherwise stops
	  * for j; keep a[j] > a[k], otherwise stops
	  * when i AND j have stopped exchange a[i] and a[j]
	  * so this keeps a partitioned
	  * Once i and j have crossed stop and exchange a[k] and a [j] (put a[k] to the right place)
	  */
	  public static int partition(int[] a, int lo, int hi) {
		int i = lo, j = hi+1;
	    while (true)
	    {
	    	while(a[++i] < a[lo])
	    	{
	    		if (i == hi) break;
	    	}
	    	while(a[lo] < a[--j])
	    	{
	    		if (j == lo) break;
	    	}
	    	if (i >= j) break;
	    	int temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	    }
	    int temp = a[j];
        a[j] = a[lo];
        a[lo] = temp;
        return j;
	  }
	  public static void sort( int[] a, int lo, int hi) {
	    if (lo >= hi) return;
	    int k = partition(a, lo, hi);
	    sort(a, lo, k-1);
	    sort(a, k+1, hi);
	  }
	  public static void sort(int[] a) {
	   //Collections.shuffle(Arrays.asList(a));
	   //StdRandom.shuffle(a);
	    sort(a, 0, a.length - 1);
	  }
	  public static void main(String args[]) {
		 int t[] = { 4, 9, 1, 7, 5, 2, 8, 3, 0, 6 };
		  int a[] = { 1,2,3,4,5,6,7,8,9,10 };
		 //int a[] = { 10, 9 ,6 , 5, 7, 4, 2, 1, 8, 3 };  
		 //sort(t);
		 shufflingFisherYates(a);
		 sorting(a, 0, a.length - 1); 							// miss - 1 !!! 
		 System.out.println("  finally  ");
		 show(a);
	 }
	 
	 // my personal code
	 public static void sorting(int[] a, int lo, int hi) {
		 if (hi <= lo) return;																// miss test and return statement
		 int k = partitionning(a, lo, hi);
		 sorting(a, lo, k -1);
		 sorting(a, k+1, hi);
	 }
	 private static int partitionning(int[] a, int lo, int hi) {
		 int k = lo;  		// partition element is at k 
		 int i = lo + 1;
		 int j = hi;
		 while (true) {
			 while (a[i] < a[k] && i < a.length - 1) {			 							// miss - 1 !!!  
				 i++;
			 }
			 while (a[j] > a[k] && j >= 1) {			 									// miss >= 1 !!!   miss i <= j !!!
				 j--;
			 }
			 if (j <= i) break;
			 exch(a, i, j);
		 }
		 exch(a, k, j);
		 return j;
	 }
	 private static void shufflingFisherYates(int[] a) {
		 
		 for (int i = a.length - 1; i >= 0; i--) {
			 double rand = Math.random() * i; 		// trick: * i so we have rand < i so we touch indices only once 
			 exch(a, i, (int) rand);							
		 }
		 System.out.println("  shuffle  ");
		 show(a);
		 
		 // personal thought: but still (even if it is probalisticly unlikely to happen) 
		 // we may not touch a certain range of upper indices if first random integers are by chance the ones in the lower bound area of the array
		 // is it ?
		 
		 
		 
		 /* naive algorithm as we may touch some indices more than once and neve touch some others
		 int l = a.length;
		 int n = 3 * l;
		 for (int i = 0; i < n; i++) {
			 int rand = (int) Math.random() * l;
			 if (rand != i && rand < a.length) exch(a, i, rand);
			 else i--;
		 }
		 */
	 }
	 private static void show(int[] a) {
		 for (int i = 0; i < a.length; i++) {
			 System.out.print(a[i] + "  -  ");
		 }
	 }
	 private static void exch(int[] a, int i, int j) {
		 int tmp = a[i];
		 a[i] = a[j];
		 a[j] = tmp;
	 }
}
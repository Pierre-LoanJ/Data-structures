package sort;
//import StdRandom;
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
		 sort(t);
		 System.out.println(t[0]);
		 System.out.println(t[1]);
		 System.out.println(t[2]);
		 System.out.println(t[3]);
		 System.out.println(t[4]);
		 System.out.println(t[5]);
		 System.out.println(t[6]);
		 System.out.println(t[7]);
		 System.out.println(t[8]);
		 System.out.println(t[9]);
	 }
}   
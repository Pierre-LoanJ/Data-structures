package sort;
public class BinarySearch{
	public static int binarySearchCourse(int[] t, int nb) {
		  int lo = 0;
		  int hi = t.length - 1;
		     while (lo <= hi) {
		    	int mi = (hi-lo)/2 + lo;
		        if (nb > t[mi]) { 
		           lo = mi + 1;
		        }
		        else if (nb < t[mi]) {
		           hi = mi - 1;
		        }
		        else return mi;
		     }
		     return -1;
	}
	
	public static int recursiveBS(int[] a, int target) {
		if (target > a[a.length-1] || target < a[0]) return -1; // optimization
		return recursiveBS(a, target, 0, a.length);
	}
	private static int recursiveBS(int[] a, int target, int lo, int hi) {
		if (a == null || a.length == 0 || lo > hi) return -1;
		int mid = (lo + hi) / 2;
		if (a[mid] < target) 	  return recursiveBS(a, target, mid + 1, hi);
		else if (a[mid] > target) return recursiveBS(a, target, lo, mid - 1);
		else return mid;
	}
	
	public static int iterativeBS(int[] a, int target) {
		if (target > a[a.length-1] || target < a[0]) return -1; // optimization
		return iterativeBS(a, target, 0, a.length - 1);
	}
	private static int iterativeBS(int[] a, int target, int lo, int hi) {
		int res = -1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			
			if (a[mid] < target) lo = mid + 1;
			else if (a[mid] > target) hi = mid - 1;
			else return mid; 
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] t = { 15, 16, 17, 18, 19, 20, 30, 35, 40, 45 };
		int[] a = { 1, 3, 4, 5, 6, 8};
		
		int result = iterativeBS(t, 5);
		System.out.println(result);
		}
}
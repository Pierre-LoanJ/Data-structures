package sort;
public class BinarySearch{
public static int binarySearch(int[] t, int nb) {
	  int lo = 0;
	  int hi = t.length - 1;
	  int mi = (hi-lo)/2 + lo;
	  
	  if (nb > t[hi] || nb < t[lo]) { 
		  return -1;
	 }
	  else {
	     while (lo < hi) {
	    	
	        if (nb > t[mi]) { 
	           lo = mi + 1;
	        }
	        else if (nb < t[mi]) {
	           hi = mi - 1;
	        }
	        else break;
	        mi = (hi-lo)/2 + lo;
	     }
	     if (nb != t[mi]) { return -1; }
	     else return mi;
	  }
	}

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

public static void main(String[] args) {
	int[] t = { 15, 16, 17, 18, 19, 20, 30, 35, 40, 45 };
	int result = binarySearchCourse(t, 45);
	System.out.println(result);
	}
}
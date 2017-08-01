package binarySearch;

public class BinarySearch {


	


	private static String bs(int[] tab, int target) {
	  boolean isSorted = true;
	  if (!isSorted) {
	    return "NOT SORTED";
	  }
	  if (tab == null) 									 return "TAB IS NULL";
	  if (tab.length == 0) 								 return "TAB IS EMPTY";
	  if (target < tab[0] || target > tab[tab.length-1]) return "NOT IN TAB";
	  else {
	    int inf = 0;
	    int sup = tab.length - 1;
	    return bsb(tab, target, inf, sup);
	  }
	}
	private static String bsb(int[] tab, int target, int inf, int sup) {
	  if ((sup - inf == 1) && tab[inf] != target && tab[sup] != target) return "NOT IN TAB";
	  if ((sup - inf == 0) && tab[inf] != target)                       return "NOT IN TAB";
	  
	  
	  int mid = inf + ((sup - inf) / 2);
	  
	  /*
	   * POUR JS ONLY
	   * if ((sup - inf)%2 == 0) {
	    System.out.println("difference paire");
	  }
	  else {
	    mid = (int) (mid - 0.5);
	    System.out.println("difference impaire");
	  }*/
	  
	  if (target == tab[mid]) {
		String res = "FOUND" + mid;
		return res;
	  }
	  else if (target < tab[mid]) {
	    return bsb(tab, target, inf, mid);
	  }
	  else if (target > tab[mid]) {
	    return bsb(tab, target, mid, sup+1);
	  }
	  else return "ERROR NOT HANDLED";
	} 

	  public static void main(String[] args)  {
		  int[] tab = { 1, 2, 4, 5, 8, 10, 11, 13, 14 };
		  String r = bs(tab, 8);
		  System.out.println("resultat: " + r);
	  }

}

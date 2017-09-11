package sort;
public class Mergesort<T extends Comparable<T>> {
  public void merge(T t[], T temp[], int lo, int mi, int hi) {
    for (int k = lo; k <= hi; k++) {
      temp[k] = t[k];
    }
    int i = lo, j = mi+1;
    for (int k = lo; k <= hi; k++) {
      if (i > mi)                 				t[k] = temp[j++];
      else if (j > hi)            				t[k] = temp[i++];
      else if (temp[i].compareTo(temp[j]) > 0) 	t[k] = temp[j++];
      else                        				t[k] = temp[i++];
    }
  }
  public void divide(T t[], T temp[], int lo, int hi) {
    if (hi <= lo) return;
    
    int mi = lo + (hi - lo) / 2;
    divide(t, temp, lo, mi);
    divide(t, temp, mi+1, hi);
    merge(t, temp, lo, mi, hi);
  }
  public void sort(T t[]) {
    @SuppressWarnings("unchecked")
	T[] temp = (T[]) new Comparable[t.length];
    divide(t, temp, 0, t.length - 1);
  }
  public void display (T[] a) {
	for (int i = 0; i < a.length; i++) {
		System.out.print(a[i] + "  -  ");
	}
	System.out.println("");
  }
  public static void main(String[] args) {
	  Integer[] a = { 4, 3, 1, 6, 2, 5 };
	  Mergesort<Integer> ms = new Mergesort<Integer>();
	  ms.display(a);
	  ms.sort(a);
	  ms.display(a);
  }
}


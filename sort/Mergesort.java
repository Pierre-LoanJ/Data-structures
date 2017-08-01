package sort;
public class Mergesort {
  public static void merge(char t[], char temp[], int lo, int mi, int hi) {
    for (int k = lo; k <= hi; k++) {
      temp[k] = t[k];
    }
    int i = lo, j = mi+1;
    for (int k = lo; k <= hi; k++) {
      if (i > mi)                 t[k] = temp[j++];
      else if (j > hi)            t[k] = temp[i++];
      else if (temp[i] > temp[j]) t[k] = temp[j++];
      else                        t[k] = temp[i++];
    }
  }
  public static void divide(char t[], char temp[], int lo, int hi) {
    int mi = lo + (hi - lo) / 2;
    if (hi <= lo) { return; }
    else {
      divide(t, temp, lo, mi);
      divide(t, temp, mi, hi);
      merge(t, temp, lo, mi, hi);
    }
  }
  public static void sort(char t[]) {
    char[] temp = new char[t.length];
    divide(t, temp, 0, t.length - 1);
  }
}


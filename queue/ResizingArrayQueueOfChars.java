package queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ResizingArrayQueueOfChars <Type> {
	  private int first = 0;
	  private int last  = 0;
	  private Type[] a;
	  public ResizingArrayQueueOfChars(int n) {
	    a = (Type[]) new Object[n]; 
	  }
	  public Type[] shift(Type[] t) {
		Type[] tShifted = (Type[]) new Object[t.length];
	  	int oldFirst = first;
	  	for (int i = first; i < t.length; i++) {
	  		if (i > last) break;
	  		tShifted[i - first] = t[i];
	  	}
	  	first = first - oldFirst;
	  	last = last - oldFirst;
	  	return tShifted;
	  }
	  public Type[] resize(Type[] t) {
			int n = t.length;
			Type[] tResized = (Type[]) new Object[ 2 * n ];
			for (int i = 0; i < n; i++) {
		  		tResized[i] = t[i];
			}
			return tResized;
	  }
	  public boolean isEmpty() {
	    return last == 0;
	  }
	  public void enQueue(Type c) {
	    if (last >= a.length) a = resize(a);
	    a[last] = c;
	    last++;
	  }
	  public Type deQueue() {
	    if (isEmpty()) return null;
	    Type c = a[first];
	    first++;
	    if (first >= a.length / 4) a = shift(a);
	    return c;
	   }
	  
	 /* @SuppressWarnings(value = { "unchecked" })
	  public void genTab(Type val){
		  Type[] a= new Type[5];
		  byte b = 3;
	  }*/
	  public static void main(String args[]) {
		ResizingArrayQueueOfChars queue = new ResizingArrayQueueOfChars(5);
		queue.enQueue('a');
		queue.enQueue('b');
		queue.enQueue('c');
		System.out.println(queue.deQueue());
		"abc".toUpperCase();
		LinkedList<Integer> l = new LinkedList<Integer>();
		ArrayList<Integer> a = new ArrayList<Integer>();
	  }
	}
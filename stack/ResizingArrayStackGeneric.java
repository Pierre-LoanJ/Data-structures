package stack;

import java.util.AbstractList;
import java.util.ArrayList;

public class ResizingArrayStackGeneric<Type> {
		private Type[] t;
		private int pos = 0;
		
		private String[] a;
		
		//@SuppressWarnings("unchecked")
		public ResizingArrayStackGeneric(int n) {
			t = (Type[]) new Object[n]; // uncheck cast but ok
			
			a = (String[]) new Object[n];
			 // throws a ClassCastException
			 // but works with generics thanks to Type Erasure
			 // (at Run-time Type is replaced by Object (unbound) or the type it extends (bound) 
		}
		
		public boolean isFull(Type[] tab) { return pos == tab.length; }
		
		public Type[] resize(Type[] t) {
			int n = t.length;
			@SuppressWarnings("unchecked")
			Type[] tResized = (Type[]) new Object [ 2 * n ];
			for (int i = 0; i < n; i++) {
		  		tResized[i] = t[i];
			}
			return tResized;
		}
		
		public boolean isEmpty() { return pos == 0; }
		public void push(Type item) {
			if (this.isFull(t)) t = resize(t);
				t[pos++] = item;
		}
		
		public Type pop() {
			if (isEmpty()) return null;
			Type val = t[--pos];
			t[pos] = null; //prevent from loitering
			return val;
		}
		

		public static void main(String[] args) {
			ResizingArrayStackGeneric<String> stack = new ResizingArrayStackGeneric<String>(3);
			stack.push("a");
			System.out.println(stack.pop());
			System.out.println(stack.pop());	
			
			
			String[] s = "a;b;c".split(";");
			Object[] o = new Integer[s.length];
			for (int i = 0; i < s.length; i++) {
			    o[i] = Integer.parseInt(s[i]);
			}
			/*
			AbstractList rawList =  new ArrayList();
			rawList.add(2);
			
			
		    ArrayList<String> stringList =  new  ArrayList<String>();
		    rawList    = stringList;
		    stringList = rawList;
		    */
		    
		}
}

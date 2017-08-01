package stack;

import java.util.Iterator;

public class LinkedStackGeneric<Type> implements Iterable<Integer> {
	private Node first = null;
	
	private class Node {
		Type item;
		Node next;
	}
	public boolean isEmpty() { 
		return first == null;
	}
	public void push(Type arg) {
		Node oldfirst = first;
		first = new Node();
		first.item = arg;
		first.next = oldfirst;
	}
	public Type pop() {
		Type obj = first.item;
		first = first.next;
		return obj;
	}
	public static void main(String[] args) {
		LinkedStackGeneric<String> p = new LinkedStackGeneric<String>();
		 p.push("a");
		 System.out.println(p.pop());
		}
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
/* l'astuce ici est de garder une référence sur le premier élément de la pile
 */

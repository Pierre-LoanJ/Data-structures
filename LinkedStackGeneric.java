// The idea is to keep a reference first to the top of the stack
public class LinkedStackGeneric<Type> {
	private Node first = null;
	
	private class Node {
		Type item;
		Node next;
	}
	public boolean isEmpty() { 
		return first == null;
	}
	public void push(Type item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	public Type pop() {
		Type item = first.item;
		first = first.next;
		return item;
	}
}

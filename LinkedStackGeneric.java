public class LinkedStackGeneric<Type> {
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
		first = oldfirst;
	}
	public Type pop() {
		Type obj = first.item;
		first = first.next;
		return obj;
	}
}
/* l'astuce ici est de garder une r�f�rence sur le premier �l�ment de la pile
 */

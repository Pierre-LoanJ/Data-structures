package stack;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class LinkedStackOfStrings implements Iterable<String> {
	private Node first = null;

private class Node {
	String item;
	Node next;
}

public class ListIterator implements Iterator<String>{
	Node current = first;
	@Override
	public boolean hasNext() {
		return current != null;
	}
	
	@Override
	public String next() {
		String item = (String) current.item;
		current = current.next;
		if (current.next == null) throw new NoSuchElementException(); 
		return item;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

   }
@Override
public Iterator<String> iterator() {
	// TODO Auto-generated method stub
	return new ListIterator();
}

public boolean isEmpty() {
	return first == null;
}

public void push(String item){
	Node oldfirst = first;
	first = new Node();
	first.item = item;
	first.next = oldfirst;
}

public String pop() {
	String item = first.item;
	first = first.next;
	return item;
}

	public static void main(String[] args) {
	 LinkedStackOfStrings pile = new LinkedStackOfStrings();
	 pile.push("a");
	 pile.push("b");
	 pile.push("c");
	 
	 for (String unChar : pile) {
		 System.out.println(unChar);
	 }
	// pile.push("b");
	// pile.push("c");
	// String tab[] = new String[3];
	// tab[0] = pile.pop();
	// tab[1] = pile.pop();
	// tab[2] = pile.pop();
	 //System.out.println(pile.pop());
	}
}



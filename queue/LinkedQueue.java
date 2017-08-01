package queue;
public class LinkedQueue<Type> {
	private Node first, last;
	
	public LinkedQueue(){
		this.first = null;
		this.last = null;
	}
	private class Node {
		Type item;
		Node next;
	}
	/*public LinkedQueueOfStrings() {
		
	}*/
	
	public boolean isEmpty() {
		return first == null;
	}
	public void enqueue(Type item) {
		Node oldlast = last;
		Node last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else oldlast.next = last;
		
		
		/*Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;		// ainsi first n'est plus nul (implémenter cas général et penser au cas limite: file vide)
		else		   oldlast.next = last; // attention au sens!
											// ne pas faire last.next = oldlast 
											//car on perdrait la référence vers le nouveau first après suppression quand on enlève un item
	*/
	}
	
	public Type dequeue(){
		/*String item = first.item;
		first = first.next;
		if (isEmpty()) last = null;			//cas limite: file vide
		return item;*/
		if (this.isEmpty()) {
			last = null;
		}
		Type val = first.item;
		first = first.next;
		return val;
	}
	public static void main(String[] args) {
		LinkedQueue<String> file = new LinkedQueue<String>();
		 file.enqueue("a");
		 file.enqueue("b");
		 file.enqueue("c");
		 String tab[] = new String[3];
		 tab[0] = file.dequeue();
		 tab[1] = file.dequeue();
		 tab[2] = file.dequeue();
		 System.out.println(tab[0]);
		 System.out.println(tab[1]);
		 System.out.println(tab[2]);
		}


}

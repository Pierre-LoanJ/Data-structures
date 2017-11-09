package queue;
public class LinkedQueue<Type> {
	private Node first, last;
	
	/*public LinkedQueue(){
		this.first = null;
		this.last = null;
	}*/
	private class Node {
		Type item;
		Node next;
		
		public Node(Type item) {
			this.item = item;
			this.next = null;
		}
	}
	public boolean isEmpty() {
		return this.first == null;
	}
	public void enqueue(Type item) { // add at last
		if (this.isEmpty()) {
			last = new Node(item);
			first = last;
		}
		else {
			last.next = new Node(item);
			last = last.next;
		}
	}
	public Type dequeue() { // dequeue at first
		if (this.isEmpty()) return null;
		Type item = first.item;
		first = first.next;
		if (first == null) last = null;
		return item;
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
		 System.out.println("end");
		}


}

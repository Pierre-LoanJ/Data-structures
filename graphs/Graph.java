package graphs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Graph {
	private final int V;
	private Bag<Integer>[] adj;
	
	// private LinkedStackOfStrings[] bagOfString; //other implementation example

	private class Bag<Type> implements Iterable<Type> { // bag of generics
		private Node first = null;
		
		private class Node<Type> {
			private Type val;
			private Node next;
		}
		private class ListIterator<Type> implements Iterator<Type> {
			private Node<Type> current;

	        public ListIterator(Node<Type> first) {
	            current = first;
	        }

	        public boolean hasNext()  { return current != null;                     }
	        public void remove()      { throw new UnsupportedOperationException();  }

	        public Type next() {
	            if (!hasNext()) throw new NoSuchElementException();
	            Type item = current.val;
	            current = current.next; 
	            return item;
	        }
	    }
	
		public void add(Type v) {
			Node oldFirst = first;
			
			Node newNode = new Node();
			newNode.val = v;
			newNode.next = oldFirst;
			
			first = newNode;
		}

		@Override
		public Iterator iterator() {
			// TODO Auto-generated method stub
			return new ListIterator<Type>(first);
		}
	}

	public Graph(int V) {
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
		//bagOfString = new LinkedStackOfStrings[V];
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Bag<Integer> adj(int v) {
		return adj[v];
	}
	public int V() {
		return this.V;
	}

	
	public static void main(String[] args) {
		Graph g = new Graph(1);
	}
}

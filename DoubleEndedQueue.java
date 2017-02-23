package queue;

import java.util.Iterator;
import java.lang.Exception;
import java.util.NoSuchElementException;

public class DoubleEndedQueue<Item> implements Iterable<Item>  {
	private Node first, last;
	
	private class Node<Item> {
		private Item item;
		private Node next;
	}
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = (Item) current.item;
			current = current.next;
			if (current.next == null) throw new NoSuchElementException(); 
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	   }
	   public DoubleEndedQueue DoubleEndedQueue() {
		   return new DoubleEndedQueue();
	   }                          // construct an empty deque
	
	   public boolean isEmpty()  {
		return first == null; }                // is the deque empty?
	   
	   public int size() {
		return 0;}                        // return the number of items on the deque
	   
	   public void addFirst(Item item) throws NullPointerException {
		   if (item == null) throw new java.lang.NullPointerException();
		   
		   Node oldFirst = first;
		   Node first = new Node();
		   first.item = item;
		   first.next = oldFirst;
	   }          // add the item to the front
	   
	   public void addLast(Item item) throws NullPointerException{
		   if (item == null) throw new java.lang.NullPointerException();
		   Node oldlast = last;
		   Node last = new Node();
		   last.item = item;
		   last.next = null;
		   if (isEmpty()) first = last;
		   else oldlast.next = last;
	   }           // add the item to the end
	   
	   @SuppressWarnings("unchecked")
	public Item removeFirst() throws NoSuchElementException {
		   if (this.isEmpty()) {
				first = null;
				throw new java.util.NoSuchElementException();
			}
		   Item val = (Item) first.item;
		   first = first.next;
		   return val;
		}                // remove and return the item from the front
	   
	   public Item removeLast() throws NoSuchElementException{
			if (this.isEmpty()) {
				last = null;
				throw new java.util.NoSuchElementException();
			}
			Item val = (Item) last.item;
			first = first.next;
			return val;
		}                 // remove and return the item from the end
	   
	   
	   public Iterator<Item> iterator() throws UnsupportedOperationException, NoSuchElementException {
		return new ListIterator();}         // return an iterator over items in order from front to end
	   
	   public static void main(String[] args)  {}  // unit testing
	}

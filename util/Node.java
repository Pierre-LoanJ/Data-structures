package util;

public class Node {
	public Integer val;
	public Integer key;
	public Node next;
	
	public Node(Integer key, Integer val) {
		this.key = key;
		this.val = val;
	}

	public void add(Integer key, Integer value) {
		Node head = this;
		Node next = head.next;
		while (next != null) {
			head = next;
			next = next.next;
		}
		head.next = new Node(key, value);
	}

	public Integer get(Integer key) {
		Node head = this;
		while (head != null) {
			if (key == head.key) return head.val;
			head = head.next;
		}
		return null;
	}

	public void delete(Integer key) {
		// find the right Node from head -> the right key 
		Node head = this;
		Node dummy = new Node(0, 0);
		dummy.next = head;
		Node before = dummy, next = head;
		while (next != null) {
			if (key == next.key) {
				before.next = next.next;
			}
			before = next;
			next = next.next;
		}
	}
}

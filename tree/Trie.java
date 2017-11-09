package tree;

import java.util.LinkedList;

public class Trie {
	private Node root;
	
	 public class Node {
	    private Node[] children;
	    private boolean endOfWord;
	    
		 public Node() {
			 this.endOfWord = false;
			 this.children = new Node[26];
		 }
		 public boolean isEndOfWord() {
			 return this.endOfWord;
		 }
	 }
	 public Trie() {
		 this.root = new Node();
	 }
	 public Node getRoot() {
		 return this.root;
	 }
	 public boolean search(String s, Node n) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int v = c - 97;
			if (n.children[v] != null) {
				if (i == s.length() - 1 && n.isEndOfWord()) {
					System.out.println("search hit!");
					return true;
				}
				else n = n.children[v];
			}
			else {
				System.out.println("reached end of tree before key last char, search miss");
				return false;
			}
		}
		System.out.println("string in trie but EOW not found");
		return false;
	 }
	 public void insert(String s, Node n) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i); 
			int v = c - 97; 			// a -> 0, b -> 1, z -> 26
			if (n.children[v] == null) {
				n.children[v] = new Node();
			}
			if (i == s.length() - 1) {
				n.endOfWord = true;
			}
			n = n.children[v];
		}
		System.out.println("insert success!");
	 }
	 public static void main(String[] args) {
		 Trie trie = new Trie();
		 Node root = trie.getRoot();
		 String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
		 int i;
	     for (i = 0; i < keys.length ; i++) {
	    	 trie.insert(keys[i], root);
	 	}
	    trie.search("the", root);
	    trie.search("these", root);
	    trie.search("their", root);
	    trie.search("thaw", root);		 
	 }
}

package tree;
public class LeftLeaningRedBlackBST {

	private Node root = null;
	public static final boolean RED   = true;
	public static final boolean BLACK = false;
	
	public class Node {
		private int val;
		private char key;
		private Node left;
		private Node right;
		private boolean color;
    
		public Node(char key, int val) {
	      this.val = val;
	      this.key = key;
	      this.color = RED;
	    }
	}

  private Node rotateLeft(Node h) {
	  Node x = h.right;
	  h.right = x.left;
	  x.left = h;
	  x.color = h.color;
	  h.color = RED;
	  return x;
  }
  private Node rotateRight(Node h) {
	  Node x = h.left;
	  h.left = x.right;
	  x.right = h;
	  x.color = h.color;
	  h.color = RED;
	  return x;
  }
  private void flipColor(Node h) {
	  h.right.color = BLACK;
	  h.left.color  = BLACK;
	  h.color       = RED;
  }
  private Node put(Node n, char key, int val) {
    if (n == null) return new Node(key, val);
    
    if      (n.key == key) n.val = val;
    else if (n.key <  key) n.right = put(n.right, key, val);
    else if (n.key >  key) n.left = put(n.left, key, val);
    
    if (isRed(n.right) && !isRed(n.left))    n = rotateLeft(n);
    if (isRed(n.left) && isRed(n.left.left)) n = rotateRight(n);
    if (isRed(n.left) && isRed(n.right))     flipColor(n);
    
    return n;
  }
  public int get(int key) {
    return 0;
  }
  public void put(char key, int val) {
    root = put(root, key, val);
  }
  public boolean isRed(Node h) {
	  if (h == null) return false;
	  else return h.color == RED;
  }
  public static void main(String[] args) {
	LeftLeaningRedBlackBST t = new LeftLeaningRedBlackBST();
    t.put('S', 1);
    t.put('E', 2);
    t.put('A', 3);
    t.put('R', 4);
    t.put('C', 5);
    t.put('H', 6);
    t.put('X', 7);
    t.put('M', 8);
    t.put('P', 9);
    t.put('L', 10);
    
    System.out.println("end");
  }
}
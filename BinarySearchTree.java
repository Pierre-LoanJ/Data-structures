/*
* tree, not obviously perfectly balanced, (this depends on the order keys are inserted)
* used to implement efficient symbol table data structure
* we talk about explicit tree data structure as we use node objects to link the data inside the tree
*/

public class BinarySearchTree {
  private Node root;
  private boolean hibbard = true; 
  private Node root = null;
  private int toRight = 0;
  private int count = 0;
  private int maxDepth;
  private BinaryHeap depths = new BinaryHeap(1000);
  
  public class Node {
    private int val;
    private Integer key;
    private Node left;
    private Node right;
    public int size;
    
    public Node(Integer key, int val, int size) {
      this.val = val;
      this.key = key;
      this.size = size;
    }
  }
  public void put(Integer key, int val) {
    root = put(root, key, val);
  }
  private Node put(Node n, Integer key, int val) {
    if (root == null) {
      count++;
      return new Node(key, val, 1);
    }
    else {
      if      (n.key == key) n.val   = val;
      else if (n.key <  key) n.right = put(n.right, key, val);
      else if (n.key >  key) n.left  = put(n.left, key, val);
      
       n.size = 1 + size(n.left) + size(n.right);
      return n;
    }
  }
  public Integer get(Integer key) {
    Node x = root;
    while (x != null) {
      if      (x.key == key) return x.val;
      else if (x.key <  key) x = x.right;
      else if (x.key >  key) x = x.left;
    }
    return null;
  }
  public void delete(Integer key) {
    
  }
  public static void main(String[] args) {
    BinarySearchTree t = new BinarySearchTree();
  }
}

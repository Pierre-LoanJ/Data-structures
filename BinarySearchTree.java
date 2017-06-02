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
  private Node min(Node x) { 
      if (x.left == null) return x; 
      else                return min(x.left); 
  }
  private Node max(Node x) {
	  while (x.right != null) { // another way
		  x = x.right;
	  }
	  return x;
  }
  private int height(Node x) {
      if (x == null) return -1;
      return 1 + Math.max(height(x.left), height(x.right));
  }
  private int size(Node x) {
      if (x == null) return 0;
      else return x.size;
  }
  private Node deleteMin(Node x) {
      if (x.left == null) return x.right;
      x.left = deleteMin(x.left);
      x.size = size(x.left) + size(x.right) + 1;
      return x;
  }
   private Node deleteHibbard(Node x, int key) {
	  if (x == null) return null;
	  if      (key < x.key) x.left  = deleteHibbard(x.left, key);
	  else if (key > x.key) x.right = deleteHibbard(x.right, key);
	  else {
		  count--;
		  if (x.right == null) return x.left;
	//	  if (x.left  == null) return x.right; with or without it seems to be the same
		  Node t = x;
		  x = min(t.right);
		  x.right = deleteMin(t.right);
		  x.left = t.left;
	  }
	  x.size = size(x.left) + size(x.right) + 1;
	  return x;
  }
  private Node delete(Node x, int key) {
	  if (x == null) return null;
	  
	  // search the node to be deleted
	  if (key == x.key) {
		  count--;
		  if (x.left == null && x.right == null) return null;  // no child
		  else if (x.left != null && x.right == null || x.left == null && x.right != null) { // only one child
			  if (x.left == null) return x.right;
			  else 				  return x.left;
		  }
		  else if (x.left != null && x.right != null) { // 2 children
			  // here is my own implementation (and not the Hibbard deletion)
			  // by convention we take right subtree to replace deleted node
			  // and insert the left subtree into the the right subtree
			  
			  // or better we take once right once left
			  if (toRight == -1) x = putTree(x.left, x.right); //or inverse
			  else if (toRight >= 0) {
				  if (toRight%2 == 1) x = putTree(x.right, x.left);
				  else 	  			  x = putTree(x.left, x.right);
			  }
		  }
	  }
	  else if (key > x.key) x.right = delete(x.right, key); // go right
	  else if (key < x.key)  x.left = delete(x.left, key); // go left
	  return x;
  }
 private void inorderRec(Node root) {
      if (root != null) {
    	  maxDepth++;
          inorderRec(root.left);
       //   System.out.print(root.key + " ");
          inorderRec(root.right);
          maxDepth--;
      }
      else {
    	  depths.insert(maxDepth);
      }
  }
  public Integer min() {
	return min(root).key;
  }
  public Integer max() {
	return max(root).key;
  }
  public int height() {
	  // implementation from the course
      return height(root);
  }
  public Integer size() {
	  return size(root);
  }
  public double hauteur() {
	  // my own implementation. REQUIRES THE TREE TO BE PARSED BY INORDER()
	  return depths.getMax();
  }
  public Integer taille() {
	  return this.count;
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
  public void inorder() {
	  maxDepth = 0;
      inorderRec(root);
  }
  public void delete(int key) {
	  	if (hibbard) {
	  		root = deleteHibbard(root, key);
	  			// With the Hibbard deletion the tree becomes less symmetric as it was
			    // and becomes O(Sqrt(n)) time complex
	  	}
	  	else {	  		
	  		if (toRight > -1) toRight++;
	  		root = delete(root, key);
			 /* my own implementation.
			  idea: the single difference with Hibbard deletion concerns the 2 children case only.
			  My algorithm proceeds as follows:
			  We take the left subtree of the node that we want to delete
			  and place at the right place into the right subtree of the node that we want to delete
			  Then we replace the deleted node with its right subtree itself
			  For better balance we alternate left and right, once we place left into right, once the opposite
			 
			 	OBSERVATIONS
			 	EXECUTION TIME
			 	
			 	Hibbard: 1M deletion operations take  ~7 sec.
			 	mine   :                             ~21 sec.
			 	
			 	Hibbard: 10M deletion operations take  ~10 sec.
			 	mine   :                               ~30 sec.
			 	
			 	Conclusion: My algo is about 3 times slower, but scales the same!
			                O(log(n)) < Hibbard < O(Sqrt(n))
			                O(log(n)) < mine    < O(Sqrt(n))
			                mine * C ~ Hibbard if C ~3
			    
			    the growth scale rate is defined by 10/7 for Hibbard and by 30/21 for mine
			    which confirms both algorithms to be slower than O(log n) and faster than O(sqrt n) ~ * 3,16 factor 
			    (for a growth of 10 of the input data)
			    
			   BACKBONE OF THE TREES
			   
			   Hibbard tree is degenerated by a height of +20 with about 10M deletion operations
			   Mine         is degenerated by a hieght of +20 with about 10k deletion operations
			   
			   -> my tree is degenerated with 10^4 less deletion operations
			 */
	  	}
  }
  public static void main(String[] args) {
    BinarySearchTree t = new BinarySearchTree();
  }
}

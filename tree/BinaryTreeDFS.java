package tree;

public class BinaryTreeDFS {
	public class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int v, TreeNode left, TreeNode right) {
			this.val = v;
			this.left = left;
			this.right = right;
		}
	}
	 public BinaryTreeDFS() {
		// TODO Auto-generated constructor stub
	}
	public static void preOrder(TreeNode n) {
    	if (n == null) return;
    	System.out.println(n.val);
    	preOrder(n.left);
    	preOrder(n.right);
    }
    public static void postOrder(TreeNode n) {
    	if (n == null) return;
    	postOrder(n.left);
    	postOrder(n.right);
    	System.out.println(n.val);
    }
    public static void inOrder(TreeNode n) {
    	if (n == null) return;
    	inOrder(n.left);
    	System.out.println(n.val);
    	inOrder(n.right);
    }
    public static void main(String[] args) {
    	BinaryTreeDFS tree = new BinaryTreeDFS();
    	TreeNode root = tree.new TreeNode(2, null, null);
    	
    	root.left = tree.new TreeNode(3, null, null);
    	root.right = tree.new TreeNode(3, null, null);
    	
    	root.left.left = tree.new TreeNode(4, null, null);
    	root.left.right = tree.new TreeNode(5, null, null);
    	root.right.left = tree.new TreeNode(5, null, null);
    	root.right.right = tree.new TreeNode(4, null, null);
    	
    	root.left.right.left = tree.new TreeNode(8, null, null);
    	root.left.right.right = tree.new TreeNode(9, null, null);
    	root.right.left.left = tree.new TreeNode(9, null, null);
    	root.right.left.right = tree.new TreeNode(8, null, null);
    	
    	postOrder(root);
    }
}
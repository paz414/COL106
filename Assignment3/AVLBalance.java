class Node {
	int key, height; 
	Node left, right; 

	Node(int d) { 
		key = d; 
		height = 1; 
	} 
} 

class AVLBalance { 

	Node root;
	int height(Node N) {
		if (N == null)
			return 0;
		return N.height;
	}
	// A utility function to right rotate subtree rooted with y
	Node rightRotate(Node y) { 
		Node c = y.left;
		Node T = c.right;
		c.right=y;
		y.left=T;
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		return c;
	} 

	// A utility function to left rotate subtree rooted with x
	Node leftRotate(Node x) { 
		Node p = x.right;
		Node T = p.left;
		p.left=x;
		x.right=T;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		p.height = Math.max(height(p.left), height(p.right)) + 1;
		return p;
	}
	// Get Balance factor of node N 
	int getBalance(Node N) { 
		if (N == null)
			return 0;
		if(N.left == null)
			return -height(N.right);
		if(N.right == null)
			return height(N.left);
		return height(N.left) - height(N.right);
	} 

	Node insert(Node node, int key) {
		if (node == null)
			return new Node(key);
		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);
		node.height = 1 + Math.max(height(node.left), height(node.right));
		return rotate(node);
	}
	Node rotate(Node node){
		if(height(node.left)-height(node.right)>1){
			if(height(node.left.left)>height(node.left.right)) {
				return rightRotate(node);
			}
			if(height(node.left.left)<height(node.left.right)) {
				node.left=leftRotate(node.left);
				return rightRotate(node);
			}
		}
		if(height(node.left)-height(node.right)<-1){
			if(height(node.right.right)>height(node.right.left)) {
				return leftRotate(node);
			}
			if(height(node.right.right)<height(node.right.left)) {
				node.right=rightRotate(node.right);
				return leftRotate(node);
			}
		}
		return node;
	}
    // A utility function to print preorder traversal 
	// of the tree. 
	// The function also prints height of every node 
	void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.key + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	} 

	public static void main(String[] args) { 
		AVLBalance tree = new AVLBalance(); 

		/* Constructing tree given in the above figure */
		tree.root = tree.insert(tree.root, 10); 
		tree.root = tree.insert(tree.root, 20); 
		tree.root = tree.insert(tree.root, 30); 
		tree.root = tree.insert(tree.root, 40); 
		tree.root = tree.insert(tree.root, 50); 
		tree.root = tree.insert(tree.root, 25); 

		/* The constructed AVL Tree would be 
			30 
			/ \ 
		20 40 
		/ \	 \ 
		10 25 50 
		*/
		System.out.println("Preorder traversal" + 
						" of constructed tree is : "); 
		tree.preOrder(tree.root); 
	} 
}

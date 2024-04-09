class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeInverter {

    public TreeNode invertTree(TreeNode root) {
        swaptree(root);
        return root;
    }
    public void swaptree(TreeNode root)
    {
        if(root==null)
            return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        swaptree(root.left);
        swaptree(root.right);
    }
    // Method to print the tree using inorder traversal
    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }
}

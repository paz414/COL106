/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> l =new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return l;
    }
    public void inorder(TreeNode node){
        if(node==null)
            return;
        inorder(node.left);
        l.add(node.val);
        inorder(node.right);
    }
}

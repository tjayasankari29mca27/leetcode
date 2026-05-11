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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        // Use a very small value for prev initial comparison
        // But since nodes can be Integer.MIN_VALUE, null is safer for a real prev
        prev = null; 
        
        traverse(root);

        // Swap the values of the two nodes found
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);

        // Detect out-of-order nodes
        if (prev != null && prev.val > root.val) {
            // First occurrence: 'prev' is the node to be swapped
            if (first == null) {
                first = prev;
            }
            // Second occurrence (or same if adjacent): 'root' is the node
            second = root;
        }
        
        prev = root;

        traverse(root.right);
    }
}

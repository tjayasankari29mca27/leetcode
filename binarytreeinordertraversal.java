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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current subtree
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // Process the node
            curr = stack.pop();
            res.add(curr.val);
            
            // Move to the right subtree
            curr = curr.right;
        }
        return res;
    }
}

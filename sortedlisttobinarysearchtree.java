/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // Base cases: empty list or single node
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        
        // Find the middle of the linked list
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Disconnect the left half of the list from the middle node
        if (prev != null) {
            prev.next = null;
        }
        
        // The middle node becomes the root of our BST
        TreeNode root = new TreeNode(slow.val);
        
        // Recursively build left and right subtrees
        root.left = sortedListToBST(head);      // Head to prev
        root.right = sortedListToBST(slow.next); // slow.next to end
        
        return root;
    }
}

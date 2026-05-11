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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Duplicate found: skip the next node by linking 
                // the current node to the one after the next
                current.next = current.next.next;
            } else {
                // No duplicate: just move to the next node
                current = current.next;
            }
        }
        
        return head;
    }
}

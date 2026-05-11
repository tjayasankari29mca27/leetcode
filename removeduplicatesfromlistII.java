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
        // Sentinel node to handle cases where the head is a duplicate
        ListNode sentinel = new ListNode(0, head);
        
        // 'pred' is the last node known to be part of the distinct list
        ListNode pred = sentinel;
        
        while (head != null) {
            // If it's a start of duplicates sequence
            if (head.next != null && head.val == head.next.val) {
                // Move head until it's the last node of the duplicates sequence
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Skip all duplicates by linking pred to the node after the sequence
                pred.next = head.next;
            } else {
                // Not a duplicate, move pred forward
                pred = pred.next;
            }
            // Move head forward
            head = head.next;
        }
        
        return sentinel.next;
    }
}

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
    public ListNode partition(ListNode head, int x) {
        // Dummy heads for our two temporary lists
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        
        // Pointers to the current last node in our two lists
        ListNode less = lessHead;
        ListNode greater = greaterHead;
        
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        
        // Prevent cycles: the last node of the greater list should point to null
        greater.next = null;
        
        // Connect the 'less' list to the 'greater' list
        less.next = greaterHead.next;
        
        return lessHead.next;
    }
}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy node to act as the starting point
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        // Loop through both lists
        while (l1 != null || l2 != null || carry != 0) {
            // Get values (use 0 if list has ended)
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            // Calculate sum and carry
            int sum = carry + x + y;
            carry = sum / 10;
            int digit = sum % 10;

            // Create new node for the result
            curr.next = new ListNode(digit);
            curr = curr.next;

            // Move pointers forward
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the actual head (skipping the dummy 0)
        return dummyHead.next;
    }
}

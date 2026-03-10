/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    // Create a dummy node to handle edge cases like removing the head
    let dummy = new ListNode(0);
    dummy.next = head;
    
    let fast = dummy;
    let slow = dummy;

    // 1. Move the fast pointer n + 1 steps ahead
    for (let i = 0; i <= n; i++) {
        fast = fast.next;
    }

    // 2. Move both pointers until fast reaches the end
    while (fast !== null) {
        fast = fast.next;
        slow = slow.next;
    }

    // 3. slow is now at the node BEFORE the one to be removed
    // Skip the target node
    slow.next = slow.next.next;

    // Return the head (which is dummy.next)
    return dummy.next;
};

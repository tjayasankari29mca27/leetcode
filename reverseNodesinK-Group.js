/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
    // 1. Check if there are at least k nodes left
    let ptr = head;
    let count = 0;
    while (count < k && ptr !== null) {
        ptr = ptr.next;
        count++;
    }

    // 2. If we found k nodes, reverse them
    if (count === k) {
        let prev = null;
        let curr = head;
        let nextNode = null;

        // Standard iterative reversal logic for exactly k nodes
        for (let i = 0; i < k; i++) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // 3. 'curr' is now the head of the next group. 
        // Recurse and connect the end of our current reversed group 
        // (which is 'head') to the result of the next reversed group.
        if (nextNode !== null) {
            head.next = reverseKGroup(nextNode, k);
        }

        // 4. 'prev' is now the new head of the reversed group
        return prev;
    }

    // 5. If we found fewer than k nodes, return head as is
    return head;
};

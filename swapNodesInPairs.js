/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
    // 1. Create a dummy node pointing to the head
    let dummy = new ListNode(0);
    dummy.next = head;
    
    // 2. 'prev' represents the node immediately before the pair we want to swap
    let prev = dummy;

    // 3. Loop as long as there's a pair available to swap
    while (prev.next !== null && prev.next.next !== null) {
        // Nodes to be swapped
        let first = prev.next;
        let second = prev.next.next;

        // 4. Perform the pointer rearrangement (The actual swap)
        first.next = second.next; // First points to the start of next pair
        second.next = first;      // Second points back to First
        prev.next = second;       // Prev points to Second (new start of pair)

        // 5. Move 'prev' two nodes ahead for the next iteration
        prev = first;
    }

    // Return the new head (which is the node after dummy)
    return dummy.next;
};

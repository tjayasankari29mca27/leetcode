/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function(list1, list2) {
    // 1. Initialize a dummy node and a pointer 'current'
    let dummy = new ListNode(0);
    let current = dummy;

    // 2. Iterate while both lists have nodes
    while (list1 !== null && list2 !== null) {
        if (list1.val <= list2.val) {
            // Attach list1 node and move list1 pointer
            current.next = list1;
            list1 = list1.next;
        } else {
            // Attach list2 node and move list2 pointer
            current.next = list2;
            list2 = list2.next;
        }
        // Move the merged list pointer forward
        current = current.next;
    }

    // 3. If one list is exhausted, attach the remainder of the other
    if (list1 !== null) {
        current.next = list1;
    } else if (list2 !== null) {
        current.next = list2;
    }

    // 4. Return the head of the merged list (skip the dummy)
    return dummy.next;
};

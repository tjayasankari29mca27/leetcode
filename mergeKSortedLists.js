/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */

/**
 * Helper function to merge two sorted linked lists
 */
var mergeTwoLists = function(l1, l2) {
    let dummy = new ListNode(0);
    let current = dummy;

    while (l1 !== null && l2 !== null) {
        if (l1.val <= l2.val) {
            current.next = l1;
            l1 = l1.next;
        } else {
            current.next = l2;
            l2 = l2.next;
        }
        current = current.next;
    }
    current.next = l1 || l2;
    return dummy.next;
};

/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {
    if (!lists || lists.length === 0) return null;

    // Continue merging pairs until only one list remains
    while (lists.length > 1) {
        let mergedLists = [];

        for (let i = 0; i < lists.length; i += 2) {
            let l1 = lists[i];
            // If there's no second list (odd number of lists), just pass null
            let l2 = (i + 1 < lists.length) ? lists[i + 1] : null;
            
            mergedLists.push(mergeTwoLists(l1, l2));
        }
        
        // Update the main lists array with the newly merged pairs
        lists = mergedLists;
    }

    return lists[0];
};

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    
    /**
     * Adds two numbers stored as ListNode objects.
     * Numbers are stored in reverse order without leading zeros.
     * eg. 342 is stored as 2 -> 4 -> 3
     * @param l1 The first number stored as a ListNode.
     * @param l2 The first number stored as a ListNode.
     * @return ListNode This returns the sum of l1 and l2.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers_recursive(l1, l2, 0);
    }
    
    /**
     * Helper method for addTwoNumbers().
     * @param l1 The first number stored as a ListNode.
     * @param l2 The first number stored as a ListNode.
     * @return ListNode This returns the sum of l1 and l2.
     */
    private ListNode addTwoNumbers_recursive(ListNode l1, ListNode l2, int carry) {
        // the algorithm resembles adding 2 numbers by hand, with carry, remainder, etc...
        // init total
        int total;
        
        // base case
        if (l1 == null || l2 == null) {
            
            // case: l1 is not null, l2 is null
            if (l1 != null) {
                total = l1.val + carry;
                    
                if (total < 10) {
                    return new ListNode(total, l1.next);
                }
                
                return new ListNode(total % 10, addTwoNumbers_recursive(l1.next, null, total / 10));
            }
            
            // case: l1 is null, l2 is not null
            if (l2 != null) {
                total = l2.val + carry;
                    
                if (total < 10) {
                    return new ListNode(total, l2.next);
                }
                
                return new ListNode(total % 10, addTwoNumbers_recursive(l2.next, null, total / 10));
            }
            
            // case: both are null
            return (carry == 0) ? null : new ListNode(carry);
        }
        
        // sum the heads of l1, l2, carry
        total = l1.val + l2.val + carry;

        // get the rest of the sum through recursion
        // (total/10 is the carry number for the next operation)
        ListNode rest = addTwoNumbers_recursive(l1.next, l2.next, total / 10);
        
        // return sum as a ListNode
        // (total % 10 gives the ones digit of total)
        return new ListNode(total % 10, rest);
    }
    
}
// 24. Swap Nodes in Pairs
// https://leetcode.com/problems/swap-nodes-in-pairs/


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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            
            first.next = second.next;
            second.next = first;
            curr.next = second;
            curr = curr.next.next;
        }
        
        return dummy.next;
    }
}

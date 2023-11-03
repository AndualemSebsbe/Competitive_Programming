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
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, cur = head;

        while(cur != null && cur.next != null){
            // save pointers
            ListNode nextPairs = cur.next.next;
            ListNode second = cur.next;

            // reverse this pair
            second.next = cur;
            cur.next = nextPairs;
            prev.next = second;

            // update pointers
            prev = cur;
            cur = nextPairs;
        }

        return dummy.next;
    }
}
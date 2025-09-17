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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);

        // 1) reach node at position "left"
        ListNode leftPrev = dummy, cur = head;
        for(int i = 0; i < left - 1; i++){
            leftPrev = cur;
            cur = cur.next;
        }

        // cur = "left", leftPrev = "node before left"
        // 2) reverse from left to right
        ListNode prev = null;
        for(int i = 0; i < right - left + 1; i++){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // 3) update pointers
        leftPrev.next.next = cur;
        leftPrev.next = prev;

        return dummy.next;
    }
}
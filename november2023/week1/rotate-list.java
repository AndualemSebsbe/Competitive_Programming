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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
        
        ListNode tail = head;
        int len = 1;
        while(tail.next != null){
            tail = tail.next;
            len += 1;
        }

        k = k % len;
        if(k == 0)
            return head;

        ListNode curr = head;
        int shift = len - k - 1;
        while(shift-- > 0)
            curr = curr.next;

        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;

        return newHead;
    }
}
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
    public ListNode doubleIt(ListNode head) {
        ListNode newHead = reverseList(head);
        
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        while(newHead != null){
            int val = newHead.val * 2 + carry;
            int rem = val % 10;
            ListNode node = new ListNode(rem);
            res.next = node;
            res = res.next;
            newHead = newHead.next;
            carry = val / 10;
        }

        if(carry != 0)
            res.next = new ListNode(carry);

        ListNode ans = reverseList(dummy.next);
        return ans;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next;
        ListNode cur = head;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
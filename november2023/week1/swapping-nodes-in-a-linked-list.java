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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        
        while(k-- > 1)
            cur = cur.next;

        ListNode left = cur;
        ListNode dummy = new ListNode(0, head);
        ListNode right = dummy;
        while(cur != null){
            cur = cur.next;
            right = right.next;
        }
        
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        
        return head;
    }
}
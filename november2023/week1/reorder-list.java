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
    public void reorderList(ListNode head) {
        ListNode fast = head.next, slow = head;
        // Finding middle(slow)
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse second half        
        ListNode right = slow.next;
        ListNode prev = slow.next = null;
        while(right != null){
            ListNode next = right.next;
            right.next = prev;
            prev = right;
            right = next;
        }

        ListNode left = head; right = prev;
        while(right != null){
            ListNode lTemp = left.next, rTemp = right.next;
            
            left.next = right;
            right.next = lTemp;
            left = lTemp;
            right = rTemp;
        }
    }
}
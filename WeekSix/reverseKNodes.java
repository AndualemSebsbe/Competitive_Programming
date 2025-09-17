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
class reverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr != null){
            ListNode tail = curr;
            int listIndx = 0;
            while(curr != null && listIndx < k){
                curr = curr.next;
                listIndx++;
            }
            if(listIndx != k){
                prev.next = tail;
            }
            else
            {
                prev.next = reverse(tail, k);
                prev = tail;
            }
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode tail, int k){
        ListNode prev = null;
        ListNode curr = tail;
        ListNode next =null;
        while(k-- > 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        tail = prev;
        return tail;
    }
}
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
class removeDuplicateFromListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode head1 = head;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while(head1 != null){
            if(head1.next != null && head1.val == head1.next.val){
            while(head1.next != null && head1.val == head1.next.val)
                head1.next = head1.next.next;
            prev.next = head1.next;
          }
            else
           {
            prev = prev.next;
           }
            head1 = head1.next;
        }
      
        return dummy.next;
    }
}
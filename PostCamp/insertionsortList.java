
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
 class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

public class insertionsortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = head, cur = head.next;

        while(cur != null){
            if(cur.val >= prev.val){
                prev = cur;
                cur = cur.next;
                continue;
            }

            ListNode temp = dummy;
            while(cur.val > temp.next.val)
                temp = temp.next;
            
            prev.next = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            cur = prev.next; 
        }

        return dummy.next;
    }
}
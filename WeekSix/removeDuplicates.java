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
class removeDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tempNode = head;
        if(head == null || head.next == null)
            return head;
        while(tempNode.next != null){
            while(tempNode.next != null && tempNode.val == tempNode.next.val) //[1,1,2,3,3]
                tempNode.next = tempNode.next.next;
            if(tempNode.next != null)
            tempNode = tempNode.next;
        }
        return head;
    }
}
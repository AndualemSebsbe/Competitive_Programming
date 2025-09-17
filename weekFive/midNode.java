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
class midNode {
    public ListNode middleNode(ListNode head) {
        ListNode start = head;
        int count = 0;
        while(head != null){
           head = head.next;
            count++;
        }
        int temp = count/2;
        while(temp > 0){
            start = start.next;
            temp--;
        }
        return start;
    }
}
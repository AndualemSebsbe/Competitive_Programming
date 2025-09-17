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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int idx = 0;
        ListNode dummy = new ListNode();
        dummy.next = list1;
        ListNode cur = list1;
        ListNode list2Tail = list2;
        while(list2Tail.next != null)
            list2Tail = list2Tail.next;

        ListNode curA = new ListNode();
        while(idx <= b){
            if(idx == a - 1){
              curA = cur;
            }

            if(idx == b){
                list2Tail.next = cur.next;
                // cur.next = 
            }

            cur = cur.next;
            idx += 1;
        }

        curA.next = list2;

        return dummy.next;
    }
}
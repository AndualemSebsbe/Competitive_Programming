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
    public ListNode mergeNodes(ListNode head) {
        ListNode node = head;

        while(node != null){
            if(node.next == null){
                node = null;
                break;
            }

            int sum = 0;
            ListNode tempNode = node;
            node = node.next;
            while(node.val != 0){
                sum += node.val;
                node = node.next;
            }

            tempNode.next = node;
            tempNode.next.val = sum;
        }

        return head.next;
    }
}
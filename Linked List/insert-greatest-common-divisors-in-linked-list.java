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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            int num1 = cur.val;
            int num2 = cur.next.val;

            int gcdRes = gcd(num1, num2);
            ListNode node = new ListNode(gcdRes);
            ListNode nextNode = cur.next;
            cur.next = node;
            node.next = nextNode;
            cur = nextNode;
        }

        return head;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        
        return gcd(b, a % b);
    }
}
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n += 1;
            cur = cur.next;
        }

        int division = n / k;
        int rem = n % k;
        int[] sizes = new int[k];
        Arrays.fill(sizes, division);
        
        int idx = 0;
        while (rem-- > 0)
            sizes[idx++] += 1;
        
        idx = 0;
        ListNode[] res = new ListNode[k];
        while (head != null) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            cur = dummy;
            while (sizes[idx]-- > 0) {
                cur.next = head;
                cur = cur.next;
                head = head.next;
            }

            cur.next = null;
            res[idx++] = dummy.next;
        }

        return res;
    }
}
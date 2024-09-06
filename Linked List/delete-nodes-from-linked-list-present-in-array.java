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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet();
        for (int num : nums)
            set.add(num);
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;

        while (head != null) {
            if (set.contains(head.val))
                cur.next = head.next;
            else
                cur = cur.next;
            
            head = head.next;
        }

        return dummy.next;
    }
}
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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap();
        int sum = 0;
        map.put(sum, dummy);
        while(head != null){
            sum += head.val;
            if(map.containsKey(sum)){
                ListNode toRemove = map.get(sum).next;
                int SUM = sum;
                while(toRemove != head){
                    SUM += toRemove.val;
                    map.remove(SUM);
                    toRemove = toRemove.next;
                }

                map.get(sum).next = head.next;
            }
            else
                map.put(sum, head);

            head = head.next;
        }

        return dummy.next;
    }
}
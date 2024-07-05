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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList();
        int idx = 0;
        ListNode prev = null, curr = head;
        while(curr != null){
            if(prev != null && curr.next != null){
                if(curr.val < prev.val && curr.val < curr.next.val)
                    list.add(idx);
                else if(curr.val > prev.val && curr.val > curr.next.val)
                    list.add(idx);
            }

            prev = curr;
            curr = curr.next;
            idx += 1;
        }

        int n = list.size();
        if(n < 2)
            return new int[]{-1, -1};

        int maxDist = list.get(n - 1) - list.get(0);
        int minDist = idx;
        for(int i = 1; i < n; i++)
            minDist = Math.min(minDist, list.get(i) - list.get(i - 1));
        
        return new int[]{minDist, maxDist};
    }
}
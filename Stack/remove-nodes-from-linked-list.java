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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> st = new Stack();
        while(head != null){
            while(!st.isEmpty() && st.peek() < head.val)
                st.pop();
            
            st.add(head.val);
            head = head.next;
        }

        int[] vals = new int[st.size()];
        int idx = st.size() - 1;
        while(!st.isEmpty())
            vals[idx--] = st.pop();

        // System.out.println(Arrays.toString(vals));

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        for(int i = 0; i < vals.length; i++){
            ListNode node = new ListNode(vals[i]);
            res.next = node;
            res = res.next;
        }

        return dummy.next;
    }
}

//   Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    ListNode node;
    public boolean isPalindrome(ListNode head) {
        if(node == null) node = head;
        if(head == null) return true;
        
        boolean flag = isPalindrome(head.next) && node.val == head.val;
        node = node.next;
        
        return flag;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
    val = x;
    next = null;
    }
 }
public class intersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    while( a != b){
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}
}
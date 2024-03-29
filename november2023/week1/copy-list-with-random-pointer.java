/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap();
        Node cur = head;
        map.put(null, null);
        while(cur != null){
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            cur = cur.next;
        }

        cur = head;
        while(cur != null){
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
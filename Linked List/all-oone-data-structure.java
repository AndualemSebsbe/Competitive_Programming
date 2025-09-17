public class Node {
    int count;
    Set<String> keySet;
    Node next;
    Node prev;
    
    public Node(int count) {
        this.count = count;
        keySet = new HashSet<>();
    }
}

class AllOne {
    private Node head;
    private Node tail;
    private Map<Integer, Node> countNodeMap;
    private Map<String, Integer> keyCountMap;


    public AllOne() {
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        countNodeMap = new HashMap<>();
        keyCountMap = new HashMap<>();
    }
    
    public void inc(String key) {
        if (keyCountMap.containsKey(key))
            changeKey(key, 1);
        else {
            keyCountMap.put(key, 1);
            if (head.next.count != 1) 
                addNodeAfter(new Node(1), head);

            head.next.keySet.add(key);
            countNodeMap.put(1, head.next);
        }
    }
    
    public void dec(String key) {
        if (keyCountMap.containsKey(key)) {
            int count = keyCountMap.get(key);
            if (count == 1) {
                keyCountMap.remove(key);
                removeKeyFromNode(countNodeMap.get(count), key);
            } 
            else
                changeKey(key, -1);
        }
    }
    
    public String getMaxKey() {
        return tail.prev == head ? "" : (String) tail.prev.keySet.iterator().next();
    }
    
    public String getMinKey() {
        return head.next == tail ? "" : (String) head.next.keySet.iterator().next();        
    }
    
    private void changeKey(String key, int offset) {
        int count = keyCountMap.get(key);
        keyCountMap.put(key, count + offset);
        Node curNode = countNodeMap.get(count);
        Node newNode;
        if (countNodeMap.containsKey(count + offset)) {
            newNode = countNodeMap.get(count + offset);
        } else {
            newNode = new Node(count + offset);
            countNodeMap.put(count + offset, newNode);
            addNodeAfter(newNode, offset == 1 ? curNode : curNode.prev);
        }
        
        newNode.keySet.add(key);
        removeKeyFromNode(curNode, key);
    }
    
    private void removeKeyFromNode(Node Node, String key) {
        Node.keySet.remove(key);
        if (Node.keySet.size() == 0) {
            removeNodeFromList(Node);
            countNodeMap.remove(Node.count);
        }
    }
    
    private void removeNodeFromList(Node Node) {
        Node.prev.next = Node.next;
        Node.next.prev = Node.prev;
        Node.next = null;
        Node.prev = null;
    }
    
    private void addNodeAfter(Node newNode, Node prevNode) {
        newNode.prev = prevNode;
        newNode.next = prevNode.next;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }
}
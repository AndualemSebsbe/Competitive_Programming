class Node {
    int key, val;
    Node prev, next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int cap;
    Map<Integer, Node> cache = new HashMap();
    Node left = new Node(0, 0);;
    Node right = new Node(0, 0);;
    public LRUCache(int capacity) {
        cap = capacity;
        left.next = right;
        right.prev = left;
    }
    
    void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    void insert(Node node){
        Node prevNode = right.prev;
        Node nextNode = right;

        prevNode.next = nextNode.prev = node;
        node.next = nextNode;
        node.prev = prevNode;
    }
    public int get(int key) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));

            return cache.get(key).val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key))
            remove(cache.get(key));

        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if(cache.size() > cap){
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
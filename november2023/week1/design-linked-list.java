class MyLinkedList {
    ListNode head;
    int length;
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }
    
    public int get(int index) {
        if(index >= length)
            return -1;

        ListNode cur = head;
        while(index-- > 0)
            cur = cur.next;
        return cur.val;
    }
    
    public void addAtHead(int val) {
        ListNode dummy = new ListNode(val);
        dummy.next = head;
        head = dummy;
        length += 1;
    }
    
    public void addAtTail(int val) {
        if(head == null){
            addAtHead(val);
            return;
        }
        
        ListNode cur = head;
        while(cur.next != null)
            cur = cur.next;
        cur.next = new ListNode(val);
        length += 1;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > length)
            return;

        ListNode cur = head;
        if(index == 0){
            addAtHead(val);
            return;
        }

        while(index-- > 1)
            cur = cur.next;

        ListNode temp = cur.next;
        cur.next = new ListNode(val);
        cur.next.next = temp;
        length += 1;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= length)
            return;

        length -= 1;
        ListNode cur = head;
        if(index == 0){
            cur = cur.next;
            head = cur;
            return;
        }

        while(index-- > 1)
            cur = cur.next;
        cur.next = cur.next.next;       
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
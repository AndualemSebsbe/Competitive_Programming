class MyCircularQueue {
    int front, rear, k;
    int[] arr = new int[1000];
    public MyCircularQueue(int k) {
        this.k = k;
        rear = 0;
        front = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        arr[rear%k] = value;
        rear += 1;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
            return false;
        front += 1;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : arr[front%k];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : arr[(rear-1)%k];
    }
    
    public boolean isEmpty() {
        if(rear == front)
            return true;
        return false;
    }
    
    public boolean isFull() {
        if(rear - front == k)
            return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
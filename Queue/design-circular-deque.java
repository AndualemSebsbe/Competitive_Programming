class MyCircularDeque {
    private static int k;
    private int[] queue;
    int front = 0, rear = 0, size = 0;

    public MyCircularDeque(int k) {
        this.k = k;
        queue = new int[k];
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;
        
        if (isEmpty()) {
            front = rear = 0;

            queue[front] = value;
            size += 1;
            return true;
        }

        if (front == 0) 
            front = k;
        
        front -= 1;
        front = front % k;
        queue[front] = value;
        size += 1;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;
        
        if (isEmpty()) {
            front = rear = 0;
            queue[rear] = value;
            size += 1;
            return true;
        }

        rear += 1;
        rear = rear % k;
        queue[rear] = value;
        size += 1;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        
        front += 1;
        front = front % k;
        size -= 1;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;

        rear -= 1;
        rear = rear % k;
        if (rear == -1)
            rear = k - 1;

        size -= 1;
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;

        return queue[front];
    }

    public int getRear() {
        if (isEmpty())
            return -1;

        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
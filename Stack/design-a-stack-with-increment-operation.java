class CustomStack {
    int[] stack;
    int size;
    int maxSize;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        size = 0;
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if (isFull())
            return;
        
        stack[size] = x;
        size += 1;
    }
    
    public int pop() {
        if (isEmpty())
            return -1;
        
        size -= 1;
        return stack[size];
    }
    
    public void increment(int k, int val) {
        int idx = 0;
        while (idx < k && idx < size) {
            stack[idx] += val;
            idx += 1;
        }
    }

    private boolean isFull() {
        if (size == maxSize)
            return true;

        return false;
    }

    private boolean isEmpty() {
        if (size == 0)
            return true;
        
        return false;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
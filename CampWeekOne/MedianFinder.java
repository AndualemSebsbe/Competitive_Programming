import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> minHeap ;
    PriorityQueue<Integer> maxHeap ;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> (b - a));
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(maxHeap.size() < minHeap.size())                                                                            
        maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
       // if(maxHeap.size() == 0) return 0;
       return (maxHeap.size() > minHeap.size()) ? maxHeap.peek() : 
              (double)(maxHeap.peek() + minHeap.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
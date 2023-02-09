class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    
    public MedianFinder() {
        this.min = new PriorityQueue<>();
        this.max = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int x) {
        if(max.isEmpty() || max.peek() >= x)
            max.offer(x);
        else
            min.offer(x);
        
        if(Math.abs(min.size() - max.size()) <= 1)
            return;
        
        if(min.size() > max.size()){
            int temp = min.poll();
            max.offer(temp);
        }
        else{
            int temp = max.poll();
            min.offer(temp);
        }
    }
    
    public double findMedian() {
        if(min.size() > max.size())
            return min.peek();
        
        else if(min.size() < max.size())
            return max.peek();
        
        double x = min.peek();
        double y = max.peek();
        
        return (x+y)/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
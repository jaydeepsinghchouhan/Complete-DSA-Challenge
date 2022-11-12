class MedianFinder {
    PriorityQueue<Integer> min=new PriorityQueue<>(); //store element in ascending or we can say second half
    PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder()); //store element in descending order i.e first half
    boolean even=true;
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(even){ //if even then we add in first half but not directly instead we add in seond half then takes its min value andd add it in first half because smallest element of min is largest of first
            min.offer(num);
            max.offer(min.poll());
        }
        else{
            max.offer(num);    // else vise versa
            min.offer(max.poll());
        }
        even=!even; //if even is true making false else true
    }
    
    public double findMedian() {
        if(even){
            return (min.peek()+max.peek())/2.0;
        }
        else{
            return max.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
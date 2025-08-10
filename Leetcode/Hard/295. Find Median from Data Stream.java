class MedianFinder {
    public PriorityQueue<Integer> left;
    public PriorityQueue<Integer> right;

    public MedianFinder() {
        left=new PriorityQueue<>(Collections.reverseOrder());
        right=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.offer(num); //always push incoming value in left;

        //check for all values of left <= right;
        if(!left.isEmpty() && !right.isEmpty() && left.peek()>right.peek()){
            right.offer(left.poll()); //take value from left out into right
        }

        if(left.size()>right.size()+1){ //if left has 2 more number of elements 
            right.offer(left.poll());
        }
        if(right.size()>left.size()+1){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()){
            return (left.peek()+right.peek())/2.0;
        }
        if(left.size()>right.size()){
            return left.peek();
        }
        else{
            return right.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

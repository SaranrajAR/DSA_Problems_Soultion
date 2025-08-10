class KthLargest {
    public PriorityQueue<Integer> minHeap;
    int size;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        minHeap=new PriorityQueue<>();
        size=0;
        for(int num:nums){
            minHeap.offer(num);
            size++;
            if(size>k){
                minHeap.poll();
                size--;
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        size++;
        if(size>k){
            minHeap.poll();
            size--;
        }
        return minHeap.peek();

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

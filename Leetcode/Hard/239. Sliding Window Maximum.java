class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] arr=new int[n-k+1];
        int idx=0;
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.getFirst() <= i-k) dq.removeFirst();
            while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                arr[idx]=nums[dq.getFirst()];
                idx++;
            }
        }
        return arr;
        
    }
}

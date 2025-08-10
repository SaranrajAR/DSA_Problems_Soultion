class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        int ans=0;
        for(int num:arr){
            minHeap.offer(num);
        }
        while(minHeap.size()>1){
            int f=minHeap.poll();
            int s=minHeap.poll();
            int sum=f+s;
            minHeap.offer(sum);
            ans+=sum;
        }
        return ans;
    }
}

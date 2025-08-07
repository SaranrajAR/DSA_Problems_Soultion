class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i=0;i<k+1 && i<arr.length;i++){
            queue.offer(arr[i]);
        }
        
        int idx=0;
        for(int i=k+1;i<arr.length;i++){
            arr[idx++]=queue.poll();
            
            queue.offer(arr[i]);
        }
        
        while(!queue.isEmpty()){
            arr[idx++]=queue.poll();
        }
    }
}

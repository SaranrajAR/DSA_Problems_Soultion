class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        int[] freq=new int[26];
        for(char task:tasks){
            freq[task-'A']++;
        }
        for(int f:freq){
            if(f>0) maxHeap.offer(f);
        }

        int time=0;
        Queue<int[]> cooldown=new LinkedList<>();
        while(!maxHeap.isEmpty() || !cooldown.isEmpty()){
            time++;
            if(!cooldown.isEmpty() && cooldown.peek()[1]==time){
                maxHeap.offer(cooldown.poll()[0]);
            }
            if(!maxHeap.isEmpty()){
                int curr=maxHeap.poll();
                if(curr-1 > 0){
                    cooldown.offer(new int[]{curr-1,time+1+n});
                }
            }
        }
        return time;

    }
}

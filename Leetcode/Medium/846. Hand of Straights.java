class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int h:hand){
            map.put(h,map.getOrDefault(h,0)+1);
            if(map.get(h)==1) minHeap.offer(h);
        }

        while(!minHeap.isEmpty() && !map.isEmpty()){
            int curr=minHeap.peek();
            for(int i=0;i<groupSize;i++){
                if(!map.containsKey(curr)) return false;
                int val=map.get(curr);
                val--;
                map.put(curr,val);
                if(val==0){
                    map.remove(curr);
                    minHeap.poll();
                } 
                curr++;
            }
        }
        return true;
    }
}

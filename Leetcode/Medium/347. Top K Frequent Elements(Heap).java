class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket=new ArrayList[nums.length+1];
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>((a,b) -> b.second-a.second);

        for(int key:map.keySet()){
            Pair temp=new Pair(key,map.get(key));
            maxHeap.offer(temp);
        }
        int[] res=new int[k];
        int idx=0;

        for(int i=0;i<k;i++){
            Pair temp=maxHeap.poll();
            res[idx++]=temp.first;

        }
        
        return res;

        
    }
}

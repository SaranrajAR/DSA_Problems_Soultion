class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket=new ArrayList[nums.length+1];
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key:map.keySet()){
            int val=map.get(key);
            if(bucket[val]==null){
                bucket[val]=new ArrayList<>();
            }
            bucket[val].add(key);
        }
        int[] res=new int[k];
        for(int i=bucket.length-1; i>=0 && k>0 ;i--){
            if(bucket[i]!=null){
                for(int num:bucket[i]){
                    res[--k]=num;
                }
            }
        }
        return res;

        
    }
}

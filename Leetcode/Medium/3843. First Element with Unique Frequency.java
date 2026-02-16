class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer,Integer> freqMap=new HashMap<>();
        Map<Integer,Integer> freqCount=new HashMap<>();
        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        for(int key:freqMap.keySet()){
            int freq=freqMap.get(key);
            freqCount.put(freq,freqCount.getOrDefault(freq,0)+1);
        }
        for(int num:nums){
            int freq=freqMap.get(num);
            if(freqCount.get(freq)==1) return num;
        }
        return -1;
        
        

    }
}

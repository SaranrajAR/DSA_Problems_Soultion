class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxFreq=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            maxFreq=Math.max(map.get(num),maxFreq);
        }
        int ans=0;
        for(int val:map.values()){
            if(val==maxFreq) ans+=val;
        }
        return ans;
    }
}

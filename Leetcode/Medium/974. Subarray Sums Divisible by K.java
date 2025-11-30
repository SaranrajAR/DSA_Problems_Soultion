class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefixSum=0;
        int prefixMod=0;
        map.put(0,1);
        int ans=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            prefixMod=prefixSum%k;
            if(prefixMod<0) prefixMod=(prefixMod+k)%k;  // Mainting as positive remainder
            if(map.containsKey(prefixMod)){
                int curr=map.get(prefixMod);
                ans+=curr; 
            }
            map.put(prefixMod,map.getOrDefault(prefixMod,0)+1);
        }
        return ans;
    }
}

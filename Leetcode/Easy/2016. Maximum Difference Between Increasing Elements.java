class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff=0;
        int minVal=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>minVal){
                maxDiff=Math.max(maxDiff,nums[i]-minVal);
            }
            minVal=Math.min(nums[i],minVal);
        }
        return maxDiff!=0?maxDiff:-1;
        
    }
}

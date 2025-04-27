class Solution {
    public int countSubarrays(int[] nums) {
        int count=0;
        for(int i=0;i<=nums.length-3;i++){
            double mid=(double) nums[i+1]/2.0;
            if(nums[i]+nums[i+2]==(mid)) count++;
        }
        return count;
        
    }
}

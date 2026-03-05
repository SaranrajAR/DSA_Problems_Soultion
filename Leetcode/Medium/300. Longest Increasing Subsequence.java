class Solution {
    public int helper(int[] nums,int idx,int prevIdx,int[][] dp){
        if(idx==nums.length) return 0;
        if(dp[idx][prevIdx]!=0) return dp[idx][prevIdx];
        int notPick=helper(nums,idx+1,prevIdx,dp);
        int pick=0;
        if(prevIdx==0 || nums[idx]>nums[prevIdx-1]){
            pick=1+helper(nums,idx+1,idx+1,dp);
        }
        return dp[idx][prevIdx]=Math.max(pick,notPick);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        return helper(nums,0,0,dp);
    }
}

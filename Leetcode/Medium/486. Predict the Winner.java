class Solution {
    public int helper(int[] nums,int l,int r,int[][] dp){
        if(l==r) return nums[l];
        if(dp[l][r]!=-1) return dp[l][r];
        int pickLeft=nums[l]-helper(nums,l+1,r,dp);
        int pickRight=nums[r]-helper(nums,l,r-1,dp);
        return dp[l][r]=Math.max(pickLeft,pickRight);

    }
    public boolean predictTheWinner(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int n=r+1;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int ans=helper(nums,l,r,dp);
        return ans>=0;
    }
}

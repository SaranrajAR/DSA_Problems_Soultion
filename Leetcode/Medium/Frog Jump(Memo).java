class Solution {
    int helper(int[] height,int idx,int[] dp){
        
        if(idx==0) return 0;
        
        if(dp[idx]!=-1) return dp[idx];
        int left=helper(height,idx-1,dp)+Math.abs(height[idx-1]-height[idx]);
        int right=Integer.MAX_VALUE;
        if(idx>1){
            right=helper(height,idx-2,dp)+Math.abs(height[idx-2]-height[idx]);
        }
        dp[idx]=Math.min(left,right);
        return Math.min(left,right);
        
        
    }
    int minCost(int[] height) {
        
        // code here
        int[] dp=new int[height.length+1];
        Arrays.fill(dp,-1);
        return helper(height,height.length-1,dp);
        
    }
}

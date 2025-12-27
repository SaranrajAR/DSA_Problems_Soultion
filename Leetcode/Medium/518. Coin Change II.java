class Solution {
    public int helper(int[] coins,int idx,int amount,int[][] dp){
        if(idx==0){
            if(amount % coins[0]==0) return dp[0][amount]=1;
            return dp[0][amount]=0;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int notPick=helper(coins,idx-1,amount,dp);
        int pick=0;
        if(amount>=coins[idx]) pick=helper(coins,idx,amount-coins[idx],dp);
        return dp[idx][amount]=pick+notPick;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return helper(coins,n-1,amount,dp);
    }
}

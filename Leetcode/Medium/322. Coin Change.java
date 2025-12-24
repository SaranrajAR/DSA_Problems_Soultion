class Solution {
    public int helper(int[] coins,int amount,int idx,int[][] dp){
        if(idx==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            return (int) 1e9;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        int notPick=helper(coins,amount,idx-1,dp);
        int pick=(int) 1e9;
        if(coins[idx]<=amount){
            pick=1+helper(coins,amount-coins[idx],idx,dp);
        }
        return dp[idx][amount]=Math.min(notPick,pick);
        
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // int res=helper(coins,amount,n-1,dp);
        // if(res>=(int) 1e9) return -1;
        // return res;
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i]=i/coins[0];
            else dp[0][i]=(int) 1e9;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notPick=dp[i-1][j];
                int pick=(int) 1e9;
                if(coins[i]<=j){
                    pick=1+dp[i][j-coins[i]];
                }
                dp[i][j]=Math.min(pick,notPick);
            }
        }
        return dp[n-1][amount]>=((int) 1e9 )?-1:dp[n-1][amount];
    }
}

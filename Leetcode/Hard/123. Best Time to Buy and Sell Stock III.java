class Solution {
    public int helper(int[] prices,int idx,int buy,int cap,int[][][] dp){
        if(idx==prices.length || cap==0) return 0;
        int profit=0;
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
        if(buy==1){
            profit=Math.max((-prices[idx]+helper(prices,idx+1,0,cap,dp)),(0+helper(prices,idx+1,1,cap,dp)));
        }
        else{
            profit=Math.max((prices[idx]+helper(prices,idx+1,1,cap-1,dp)),(helper(prices,idx+1,0,cap,dp)));
        }
        return dp[idx][buy][cap]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<2;j++) Arrays.fill(dp[i][j],-1);
        // }
        // return helper(prices,0,1,2,dp);
        for(int i=0;i<=n;i++){
            dp[i][0][0]=0;
            dp[i][1][0]=0;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=1;j>=0;j--){
                for(int k=2;k>=1;k--){
                    int profit=0;
                    if(j==1){
                        profit=Math.max((-prices[i]+dp[i+1][0][k]),(dp[i+1][1][k]));
                    }
                    else{
                        profit=Math.max((prices[i]+dp[i+1][1][k-1]),(dp[i+1][0][k]));
                    }
                    dp[i][j][k]=profit;
                }
            }
        }
        return dp[0][1][2];
    }
}

class Solution {
    public int helper(int[] prices,int i,int buy,int[][] dp){
        if(i>=prices.length) return 0;
        int curr=0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            curr=Math.max((-prices[i]+helper(prices,i+1,0,dp)),(0+helper(prices,i+1,1,dp)));
        }
        else{
            curr=Math.max((prices[i]+helper(prices,i+2,1,dp)),(0+helper(prices,i+1,0,dp)));
        }
        return dp[i][buy]=curr;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+2][2];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // return helper(prices,0,1,dp);
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                int curr=0;
                if(buy==1){
                    curr=Math.max((-prices[i]+dp[i+1][0]),(0+dp[i+1][1]));
                }
                else{
                    curr=Math.max((prices[i]+dp[i+2][1]),(0+dp[i+1][0]));
                }
                dp[i][buy]=curr;
            }
        }
        return dp[0][1];
    }
}

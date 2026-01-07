class Solution {
    public int helper(int[] prices,int i,int buy,int[][] dp){
        if(i==prices.length) return 0;
        int profit=0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            profit=Math.max((-prices[i]+helper(prices,i+1,0,dp)),(0+helper(prices,i+1,1,dp)));
        }
        else{
            profit=Math.max((prices[i]+helper(prices,i+1,1,dp)),(helper(prices,i+1,0,dp)));
        }
        return dp[i][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // return helper(prices,0,1,dp);
        int[] prev=new int[2];
        prev[0]=0;
        prev[0]=0;
        // dp[n][0]=0;
        // dp[n][1]=0;
        for(int i=n-1;i>=0;i--){
            int[] curr=new int[2];
            for(int j=1;j>=0;j--){
                
                int profit=0;
                if(j==1){
                    profit=Math.max((-prices[i]+prev[0]),(0+prev[1]));
                }
                else{
                    profit=Math.max((prices[i]+prev[1]),(prev[0]));
                }
                curr[j]=profit;

            }
            prev=curr;
        }
        return prev[1]; // why dp 1 we start recursion with buy --
    }
}

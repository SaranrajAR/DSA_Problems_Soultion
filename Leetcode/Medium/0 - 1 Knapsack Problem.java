class Solution {
    public int helper(int[] wt,int[] val,int capacity,int i,int[][] dp){
        if(i==0){
            if(wt[i]<=capacity) return val[0];
            return 0;
        }
        if(dp[i][capacity]!=-1) return dp[i][capacity];
        int notPick=helper(wt,val,capacity,i-1,dp);
        int pick=0;
        if(wt[i]<=capacity){
            pick=val[i]+helper(wt,val,capacity-wt[i],i-1,dp);
        }
        return dp[i][capacity]=Math.max(pick,notPick);
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=val.length;
        int[][] dp=new int[n][W+1];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // return helper(wt,val,W,n-1,dp);
        int capacity=W;
        for(W=wt[0];W<=capacity;W++) dp[0][W]=val[0];
        for(int i=1;i<n;i++){
            for(int cap=0;cap<=capacity;cap++){
                int notPick=dp[i-1][cap];
                int pick=0;
                if(wt[i]<=cap) pick=val[i]+dp[i-1][cap-wt[i]];
                dp[i][cap]=Math.max(pick,notPick);
            }
        }
        return dp[n-1][capacity];
    }
}

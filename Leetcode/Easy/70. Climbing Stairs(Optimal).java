class Solution {
    // public int helper(int n,int[] dp){
    //     if(n==0 || n==1) return 1;
    //     int l=0;
    //     if(dp[n-1]!=-1) l=dp[n-1]; 
    //     else l=helper(n-1,dp);
    //     int r=0;
    //     if(dp[n-2]!=-1) r=dp[n-2];
    //     else r=helper(n-2,dp);
    //     return l+r;
    // }
    // public int climbStairs(int n) {
    //     // int[] dp=new int[n+1];
    //     // Arrays.fill(dp,-1);
    //     // return helper(n,dp);

        
    // }
    // public int climbStairs(int n) {
    //     int[] dp=new int[n+1];
    //     int count=0;
    //     dp[0]=1;
    //     dp[1]=1;
    //     for(int i=2;i<=n;i++){
    //         dp[i]=dp[i-2]+dp[i-1];
    //     }
    //     return dp[n];

        
    // }
    public int climbStairs(int n) {
        int prev1=1;
        int prev2=1;
        for(int i=2;i<=n;i++){
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
            
        }
        return prev1;
    }
}

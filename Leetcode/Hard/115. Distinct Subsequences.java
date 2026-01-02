class Solution {
    public int helper(String s,String t,int idx1,int idx2,int[][] dp){
        if(idx2<0) return 1;
        if(idx1<0) return 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(s.charAt(idx1)==t.charAt(idx2)){
            return dp[idx1][idx2]=helper(s,t,idx1-1,idx2-1,dp)+helper(s,t,idx1-1,idx2,dp);
        }
        else return dp[idx1][idx2]=helper(s,t,idx1-1,idx2,dp);

    }
    public int numDistinct(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        int[][] dp=new int[n1+1][n2+1];
        // for(int i=0;i<n1;i++) Arrays.fill(dp[i],-1);
        // return helper(s,t,n1-1,n2-1,dp);
        for(int i=0;i<=n1;i++) dp[i][0]=1;
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n1][n2];
    }
}

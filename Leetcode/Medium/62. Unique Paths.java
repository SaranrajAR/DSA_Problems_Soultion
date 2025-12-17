class Solution {
    public int helper(int[][] dp,int m,int n){
        if(m==0 && n==0) return 1;
        if(m==-1 || n==-1) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        int up=helper(dp,m-1,n);
        int left=helper(dp,m,n-1);
        return dp[m][n]=up+left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        // for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        // return helper(dp,m-1,n-1);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[0][0]=1;
                else{
                    int up=0;
                    int left=0;
                    if(i-1 >=0) up=dp[i-1][j];
                    if(j-1 >=0) left=dp[i][j-1];
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}

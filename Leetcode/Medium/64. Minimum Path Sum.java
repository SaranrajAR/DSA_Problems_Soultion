class Solution {
    // public int helper(int[][] grid,int m,int n,int[][] dp){
    //     if(m==0 && n==0) return grid[0][0];
    //     if(dp[m][n]!=-1) return dp[m][n];
    //     int up=Integer.MAX_VALUE;
    //     int left=Integer.MAX_VALUE;
    //     if(m>0) up=grid[m][n]+helper(grid,m-1,n,dp);
    //     if(n>0) left=grid[m][n]+helper(grid,m,n-1,dp);
    //     return dp[m][n]=Math.min(up,left);
    // }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        // int[][] dp=new int[m][n];
        // // for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        // // return helper(grid,m-1,n-1,dp);

        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(i==0 && j==0) dp[i][j]=grid[i][j];
        //         else{
        //             int up=Integer.MAX_VALUE;
        //             int left=Integer.MAX_VALUE;
        //             if(i>0) up=grid[i][j]+dp[i-1][j];
        //             if(j>0) left=grid[i][j]+dp[i][j-1];
        //             dp[i][j]=Math.min(up,left);
        //         }
        //     }
        // }
        // return dp[m-1][n-1];

        int[] dp=new int[n];
        for(int i=0;i<m;i++){
            int[] temp=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0) temp[0]=grid[i][j];
                else{
                    int up=Integer.MAX_VALUE;
                    int left=Integer.MAX_VALUE;
                    if(i>0) up=grid[i][j]+dp[j];
                    if(j>0) left=grid[i][j]+temp[j-1];
                    temp[j]=Math.min(up,left);
                }
            }
            dp=temp;
        }
        return dp[n-1];
    }
}

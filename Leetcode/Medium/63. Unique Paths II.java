class Solution {
    // public int helper(int[][] grid,int m,int n,int[][] dp){
    //     if(m==0 && n==0 && grid[m][n]!=1) return 1;
    //     if(m==-1 || n==-1) return 0;
    //     if(grid[m][n]==1) return 0;
    //     if(dp[m][n]!=-1) return dp[m][n];
    //     int up=helper(grid,m-1,n,dp);
    //     int left=helper(grid,m,n-1,dp);
    //     return dp[m][n]=up+left;
    // }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        // int[][] dp=new int[m][n];
        // // for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        // // return helper(obstacleGrid,m-1,n-1,dp);

        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(obstacleGrid[i][j]==1) dp[i][j]=0;
        //         else if(i==0 && j==0) dp[i][j]=1;
        //         else{
        //             int up=0,left=0;
        //             if(i>0) up=dp[i-1][j];
        //             if(j>0) left=dp[i][j-1];
        //             dp[i][j]=up+left;
        //         }
                
        //     }
        // }
        // return dp[m-1][n-1];

        int[] dp=new int[n];
        for(int i=0;i<m;i++){
            int[] temp=new int[n];
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1) temp[j]=0;
                else if(i==0 && j==0) temp[j]=1;
                else{
                    int up=0,left=0;
                    if(i>0) up=dp[j];
                    if(j>0) left=temp[j-1];
                    temp[j]=up+left;
                }
            }
            dp=temp;
        }
        return dp[n-1];

    }
}

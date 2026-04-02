class Solution {
    public int helper(int[][] coins,int i,int j,int m,int n,int k,int[][][] dp){
        if(i==m-1 && j==n-1){
            if(coins[i][j]>=0) return coins[i][j];
            else{
                if(k>0) return 0;
                else return coins[i][j];
            }
        }
        if(i==m || j==n) return -(int) 1e9;
        if(dp[i][j][k]!=-(int) 1e9) return dp[i][j][k];
        int curr=coins[i][j];
        if(curr>=0){
            int down=curr+helper(coins,i+1,j,m,n,k,dp);
            int right=curr+helper(coins,i,j+1,m,n,k,dp);
            return dp[i][j][k]=Math.max(down,right);
        }
        else{
            int down=-(int) 1e9;
            int right=-(int) 1e9;
            if(k>0){
                down=0+helper(coins,i+1,j,m,n,k-1,dp);
                right=0+helper(coins,i,j+1,m,n,k-1,dp);
            }
            down=Math.max(down,curr+helper(coins,i+1,j,m,n,k,dp));
            right=Math.max(right,curr+helper(coins,i,j+1,m,n,k,dp));
            return dp[i][j][k]=Math.max(down,right);
        }
    }
    public int maximumAmount(int[][] coins) {
        int m=coins.length;
        int n=coins[0].length;
        int[][][] dp=new int[m][n][3];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j][0]=-(int) 1e9;
                dp[i][j][1]=-(int) 1e9;
                dp[i][j][2]=-(int) 1e9;
            }
        }
        return helper(coins,0,0,m,n,2,dp);
    }
}

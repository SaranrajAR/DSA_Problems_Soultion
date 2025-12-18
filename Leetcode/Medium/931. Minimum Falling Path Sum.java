class Solution {
    public int helper(int[][] mat,int m,int n,int[][] dp){
        if(m==mat.length-1 && n>=0 && n<mat.length) return mat[m][n];
        if(n<0 || n>=mat.length) return 100000;
        if(dp[m][n]!=-1) return dp[m][n];
        int down=mat[m][n]+helper(mat,m+1,n,dp);
        int downLeft=mat[m][n]+helper(mat,m+1,n-1,dp);
        int downRight=mat[m][n]+helper(mat,m+1,n+1,dp);
        
        return dp[m][n]=Math.min(Math.min(down,downLeft),downRight);
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int ans=Integer.MAX_VALUE;
        int[][] dp=new int[n][n];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // for(int i=0;i<n;i++){
        //     ans=Math.min(helper(matrix,0,i,dp),ans);
        // }
        for(int i=0;i<n;i++){
            dp[n-1][i]=matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int down=Integer.MAX_VALUE;
                int downLeft=Integer.MAX_VALUE;
                int downRight=Integer.MAX_VALUE;
                down=matrix[i][j]+dp[i+1][j];
                if(j>0) downLeft=matrix[i][j]+dp[i+1][j-1];
                if(j<n-1) downRight=matrix[i][j]+dp[i+1][j+1];

                dp[i][j]=Math.min(down,Math.min(downRight,downLeft));
            }
        }

        for(int i=0;i<n;i++){
            ans=Math.min(dp[0][i],ans);
        }
        return ans;
    }
}

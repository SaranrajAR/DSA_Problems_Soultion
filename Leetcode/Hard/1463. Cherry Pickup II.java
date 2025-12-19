class Solution {
    public int helper(int[][] grid,int i,int j1,int j2,int[][][] dp){
        if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length){
            return (int) -1e8;
        }
        if(i==grid.length-1){
            if(j1==j2) return grid[i][j1];
            return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int val=Integer.MIN_VALUE;
        for(int rob1=-1;rob1<=1;rob1++){
            for(int rob2=-1;rob2<=1;rob2++){
                int currVal=helper(grid,i+1,j1+rob1,j2+rob2,dp);
                currVal+=grid[i][j1];
                if(j1!=j2) currVal+=grid[i][j2];
                val=Math.max(currVal,val);
                
                
            }
        }
        return dp[i][j1][j2]=val;
    }
    public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][][] dp=new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(grid,0,0,n-1,dp);
    }
}

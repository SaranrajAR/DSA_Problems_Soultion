class Solution {
    // public int helper(List<List<Integer>> triangle,int m,int n,int[][] dp){
    //     if(m==triangle.size()-1 && n<triangle.get(m).size()) return triangle.get(m).get(n);
    //     if(n>=triangle.get(m).size()) return Integer.MAX_VALUE;
    //     if(dp[m][n]!=Integer.MAX_VALUE) return dp[m][n];
    //     int down=triangle.get(m).get(n)+helper(triangle,m+1,n,dp);
    //     int downRight=triangle.get(m).get(n)+helper(triangle,m+1,n+1,dp);
    //     return dp[m][n]=Math.min(down,downRight); 
    // }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int[][] dp=new int[m][];
        for(int i=0;i<m;i++){
            dp[i]=new int[i+1];
        }
        // return helper(triangle,0,0,dp);
        for(int i=0;i<m;i++){
            for(int j=0;j<=i;j++){
                if(i==0 && j==0) dp[i][j]=triangle.get(0).get(0);
                
                else{
                    int up=Integer.MAX_VALUE;
                    int upleft=Integer.MAX_VALUE;
                    if(i>0 && dp[i-1].length>j) up=triangle.get(i).get(j)+dp[i-1][j];
                    if(i>0 && j>0) upleft=triangle.get(i).get(j)+dp[i-1][j-1];
                    dp[i][j]=Math.min(up,upleft);
                }
                
            }
        }
        int val=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            val=Math.min(dp[m-1][i],val);
        }
        return val;
    }
}

class Solution {
    public int helper(List<List<Integer>> triangle,int m,int n,int[][] dp){
        if(m==triangle.size()-1 && n<triangle.get(m).size()) return triangle.get(m).get(n);
        if(n>=triangle.get(m).size()) return Integer.MAX_VALUE;
        if(dp[m][n]!=Integer.MAX_VALUE) return dp[m][n];
        int down=triangle.get(m).get(n)+helper(triangle,m+1,n,dp);
        int downRight=triangle.get(m).get(n)+helper(triangle,m+1,n+1,dp);
        return dp[m][n]=Math.min(down,downRight); 
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int[][] dp=new int[m][];
        for(int i=0;i<m;i++){
            dp[i]=new int[i+1];
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return helper(triangle,0,0,dp);
    }
}

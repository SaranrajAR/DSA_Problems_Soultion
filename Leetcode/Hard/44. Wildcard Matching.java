class Solution {
    public boolean helper(String s,String p,int i,int j,int[][] dp){
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0){
            boolean flag=true;
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*'){
                    flag=false;
                    break;
                }
            }
            return flag;
        } 
        if(dp[i][j]!=-1) return dp[i][j]==1;
        
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            boolean res= helper(s,p,i-1,j-1,dp);
            if(res) dp[i][j]=1;
            dp[i][j]=0;
            return res;
        }
        else if(p.charAt(j)=='*'){
            boolean NotMove=helper(s,p,i-1,j,dp);
            boolean Move=helper(s,p,i,j-1,dp);
            if(Move || NotMove) dp[i][j]=1;
            else dp[i][j]=0;
            return Move || NotMove;
        }
        dp[i][j]=0;
        return false;
    }
    public boolean isMatch(String s, String p) {
        int n1=s.length();
        int n2=p.length();
        int[][] dp=new int[n1][n2];
        for(int i=0;i<n1;i++) Arrays.fill(dp[i],-1);
        return helper(s,p,n1-1,n2-1,dp);
    }
}

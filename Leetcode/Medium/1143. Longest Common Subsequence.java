class Solution {
    public int helper(String text1,String text2,int idx1,int idx2,int[][] dp){
        if(idx1<0 || idx2<0) return 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(text1.charAt(idx1)==text2.charAt(idx2)){
            return dp[idx1][idx2]=1+helper(text1,text2,idx1-1,idx2-1,dp);
        }
        return dp[idx1][idx2]=Math.max(helper(text1,text2,idx1-1,idx2,dp),helper(text1,text2,idx1,idx2-1,dp));

    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length();
        int n2=text2.length();
        int[][] dp=new int[n1+1][n2+1];
        // for(int i=0;i<n1;i++) Arrays.fill(dp[i],-1);
        // return helper(text1,text2,n1-1,n2-1,dp);
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i+1][j+1]=1+dp[i][j];
                }
                else{
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[n1][n2];
    }
}

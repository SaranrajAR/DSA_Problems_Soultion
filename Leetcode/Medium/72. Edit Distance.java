class Solution {
    public int helper(String word1,String word2,int i,int j,int[][] dp){
        if(i<0 && j<0) return 0; // no need becuase -1+ 1 == 0 either case will work
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]=helper(word1,word2,i-1,j-1,dp);
        }
        int del=1+helper(word1,word2,i-1,j,dp);
        int insert=1+helper(word1,word2,i,j-1,dp);
        int replace=1+helper(word1,word2,i-1,j-1,dp);
        return dp[i][j]=Math.min(del,Math.min(insert,replace));
    }
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int[][] dp=new int[n1+1][n2+1];
        // for(int i=0;i<n1;i++) Arrays.fill(dp[i],-1);
        // return helper(word1,word2,n1-1,n2-1,dp);
        for(int j=1;j<=n2;j++) dp[0][j]=j;
        for(int i=1;i<=n1;i++) dp[i][0]=i;
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int del=1+dp[i-1][j];
                    int insert=1+dp[i][j-1];
                    int replace=1+dp[i-1][j-1];
                    dp[i][j]=Math.min(del,Math.min(insert,replace));
                }
            }

        }
        return dp[n1][n2];
    }
    
}

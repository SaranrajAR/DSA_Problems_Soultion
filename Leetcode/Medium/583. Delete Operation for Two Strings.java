class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int[][] dp=new int[n1+1][n2+1];
        int res=0;
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1]=1+dp[i][j];
                }
                else{
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        int deletions=word1.length()-dp[n1][n2];
        int inserstions=word2.length()-dp[n1][n2];
        return deletions+inserstions;
    }
}

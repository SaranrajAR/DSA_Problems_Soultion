// User function Template for Java

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int n1=s1.length();
        int n2=s2.length();
        int[][] dp=new int[n1+1][n2+1];
        int res=0;
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i+1][j+1]=1+dp[i][j];//prev diagnoal element
                    res=Math.max(res,dp[i+1][j+1]);
                }
            }
        }
        return res;
    }
}

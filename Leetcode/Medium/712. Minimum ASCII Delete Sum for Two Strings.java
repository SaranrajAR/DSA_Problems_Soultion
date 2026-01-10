class Solution {
    public int helper(String s1,String s2,int idx1,int idx2,int[][] dp){
        if(idx1<0 && idx2<0) return 0;
        if(idx2<0){
            int s=0;
            for(int i=0;i<=idx1;i++) s+=(int) s1.charAt(i);
            return s;
        }
        if(idx1<0){
            int s=0;
            for(int i=0;i<=idx2;i++) s+=(int) s2.charAt(i);
            return s;
        }
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];

        if(s1.charAt(idx1)==s2.charAt(idx2)){
            return dp[idx1][idx2]=helper(s1,s2,idx1-1,idx2-1,dp);
        }
        else{
            int val1=(int) s1.charAt(idx1);
            int val2=(int) s2.charAt(idx2);
            return dp[idx1][idx2]=Math.min((val1+helper(s1,s2,idx1-1,idx2,dp)),val2+helper(s1,s2,idx1,idx2-1,dp));
        }
    }
    public int minimumDeleteSum(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();
        int[][] dp=new int[n1+1][n2+1];
        // for(int i=0;i<n1;i++) Arrays.fill(dp[i],-1);
        // return helper(s1,s2,n1-1,n2-1,dp);
        dp[0][0]=0;
        int s=0;
        for(int i=1;i<=n1;i++){
            s+=(int) s1.charAt(i-1);
            dp[i][0]=s;
        }
        s=0;
        for(int j=1;j<=n2;j++){
            s+=(int) s2.charAt(j-1);
            dp[0][j]=s;
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int val1=(int) s1.charAt(i-1);
                    int val2=(int) s2.charAt(j-1);
                    dp[i][j]=Math.min((val1+dp[i-1][j]),(val2+dp[i][j-1]));
                }
            }
        }
        return dp[n1][n2];
    }
}

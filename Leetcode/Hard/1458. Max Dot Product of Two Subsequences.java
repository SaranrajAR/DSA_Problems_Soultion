class Solution {
    public int helper(int[] nums1,int[] nums2,int i,int j,int[][] dp){
        if(i<0 || j<0) return Integer.MIN_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int val=helper(nums1,nums2,i-1,j-1,dp);
        // int take=(nums1[i]*nums2[j])+helper(nums1,nums2,i-1,j-1);
        int take=nums1[i]*nums2[j];
        if(val>0) take+=val; // kind of kandane alg if val<=0 do not take
        int notTake1=helper(nums1,nums2,i-1,j,dp);
        int notTake2=helper(nums1,nums2,i,j-1,dp);
        int notTake3=helper(nums1,nums2,i-1,j-1,dp);
        return dp[i][j]=Math.max(take,Math.max(notTake1,Math.max(notTake2,notTake3)));

    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[][] dp=new int[n1+1][n2+1];
        // for(int i=0;i<n1;i++) Arrays.fill(dp[i],-1);
        // return helper(nums1,nums2,n1-1,n2-1,dp);
        for(int i=0;i<=n1;i++) dp[i][0]=(int) -1e9;
        for(int j=0;j<=n2;j++) dp[0][j]=(int) -1e9;
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                int val=dp[i-1][j-1];
                int take=nums1[i-1]*nums2[j-1];
                if(val>0) take+=val;
                int notTake1=dp[i-1][j];
                int notTake2=dp[i][j-1];
                int notTake3=dp[i-1][j-1];
                dp[i][j]=Math.max(take,Math.max(notTake1,Math.max(notTake2,notTake3)));
            }
        }
        return dp[n1][n2];

    }
}

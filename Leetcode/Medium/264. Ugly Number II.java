class Solution {
    public int nthUglyNumber(int n) {
        int p1 = 0;
        int p2 = 0;
        int p3=0;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int twoMultiple=dp[p1]*2;
            int threeMultiple=dp[p2]*3;
            int fiveMultiple=dp[p3]*5;

            int min=Math.min(twoMultiple,Math.min(threeMultiple,fiveMultiple));

            dp[i]=min;
            if(twoMultiple==min) p1++;
            if(threeMultiple==min) p2++;
            if(fiveMultiple==min) p3++;
        }
        return dp[n-1];
    }
}

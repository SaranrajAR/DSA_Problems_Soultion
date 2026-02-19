class Solution {
    public long rob(int[] nums, int[] colors) {
        int n=nums.length;
        long[] dp=new long[n];
        for(int i=0;i<nums.length;i++){
            if(i==0 || colors[i]!=colors[i-1]){
                if(i==0) dp[i]=nums[i];
                else dp[i]=nums[i]+dp[i-1];
            }
            else{
               int curr=nums[i];
               int prev=nums[i-1];
               if(curr>prev) {
                dp[i]=curr;
                if(i>1) dp[i]+=dp[i-2];
               }
               else{
                if(i>1 && dp[i-2]+curr>dp[i-1]) dp[i]=dp[i-2]+curr;
                else dp[i]=dp[i-1];
               }
            }
        }
        return dp[n-1];
    }
}

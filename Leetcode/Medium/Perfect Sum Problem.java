class Solution {
    
    // Function to calculate the number of subsets with a given sum
    public int helper(int[] nums,int target,int[][] dp,int i){
        if(i==0){
            if(nums[0]==0 && target==0) return 2;
            if(nums[0]==target || target==0) return 1;
            return 0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int notPick=helper(nums,target,dp,i-1);
        int pick=0;
        if(target>=nums[i]){
            pick=helper(nums,target-nums[i],dp,i-1);
        }
        return dp[i][target]=pick+notPick;
    }
    
    public int perfectSum(int[] nums, int target) {
        // code here
        int n=nums.length;
        int[][] dp=new int[n][target+1];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // return helper(nums,target,dp,n-1);
        if(nums[0]==0){
            dp[0][0]=2;
        }
        else{
            dp[0][0]=1;
        }
        if(nums[0]!=0 && nums[0]<=target) dp[0][nums[0]]=1;
        for(int i=1;i<n;i++){
            for(int tar=0;tar<=target;tar++){
                int notPick=dp[i-1][tar];
                int pick=0;
                if(tar>=nums[i]){
                    pick=dp[i-1][tar-nums[i]];
                }
                dp[i][tar]=pick+notPick;
            }
        }
        return dp[n-1][target];
    }
}

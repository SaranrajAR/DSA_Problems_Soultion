class Solution {
    public boolean helper(int[] nums,int i,int target,int[][] dp){
        if(target==0) return true;
        if(i==0) return nums[i]==target;
        if(dp[i][target]!=-1){
            return dp[i][target]==1?true:false;
        }
        boolean notPick=helper(nums,i-1,target,dp);
        boolean pick=false;
        if(nums[i]<=target){
            pick=helper(nums,i-1,target-nums[i],dp);
        }
        dp[i][target]= (pick || notPick)?1:0;
        return pick || notPick;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return false;
        


        // int[][] dp=new int[n][sum+1];
        // for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        // return helper(nums,n-1,sum,dp);

        boolean[][] dp=new boolean[n][sum+1];
        for(int i=0;i<n;i++) dp[i][0]=true;
        dp[0][nums[0]]=true;
        sum/=2;
        for(int i=1;i<n;i++){
            for(int target=1;target<=sum;target++){
                boolean notPick=dp[i-1][target];
                boolean pick=false;
                if(nums[i]<=target){
                    pick=dp[i-1][target-nums[i]];
                }
                dp[i][target]=pick || notPick;
            }
        }
        return dp[n-1][sum];
    }
}

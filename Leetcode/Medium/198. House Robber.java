class Solution {
    // public int helper(int[] nums,int idx,int[] dp){
    //     if(idx==0){
    //         return nums[idx];
    //     }
    //     int val=0;
    //     if(dp[idx]!=-1) return dp[idx];
    //     int notpick=helper(nums,idx-1,dp);
    //     int pick=nums[idx];
    //     if(idx>1) pick+=helper(nums,idx-2,dp); 
        
        
    //     return dp[idx]=Math.max(pick,notpick);
    // }
    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     int[] dp=new int[n];
    //     Arrays.fill(dp,-1);

    //     // return helper(nums,n-1,dp); //recusion calling

    //     dp[0]=nums[0];
    //     for(int i=1;i<n;i++){
    //         int np=dp[i-1];          Tabulation
    //         int p=nums[i];
    //         if(i>1) p+=dp[i-2];
    //         dp[i]=Math.max(p,np);
    //     }
        
    //     return dp[n-1];
    // }
    public int rob(int[] nums){

        int n=nums.length;
        int prev1=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int curri=0;

            int notPick=prev1;
            int Pick=nums[i];
            if(i>1) Pick+=prev2;
            curri=Math.max(Pick,notPick);
            prev2=prev1;
            prev1=curri;
            
        }
        return prev1;
    }


}

class Solution {
    static boolean helper(int[] arr,int tar,int i,int[][] dp){
        if(tar==0) return true;
        if(i==0) return arr[0]==tar;
        if(dp[i][tar]!=-1){
            if(dp[i][tar]==1) return true;
            return false; // if 0 return false
        }
        boolean notPick=helper(arr,tar,i-1,dp);
        boolean pick=false;
        if(arr[i]<=tar){
            pick=helper(arr,tar-arr[i],i-1,dp);
        }
        if(pick || notPick) dp[i][tar]=1;
        else dp[i][tar]=0;
        return pick || notPick;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int[][] dp=new int[arr.length][sum+1];
        for(int i=0;i<arr.length;i++) Arrays.fill(dp[i],-1);
        return helper(arr,sum,arr.length-1,dp);
    }
}

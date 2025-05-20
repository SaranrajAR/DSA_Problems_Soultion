class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int[] diffrence=new int[n];
        diffrence[0]=nums[0];
        for(int i=1;i<n;i++){
            diffrence[i]=nums[i]-nums[i-1];
        }
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            diffrence[l]=diffrence[l]-1;
            if((r+1)<n) diffrence[r+1]=diffrence[r+1]+1;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=diffrence[i];
            nums[i]=sum;
            if(nums[i]>0) return false;
        }
        return true;
        
    }
}

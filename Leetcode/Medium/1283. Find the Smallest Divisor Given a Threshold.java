class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=nums[0];
        for(int num:nums){
            max=Math.max(num,max);
        }
        int low=1;
        int high=max;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            int value=0;
            for(int num:nums){
                value+=(num+mid-1)/mid;
            }
            if(value<=threshold){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;




    }
}

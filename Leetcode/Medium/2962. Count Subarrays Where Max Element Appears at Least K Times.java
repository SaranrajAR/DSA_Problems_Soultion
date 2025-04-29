class Solution {
    public long countSubarrays(int[] nums, int k) {
        int l=0,r=0;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(num,max);
        }
        long count=0;
        long ans=0;
        int n=nums.length;
        while(r<n){
            if(nums[r]==max) count++;
            while(count>=k && l<=r){
                if(nums[l]==max) count--;
                ans+=n-r;
                l++;

            }
            r++;
        }
        return ans;
        
    }
}

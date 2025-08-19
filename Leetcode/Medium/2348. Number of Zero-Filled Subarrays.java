class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0;
        int l=0;
        int r=0;
        while(r<nums.length){
            if(nums[r]!=0){
                r++;
                l=r;
            }
            else if(nums[r]==0){
                count+=r-l+1;
                r++;
            }
            
        }
        return count;
    }
}

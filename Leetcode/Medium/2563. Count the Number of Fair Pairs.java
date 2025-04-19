class Solution {
    private static long up_bound(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        long count=0;
        while(low<high){
            if((nums[low]+nums[high])<target){
                count+=high-low;
                low++;
            }
            else high--;
        }
        return count;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return up_bound(nums,upper+1)-up_bound(nums,lower);
    }
}

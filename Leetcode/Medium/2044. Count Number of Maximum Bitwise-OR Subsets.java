class Solution {
    public int count;
    public int maxOR;
    public void helper(int[] nums,int idx,int current){
        if(idx==nums.length){
            if(current==maxOR) count++;
            return;
        }

        helper(nums,idx+1,current);
        int temp=current;
        current=current | nums[idx];
        helper(nums,idx+1,current);
        current=temp;
    }
    public int countMaxOrSubsets(int[] nums) {
        count=0;
        for(int num:nums){
            maxOR=maxOR | num;
        }
        helper(nums,0,0);
        return count;
    }
}

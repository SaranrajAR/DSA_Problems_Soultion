class Solution {
    public int maxSum(int[] nums) {
        int[] freq=new int[101];
        int maxNum=Integer.MIN_VALUE; //if all nums are negative return the max value in the nums
        int sum=0;
        for(int num:nums){
            if(num>0 && freq[num]==0){
                sum+=num; // computes sum for non negative and unique
                freq[num]++;
            }
            maxNum=Math.max(maxNum,num);
        }
        return sum>0? sum:maxNum; // if all are negtative sum==0 only returns the maxNum
    }
}

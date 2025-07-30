class Solution {
    public int longestSubarray(int[] nums) {
        int max=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            max=Math.max(nums[i],max);
        }
        int len=0;
        int prev=nums[0];
        int count=0;
        for(int i=1;i<n;i++){
            if(nums[i]==prev && nums[i]>=max){
                count++;
               
                len=Math.max(count,len);
            } 
            else count=0;
            prev=nums[i];
        }
        
        return len+1;
    }
}

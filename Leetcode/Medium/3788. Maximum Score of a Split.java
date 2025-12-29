class Solution {
    public long maximumScore(int[] nums) {
        long res=Integer.MIN_VALUE;
        int n=nums.length;
        long prefix=0;
        int[] suffix=new int[n];
        
        int minValue=(int) 1e9;
        for(int i=n-1;i>=0;i--){
            suffix[i]=minValue;
            minValue=Math.min(nums[i],minValue);
        }
        for(int i=0;i<n-1;i++){
            prefix+=nums[i];
            long curr=prefix-suffix[i];
            res=Math.max(curr,res);
        }
        return res;

    }
}

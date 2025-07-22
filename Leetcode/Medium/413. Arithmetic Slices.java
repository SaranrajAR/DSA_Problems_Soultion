class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int i=0;i<n-1;i++){
            int currDiff=nums[i+1]-nums[i];
            for(int j=i+2;j<n;j++){
                if(nums[j]-nums[j-1] == currDiff) total++;
                else break;
            }
        }
        return total;
    }
}

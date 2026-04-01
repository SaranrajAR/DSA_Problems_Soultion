class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res=0;
        boolean isPicked=false;
        int pickedIdx=-1;
        for(int i=0;i<nums.length;i++){
            if(isPicked && nums[i]%2!=nums[i-1]%2 && nums[i]<=threshold){
                res=Math.max(res,i-pickedIdx+1);
                continue;
            }
            else{
                isPicked=false;
                pickedIdx=-1;
            }
            if(nums[i]%2==0 && nums[i]<=threshold){
                isPicked=true;
                pickedIdx=i;
                res=Math.max(1,res);
                continue;
            }

            
            
        }
        return res;
    }
}

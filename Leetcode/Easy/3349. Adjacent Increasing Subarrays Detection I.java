class Solution {
    public boolean helper(List<Integer> nums,int idx,int k){
        for(int i=idx+1;i<idx+k;i++){
            if(nums.get(i)<=nums.get(i-1)) return false;
        }
        int j=idx+k;
        for(int i=j+1;i<j+k;i++){
            if(nums.get(i)<=nums.get(i-1)) return false;
        }
        return true;
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int lst=k*2;
        for(int i=0;i<=nums.size()-lst;i++){
            if(helper(nums,i,k)) return true;
        }
        return false;
    }
}

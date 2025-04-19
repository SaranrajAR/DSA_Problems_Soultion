class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int low=0;
        int high=nums.size()-1;
        int count=0;
        while(low<high){
            if((nums.get(low)+nums.get(high))<target) {
                count+=high-low;
                low++;
            }
            else high--;
        }
        return count;
        
    }
}

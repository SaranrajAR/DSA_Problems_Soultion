class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int i=0,j=0;
        int sum=0;
        int max=0;
        while(j<nums.length){
            while(map.containsKey(nums[j])){
                sum-=nums[i];
                map.remove(nums[i]);
                i++;
            }
            sum+=nums[j];
            max=Math.max(sum,max);
            map.put(nums[j],j);
            j++;
        }
        return max;

    }
}

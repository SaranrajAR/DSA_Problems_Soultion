class Solution {
    private int countsubarray(int[] nums,int k){
        int count=0,l=0,r=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                int num=(nums[l]);
                map.put(num,map.get(num)-1);
                if(map.get(num)==0) map.remove(num);
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countsubarray(nums,k)-countsubarray(nums,k-1);
        
    }
}

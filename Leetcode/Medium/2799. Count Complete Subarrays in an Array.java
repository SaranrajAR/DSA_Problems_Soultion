class Solution {
    private int countfunction(int[] nums,int k){
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        int l=0,r=0;
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                int num=nums[l];
                map.put(num,map.get(num)-1);
                if(map.get(num)==0) map.remove(num);
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;

    }
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int n=set.size();
        

        return countfunction(nums,n)-countfunction(nums,n-1);

        
    }
}

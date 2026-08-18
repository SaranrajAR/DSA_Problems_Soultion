class Solution {
    public int largestInteger(int[] nums, int k) {
        
        int res=-1;
        if(k==1){
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int num:nums){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            for(int key:map.keySet()){
                if(map.get(key)==1) res=Math.max(res,key);
            }
        }
        else if(k==nums.length){
            for(int num:nums){
                res=Math.max(num,res);
            }
        }
        else{
            HashSet<Integer> set=new HashSet<>();
            int first=nums[0];
            int last=nums[nums.length-1];
            if(first==last) return res;
            for(int i=1;i<nums.length-1;i++){
                set.add(nums[i]);
            }
            if(!set.contains(first)) res=Math.max(first,res);
            if(!set.contains(last)) res=Math.max(res,last);
        }
        return res;
    }
}

class Solution {

    private int findMin(List<Integer> list){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<list.size()-2;i++){
            min=Math.min(min,(Math.abs(list.get(i)+list.get(i+1)+list.get(i+2))));
        }
        return min;
    }
    public int minimumDistance(int[] nums) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int ans=Integer.MAX_VALUE;
        for(int key:map.keySet()){
            List<Integer> temp=map.get(key);
            if(temp.size()>=3){
                ans=Math.min(ans,findMin(temp));
            }
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}

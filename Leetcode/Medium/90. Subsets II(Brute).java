class Solution {
    public void helper(int[] nums,int i,List<Integer> current,Set<List<Integer>> set){
        if(i==nums.length){
            set.add(new ArrayList<>(current));
            return;
        }
        helper(nums,i+1,current,set);

        current.add(nums[i]);
        helper(nums,i+1,current,set);
        current.remove(current.size()-1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();
        helper(nums,0,new ArrayList<>(),set);
        for(List<Integer> curr:set){
            res.add(new ArrayList<>(curr));
        }
        return res;
    }
}

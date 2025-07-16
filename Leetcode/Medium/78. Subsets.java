class Solution {
    public void helper(int[] nums,int i,List<Integer> current,List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        //not pick runs first
        helper(nums,i+1,current,res);

        //now pick runs
        current.add(nums[i]); 
        helper(nums,i+1,current,res);
        current.remove(current.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        helper(nums,0,new ArrayList<>(),res);
        return res;
        
    }
}

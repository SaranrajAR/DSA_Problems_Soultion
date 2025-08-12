class Solution {
    List<List<Integer>> ans;
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void helper(int[] nums,int idx){
        if(idx==nums.length){
            List<Integer> list=new ArrayList<>();
            for(int num:nums) list.add(num);
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(i,idx,nums);
            helper(nums,idx+1);
            swap(i,idx,nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        ans=new ArrayList<>();
        helper(nums,0);
        return ans;
    }
}

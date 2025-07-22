class Solution {
    public void helper(int[] arr,int target,int start,List<Integer> current,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(current));
            return;

        }
        for(int i=start;i<arr.length;i++){
            if(i>start && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            current.add(arr[i]);
            helper(arr,target-arr[i],i+1,current,res);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        helper(candidates,target,0,new ArrayList<>(),res);
        return res;
    }
}

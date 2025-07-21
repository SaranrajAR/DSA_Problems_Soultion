class Solution {
    public void helper(int[] arr,int k,int i,List<Integer> current,List<List<Integer>> res,int sum){
        if(i==arr.length){
            if(sum==k) res.add(new ArrayList<>(current));
            return;
        }

        if(sum>k) return;
        sum+=arr[i];
        current.add(arr[i]);
        helper(arr,k,i,current,res,sum);
        sum-=arr[i];
        current.remove(current.size()-1);

        helper(arr,k,i+1,current,res,sum);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> res=new ArrayList<>();
       List<Integer> current=new ArrayList<>();
       helper(candidates,target,0,new ArrayList<>(),res,0);
       return res;
        
    }
}

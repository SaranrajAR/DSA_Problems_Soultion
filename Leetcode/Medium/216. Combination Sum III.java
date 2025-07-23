class Solution {
    public void helper(int k,int n,List<Integer> current,List<List<Integer>> res,int sum,int start){
        if(current.size()==k){
            if(sum==n){
                res.add(new ArrayList<>(current));
            }
            return;
        }
        for(int i=start;i<=9;i++){
            if(sum+i > n) break;
            current.add(i);
            
            helper(k,n,current,res,sum+i,i+1);
            current.remove(current.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        helper(k,n,new ArrayList<>(),res,0,1);
        return res;
    }
}

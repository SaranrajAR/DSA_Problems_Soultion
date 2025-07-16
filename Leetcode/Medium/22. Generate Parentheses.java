class Solution {
    public void helper(List<String> res,String current,int open,int close,int max){
        if(open+close==2*max){
            res.add(current);
            return;
        }
        if(open<max){
            helper(res,current+"(",open+1,close,max);
        }
        if(close<open){
            helper(res,current+")",open,close+1,max);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        helper(res,"",0,0,n);
        return res;
    }
}

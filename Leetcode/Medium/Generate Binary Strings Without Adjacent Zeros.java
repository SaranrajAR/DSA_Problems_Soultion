class Solution {
    List<String> res;
    public void helper(int n,int idx,StringBuilder sb,char prev){
        if(idx==n){
            res.add(sb.toString());
            return;
        }
        if(idx==0 || prev!='0'){
            sb.append('0');
            helper(n,idx+1,sb,'0');
            sb.deleteCharAt(sb.length()-1);

        }
        sb.append('1');
        helper(n,idx+1,sb,'1');
        sb.deleteCharAt(sb.length()-1);
    }
    public List<String> validStrings(int n) {
        res=new ArrayList<>();
        helper(n,0,new StringBuilder(),'1');
        return res;
    }
}

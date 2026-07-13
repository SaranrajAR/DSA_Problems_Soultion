class Solution {
    public void helper(int last,List<Integer> res,StringBuilder sb,int low,int high){
        if(last==9) return;
        sb.append(""+(last+1));
        int num=Integer.parseInt(sb.toString());
        if(num<low){
            helper(last+1,res,sb,low,high);
        }
        else if(num>=low && num<=high){
            res.add(Integer.parseInt(sb.toString()));
            helper(last+1,res,sb,low,high);
        }
        else return;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<=8;i++){
            helper(i,res,new StringBuilder(),low,high);
        }
        Collections.sort(res);
        return res;
    }
}

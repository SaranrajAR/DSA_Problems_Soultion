class Solution {
    public List<String> res;
    public void helper(String nums,int target,StringBuilder expr,int idx,long currValue,long prevNum){
        if(idx==nums.length()){
            if(currValue==target) res.add(expr.toString());
            return;
        }

        for(int i=idx;i<nums.length();i++){
            if(i!=idx && nums.charAt(idx)=='0') break;
            String part=nums.substring(idx,i+1);
            long currNum=Long.parseLong(part);
            int len=expr.length();
            
            if(idx==0){
                expr.append(part);
                helper(nums,target,expr,i+1,currNum,currNum);
                expr.setLength(len);
            }

            else{
                expr.append("+").append(part);
                helper(nums,target,expr,i+1,currNum+currValue,currNum);
                expr.setLength(len);

                expr.append("-").append(part);
                helper(nums,target,expr,i+1,currValue-currNum,-currNum);
                expr.setLength(len);

                expr.append("*").append(part);
                helper(nums,target,expr,i+1,currValue-prevNum + prevNum*currNum,prevNum*currNum);
                expr.setLength(len);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        res=new ArrayList<>();
        helper(num,target,new StringBuilder(),0,0,0);
        return res;
    }
}

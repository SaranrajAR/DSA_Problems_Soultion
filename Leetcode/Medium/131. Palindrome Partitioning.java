class Solution {
    public void helper(List<List<String>> res,List<String> current,String s,int start){
        if(start==s.length()){
            res.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                current.add(s.substring(start,i+1));
                helper(res,current,s,i+1);
                current.remove(current.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        helper(res,new ArrayList<>(),s,0);
        return res;
    }
    public boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}

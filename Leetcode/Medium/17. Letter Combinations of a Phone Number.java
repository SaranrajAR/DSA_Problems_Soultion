class Solution {
    public void helper(List<String> res,String[] map,StringBuilder sb,int index,String digits){
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
        String letters=map[digits.charAt(index)-'0'];
        for(char ch:letters.toCharArray()){
            sb.append(ch);
            helper(res,map,sb,index+1,digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        String[] map={
            "",//0
            "",  //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv", //8
            "wxyz" //9
        };
        List<String> res=new ArrayList<>();
        helper(res,map,new StringBuilder(),0,digits);
        return res;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
        Arrays.sort(strs);
        StringBuilder sb=new StringBuilder();
        String firstword=strs[0];
        String lastword=strs[strs.length-1];
        //After sorting checking firstword and lastword common prefix alone bcause using sorting
        for(int i=0;i<firstword.length();i++){
            if(i>=lastword.length() || firstword.charAt(i)!=lastword.charAt(i)) break;
            sb.append(firstword.charAt(i));
        }
        return sb.toString();

        
    }
}

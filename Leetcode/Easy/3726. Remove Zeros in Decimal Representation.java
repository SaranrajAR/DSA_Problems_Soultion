class Solution {
    public long removeZeros(long n) {
        String s=Long.toString(n);
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch!='0') sb.append(ch);
        }
        return Long.parseLong(sb.toString());
    }
}

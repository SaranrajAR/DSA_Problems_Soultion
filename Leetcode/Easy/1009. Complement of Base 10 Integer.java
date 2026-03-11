class Solution {
    public int bitwiseComplement(int n) {
        StringBuilder sb=new StringBuilder();
        String s=Integer.toBinaryString(n);
        for(char ch:s.toCharArray()){
            char c='0';
            if(ch=='0') c='1';
            sb.append(c);
        }
        return Integer.parseInt(sb.toString(),2);
    }
}

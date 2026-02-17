class Solution {
    public int reverseBits(int n) {
        StringBuilder sb=new StringBuilder(Integer.toBinaryString(n));
        sb.reverse();
        int N=sb.length();
        for(int i=N;i<32;i++) sb.append('0');
        
        return Integer.parseInt(sb.toString(),2);
    }
}

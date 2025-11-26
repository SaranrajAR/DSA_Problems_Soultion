class Solution {
    public int minimumFlips(int n) {
        String s=Integer.toBinaryString(n);
        int count=0;
        n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)) count++;
        }
        return count;
    }
}

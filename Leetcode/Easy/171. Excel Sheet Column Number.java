class Solution {
    public int titleToNumber(String columnTitle) {
        String s=columnTitle;
        int n=s.length();
        int res=0;
        int base=1;
        for(int i=n-1;i>=0;i--){
            int curr=s.charAt(i)-'A';
            res+=(curr+1)*base;
            base*=26;

        }
        return res;
    }
}

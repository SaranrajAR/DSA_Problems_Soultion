class Solution {
    public boolean checkOnesSegment(String s) {
        int i=1;
        int n=s.length();
        while(i<n && s.charAt(i)=='1'){
            i++;
        }
        while(i<n){
            if(s.charAt(i)=='1') return false;
            i++;
        }
        return true;
    }
}

class Solution {
    public boolean isPalindrome(String s,int l,int r){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int count=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(isPalindrome(s,j,i)) count++;
            }
        }
        return count;
    }
}

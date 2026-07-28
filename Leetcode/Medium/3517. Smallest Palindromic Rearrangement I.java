class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        if(n<=3) return s;
        String t=s.substring(0,(n/2));
        char[] half=t.toCharArray();
        Arrays.sort(half);
        char[] res=new char[n];
        int i=0;
        int j=n-1;
        while(i<j){
            res[i]=half[i];
            res[j]=half[i];
            i++;
            j--;
        }
        if(n%2!=0) res[n/2]=s.charAt(n/2);
        return new String(res);
    }
}

class Solution {
    public boolean func(String s, int i,int n){
        if(i>=n/2) return true;
        if(s.charAt(i)!=s.charAt(n-i-1)) return false;
        return func(s,i+1,n);
    }
    public boolean isPalindrome(String s) {
        s=s.toLowerCase().replaceAll("[^a-z0-9]","");
        int i=0;
        int j=s.length();
        // while(i<j){
        //     if(s.charAt(i)!=s.charAt(j)){
        //         return false;
        //     }
        //     i++;
        //     j--;
            
        // }


        return func(s,i,j);
        

        

        
    }
}

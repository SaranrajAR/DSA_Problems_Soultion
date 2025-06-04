class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==1) return 1;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int count=0;
        boolean hasOdd=false;
        for(int val:map.values()){
            if(val%2==0){
                count+=val;
            }
            else{
                count+=val-1;
                hasOdd=true;
            }
        }
        if(hasOdd) count+=1;
        return count;
        
    }
}

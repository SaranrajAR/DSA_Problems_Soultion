package Leetcode.Medium;
class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels=Set.of('a','e','i','o','u');
        int count=0,max=0;
       int l=0,r=0;
        while(r<s.length()){
            if((r-l+1)>k){
                if(vowels.contains(s.charAt(l))){
                    count-=1;
                }
                l++;
            }
            if(vowels.contains(s.charAt(r))) count++;
            max=Math.max(count,max);
            r++;
        }
        return max;
        
    }
}
class Solution {
    public int maxFreqSum(String s) {
        int max1=0;
        int max2=0;
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' ){
                max1=Math.max(max1,arr[s.charAt(i)-'a']);
            }
            else{
                max2=Math.max(max2,arr[s.charAt(i)-'a']);
            }
        }
        return max1+max2;
        
        
    }
}©leetcode

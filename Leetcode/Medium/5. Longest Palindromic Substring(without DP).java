class Solution {
    private int func(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1; //returns the length of substring
    }
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1) return "";
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            int oddlen=func(s,i,i);  //expanding around left and right  l<---i---->r as center
            int evenlen=func(s,i,i+1); // expanding by keeping i and i+1   l<----i,i+1---->r
            int len=Math.max(oddlen,evenlen); //checks which lenght is greater
            if(len > end-start){
                start=i-(len-1)/2;  //i-len/2;
                end=i+len/2;        //i+len/2;   
            }


        }
        return s.substring(start,end+1);  //start is inclusive //end is exclusive
        
    }
}

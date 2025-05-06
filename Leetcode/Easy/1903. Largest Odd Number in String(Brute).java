class Solution {
    public String largestOddNumber(String num) {
        int max=0;
        for(int i=0;i<num.length();i++){
            int n=num.charAt(i)-'0';
            if(n%2!=0){
                max=Math.max(max,i+1);
            }
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<max;i++){
            ans.append(num.charAt(i));
        }
        return ans.toString();
        
        
    }
}

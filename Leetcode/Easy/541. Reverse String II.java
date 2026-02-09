
class Solution {
    public String reverseStr(String s, int k) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        boolean isRev=true;
        for(int i=0;i<s.length();i+=k){
            StringBuilder sb1=new StringBuilder();
            // for(int j=i;j<i+k && j<s.length();j++) sb1.append(s.charAt(j));
            if(i+k<=n) sb1.append(s.substring(i,i+k));
            else sb1.append(s.substring(i,n));
            if(isRev){
                sb1.reverse();
                isRev=false;
            }
            else isRev=true;
            sb.append(sb1);
        }
        return sb.toString();
    }
}

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int i=a.length()-1;
        int j=b.length()-1;
        int c=0;
        while(i>=0 && j>=0){
            int sum=(a.charAt(i)-'0')+(b.charAt(j)-'0')+c;
            if(sum>1) {
                c=1;
            }
            else c=0;
            sum=sum%2;
            sb.append(""+sum);
            i--;
            j--;    
        }
        while(i>=0) {
            int sum=(a.charAt(i)-'0')+c;
            if(sum>1) {
                c=1;
            }
            else c=0;
            sum=sum%2;
            sb.append(""+sum);
            i--;
        }    
        while(j>=0) {
            int sum=(b.charAt(j)-'0')+c;
            if(sum>1) {
                c=1;
            }
            else c=0;
            sum=sum%2;
            sb.append(""+sum);
            j--;
        }    
        if(c==1) sb.append(c);
        return sb.reverse().toString();

    }
}

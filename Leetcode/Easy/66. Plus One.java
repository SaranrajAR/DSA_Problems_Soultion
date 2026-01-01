class Solution {
    public int[] plusOne(int[] digits) {
        // long num=0;
        // for(int digit:digits){
        //     num*=10;
        //     num+=digit;
        // }
        // num+=1;
        // String s=Long.toString(num);
        // int[] res=new int[s.length()];
        // for(int i=0;i<s.length();i++){
        //     res[i]=s.charAt(i)-'0';
        // }
        // return res;
        int n=digits.length;
        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
        }
        int[] res=new int[n+1];
        res[0]=1;
        return res;

    }
}

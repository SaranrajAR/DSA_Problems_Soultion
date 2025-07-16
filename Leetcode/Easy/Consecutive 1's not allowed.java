// User function Template for Java

class Solution {
    int countStrings(int n) {
        // code here
        int zeroEnd=1;
        int oneEnd=1;
        int count=0;
        if(n==1){
            return zeroEnd+oneEnd;
        }
        int i=2;
        while(i<=n){
            int newZeroEnd=(oneEnd+zeroEnd);
            int newOneEnd=zeroEnd;
            zeroEnd=newZeroEnd;
            oneEnd=newOneEnd;
            i++;
        }
        return zeroEnd+oneEnd;
    }
}

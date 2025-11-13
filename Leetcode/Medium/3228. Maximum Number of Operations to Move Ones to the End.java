class Solution {
    public int maxOperations(String s) {
        int one_count=0;
        int res=0;
        int n=s.length();
        int i=0;
        while(i<n){
            if(s.charAt(i)=='1'){
                one_count+=1;
            }
            else{
                while(i+1<n && s.charAt(i+1)=='0'){
                    i+=1;
                }
                res+=one_count;
            }
            i+=1;
        }
        return res;
    }
}

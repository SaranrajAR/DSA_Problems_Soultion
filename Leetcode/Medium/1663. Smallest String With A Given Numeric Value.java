class Solution {
    public String getSmallestString(int n, int k) {
        char[] arr=new char[n];
        Arrays.fill(arr,'a');
        int rem=k-n;
        int j=n-1;
        while(rem!=0 && j>=0){
            if(rem>=26){
                rem-=25;
                arr[j]+=25;
            }
            else{
                arr[j]+=rem;
                rem=0;
            }
            j--;
        }
        return new String(arr);
    }
}

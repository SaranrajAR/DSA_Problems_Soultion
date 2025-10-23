class Solution {
    public boolean hasSameDigits(String s) {
       int n=s.length();
       int[] arr=new int[n];
       
       int n1=n-1;
       int idx=0;
       for(char ch:s.toCharArray()){
        arr[idx++]=ch-'0';
       }
       while(n1>=2){
        for(int i=0;i<n1;i++){
            arr[i]=(arr[i]+arr[i+1])%10;
        }
        n1--;
       }
       if(arr[0]==arr[1]) return true;
       return false; 
    }
}

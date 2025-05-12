class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq=new int[10];
        for(int i=0;i<digits.length;i++){
            freq[digits[i]]++;
        }
        int[] ans=new int[451];
        int j=0;
        for(int i=100;i<=999;i+=2){
            boolean check=false;
            int n=i;
            int[] tempfreq=Arrays.copyOf(freq,10);
            while(n>0){
                int t=n%10;
                if(tempfreq[t]>0){
                    tempfreq[t]--;
                    check=true;
                }
                else{
                    check=false;
                    break;
                }
                n=n/10; 
            }
            if(check){
                ans[j]=i;
                j++;
            }
            

        }
        return Arrays.copyOf(ans,j);

        
    }
}
